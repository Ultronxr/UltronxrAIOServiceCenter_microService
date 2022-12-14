CREATE DATABASE `ultronxr_aio_service_center` DEFAULT CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';

CREATE TABLE game_register_service_account (
    `id` INT NOT NULL AUTO_INCREMENT COMMENT '账户ID，主键自增',
    `nick` VARCHAR(255) DEFAULT NULL COMMENT '账户名称',
    `username` VARCHAR(255) DEFAULT NULL COMMENT '账户登录名称',
    `email` VARCHAR(255) DEFAULT NULL COMMENT '关联邮箱',
    `phone` VARCHAR(255) DEFAULT NULL COMMENT '关联手机号',
    `platform` VARCHAR(255) DEFAULT NULL COMMENT '平台，PC/Android等',
    `shop` VARCHAR(255) DEFAULT NULL COMMENT '游戏商城，Steam/Epic/Uplay/Origin等',
    `region` VARCHAR(255) DEFAULT NULL COMMENT '账户所属地区',
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT 'game-register-service 游戏账户表';

CREATE TABLE game_register_service_game (
     `id` INT NOT NULL AUTO_INCREMENT COMMENT '游戏ID，主键自增',
     `name` VARCHAR(255) DEFAULT NULL COMMENT '游戏名',
     `name_eng` VARCHAR(255) DEFAULT NULL COMMENT '游戏名-英文',
     `name_nick` VARCHAR(255) DEFAULT NULL COMMENT '游戏名-别名',
     `name_bak` VARCHAR(255) DEFAULT NULL COMMENT '游戏名-备注',
     `description` VARCHAR(255) DEFAULT NULL COMMENT '描述',
     `tag` VARCHAR(255) DEFAULT NULL COMMENT '标签，使用英文逗号,分割',
     `url` VARCHAR(255) DEFAULT NULL COMMENT '游戏链接',
     `logo` VARCHAR(255) DEFAULT NULL COMMENT 'logo链接',
     `img` VARCHAR(255) DEFAULT NULL COMMENT '大图链接',
     `developer` VARCHAR(255) DEFAULT NULL COMMENT '开发商',
     `publisher` VARCHAR(255) DEFAULT NULL COMMENT '发行商',
     `lowest_price_currency` VARCHAR(255) DEFAULT NULL COMMENT '史低价格货币种类，默认人民币',
     `lowest_price` DECIMAL(6,4) DEFAULT NULL COMMENT '史低价格',
     `lowest_price_rmb` DECIMAL(6,4) DEFAULT NULL COMMENT '换算成人民币的史低价格',
     `bought_account_id` INT DEFAULT NULL COMMENT '购买此游戏的账户ID，关联字段[game_register_service_account]-[id]',
     `purchase_date` DATE DEFAULT NULL COMMENT '购买此游戏的日期',
     `purchase_price_currency` VARCHAR(255) DEFAULT NULL COMMENT '购买此游戏的货币种类，默认人民币',
     `purchase_price` DECIMAL(6,4) DEFAULT NULL COMMENT '购买此游戏的价格',
     `purchase_price_rmb` DECIMAL(6,4) DEFAULT NULL COMMENT '换算成人民币的购买此游戏的价格',
     `actual_shop` VARCHAR(255) DEFAULT NULL COMMENT '实际游玩的商城（这个商城和账户的商城有所区分，例如steam上购买的游戏实际需要通过origin打开游戏）',
     PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT 'game-register-service 已购买的游戏信息表';

