package com.joing.mybatisplus;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Join.Yao (pathinfuture@163.com)
 * @date 2022/06/16 20:11
 */
@SpringBootTest
public class EncryptTest {

    @Resource
    private DataSource dataSource;

    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }


    @Test
    void test(){ //生成十六位随机AES密钥
        String randomKey= AES.generateRandomKey();
        System.out.println(randomKey);
    }

    @Test
    void test01() {
        //生成的十六位随机AES密钥
        String randomKey = "162f3312c1cc4444";

        //使用随机密钥加密需要加密的数据，列如数据库url,username,password
        String url = "jdbc:mysql://192.168.12.201:3306/mybatis_plus?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String username = "root";
        String password = "123456";
        String aesUrl = AES.encrypt(url, randomKey);
        String aesUsername = AES.encrypt(username, randomKey);
        String aesPassword = AES.encrypt(password, randomKey);
        System.out.println("url:"+aesUrl);
        System.out.println("username:"+aesUsername);
        System.out.println("password:"+aesPassword);
    }

}
