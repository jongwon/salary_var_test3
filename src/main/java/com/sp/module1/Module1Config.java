package com.sp.module1;


import com.sp.vars.annotation.EnableSalaryVariables;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        SenioritySalaryEvaluator.class
})
@EnableSalaryVariables( classes = {
        SenioritySalary.class
})
public class Module1Config {
}
