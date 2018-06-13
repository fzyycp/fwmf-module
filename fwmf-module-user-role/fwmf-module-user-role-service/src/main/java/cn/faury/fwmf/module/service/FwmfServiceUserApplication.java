package cn.faury.fwmf.module.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.faury")
public class FwmfServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwmfServiceUserApplication.class, args);
    }
}
