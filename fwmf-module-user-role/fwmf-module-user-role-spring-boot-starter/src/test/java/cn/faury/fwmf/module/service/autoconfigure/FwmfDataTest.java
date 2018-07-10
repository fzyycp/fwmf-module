package cn.faury.fwmf.module.service.autoconfigure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.junit.Test;

public class FwmfDataTest {
    public static final String algorithm = "PBEWithMD5AndDES";
    public static final String salt = "OC5pSswBN";

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
        String password = "JZkH5bu2/qQpVokeEyZbsmZ0bFuuBzlUnm7e54uKRJxbx2Ue9dW0kYvdY3y1JOXiWUqJGDNRiNfpUj8QzVl1KWMtXYmR8uAlUV0FB0hZ7sY=";
        //解密
        System.out.println(password + " : " + decrypt(password));
    }

    private String  encrypt(String password){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(salt);
        encryptor.setConfig(config);
        return encryptor.encrypt(password);
    }
    private String decrypt(String encPassword){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm(algorithm);
        config.setPassword(salt);
        encryptor.setConfig(config);
        return encryptor.decrypt(encPassword);
    }
}
