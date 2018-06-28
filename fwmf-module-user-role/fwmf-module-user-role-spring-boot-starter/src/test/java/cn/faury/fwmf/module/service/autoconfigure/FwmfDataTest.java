package cn.faury.fwmf.module.service.autoconfigure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;

public class FwmfDataTest {

    @Test
    public void jasyptPBEStringEncryptionTest(){
        // 输入原文密码
        String password = "Fw1234mF";
        System.out.println(password + " : " + encrypt(password));

        password = "jdbc:mysql://rds39f843rei3e43sn05o.mysql.rds.aliyuncs.com:3306/fwmf";
        System.out.println(password + " : " + encrypt(password));
    }
    @Test
    public void jasyptPBEStringDecryptionTest(){
        // 输入原文密码
        String password = "4YUtqMernWOp419ALppM8w==";
        //解密
        System.out.println(password + " : " + decrypt(password));
    }

    private String  encrypt(String password){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("OC5pSswBN");
        encryptor.setConfig(config);
        return encryptor.encrypt(password);
    }
    private String decrypt(String encPassword){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPassword("OC5pSswBN");
        encryptor.setConfig(config);
        return encryptor.decrypt(encPassword);
    }
}
