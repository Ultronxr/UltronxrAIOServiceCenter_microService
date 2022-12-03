package cn.ultronxr.gameregister.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ultronxr
 * @date 2022/11/29 19:00
 * @description
 */
@Configuration
public class DruidConfig {

    private static final String WEB_USERNAME = "druid";
    private static final String WEB_PASSWORD = "druid";


    /**
     * Druid Web配置
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        servletRegistrationBean.addInitParameter("loginUsername", WEB_USERNAME);
        servletRegistrationBean.addInitParameter("loginPassword", WEB_PASSWORD);
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        // 访问白名单和黑名单
        //servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //servletRegistrationBean.addInitParameter("deny","127.0.0.1");

        return servletRegistrationBean;
    }

    /**
     * Druid Filter过滤器配置
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> statFilter(){
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
        // 设置过滤器路径
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
