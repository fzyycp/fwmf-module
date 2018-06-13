package cn.faury.fwmf.module.service.autoconfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.faury")
public class StartDemonApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartDemonApplication.class, args);
    }
}
