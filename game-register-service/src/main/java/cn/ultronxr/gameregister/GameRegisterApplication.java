package cn.ultronxr.gameregister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ultronxr
 * @date 2022/11/29 13:29
 * @description
 */
@SpringBootApplication
@MapperScan(basePackages = {"cn.ultronxr.gameregister.bean.mybatis.mapper"})
public class GameRegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameRegisterApplication.class, args);
    }
}
