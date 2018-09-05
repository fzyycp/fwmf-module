package cn.faury.fwmf.module.service.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.faury")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
