package com.sp.vars;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        SalaryVariableProcessor.class
})
public class VarsConfig {


}
