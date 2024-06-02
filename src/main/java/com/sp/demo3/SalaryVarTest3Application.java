package com.sp.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.sp.demo3",
        "com.sp.module1",
        "com.sp.module2",
        "com.sp.vars",
}
 )
public class SalaryVarTest3Application {

    public static void main(String[] args) {
        SpringApplication.run(SalaryVarTest3Application.class, args);
    }

}
