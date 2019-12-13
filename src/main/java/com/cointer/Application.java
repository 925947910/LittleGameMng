package com.cointer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//https://cloud.tencent.com/developer/article/1360699
//https://www.cnblogs.com/yliucnblogs/p/9881540.html
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.cointer.mapper")
public class Application {
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }
}
