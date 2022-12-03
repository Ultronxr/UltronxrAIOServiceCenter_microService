# Nacos 集群搭建

## 创建数据库

```mysql
CREATE DATABASE `nacos_config` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';
```

## 创建数据库表

运行 `/nacos-server-2.1.2/nacos/conf/mysql-schema.sql` 文件。

## 创建数据库用户

```mysql
CREATE USER `nacos`@`%` IDENTIFIED WITH caching_sha2_password BY 'xxx';
GRANT Alter, Alter Routine, Create, Create Routine, Create Temporary Tables, Create View, Delete, Drop, Event, Execute, Grant Option, Index, Insert, Lock Tables, References, Select, Show View, Trigger, Update ON `nacos_config`.* TO `nacos`@`%`;
```

若该用户仅限本地，则使用 `nacos@localhost`；若允许远程访问，则使用 `nacos@%` 。

## 修改配置文件

修改 `/nacos-server-2.1.2/nacos/conf/application.properties` 配置文件：

```properties
# ...
server.port=8999
# ...
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://xxx:xxx/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=true&serverTimezone=UTC
db.user.0=nacos
db.password.0=xxx
# ...
# 上面的配置文件都一眼看懂，下面的配置有关鉴权，参见 https://nacos.io/zh-cn/docs/auth.html
nacos.core.auth.system.type=nacos
nacos.core.auth.enabled=true
nacos.core.auth.caching.enabled=true
nacos.core.auth.enable.userAgentAuthWhite=false
nacos.core.auth.server.identity.key=serverIdentity
nacos.core.auth.server.identity.value=xxx
# ...
```

## 修改集群配置

创建文件 `/nacos-server-2.1.2/nacos/conf/cluster.conf` ：

```text
ip1:port1
ip2:port2
ip3:port3
```

IP地址填写 `ifconfig` 命令中的 `eth0` 对应的本地IP。

端口填写 `server.port` 配置端口。

## 修改启动配置

如果服务器内存不够，可以在启动命令中修改内存大小。

修改 `/nacos-server-2.1.2/nacos/bin/startup.sh` 文件：

```shell
# JAVA_OPT="${JAVA_OPT} -server -Xms2g -Xmx2g -Xmn1g -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
JAVA_OPT="${JAVA_OPT} -server -Xms1g -Xmx1g -Xmn512M -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=320m"
```

## 配置 Nginx 反向代理及白名单

`touch nginx/config/sites-available/nacos-server`

`ln -s nginx/config/sites-available/nacos-server nginx/conf/sites-enabled/nacos-server`

```config
server {
    listen 9000 ssl;
    listen [::]:9000 ssl;
    server_name xxx;

    ssl_certificate xxx.pem;
    ssl_certificate_key xxx.key;
    ssl_session_timeout 5m;
    ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
    ssl_prefer_server_ciphers on;

    if ($scheme = http) {
        return 301 https://$server_name$request_uri;
    }

    location / {
        proxy_set_header Host $http_host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_pass http://127.0.0.1:8999;
    }

    include firewall-conf/targeted-allow-ips.conf;
}
```

`mkdir nginx/config/firewall-conf`

`touch nginx/config/firewall-conf/targeted-allow-ips.conf`

```config
allow xxx.xxx.0.0/16;
deny all;
```

`systemctl restart nginx.service`

## 登录 web 控制台

访问 `https://ip:port/nacos` 进入 web 控制台，使用默认用户（用户名和密码都是 nacos ）登录；

修改用户密码。
