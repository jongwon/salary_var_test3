package com.sp.module2;

import com.sp.vars.annotation.EnableSalaryVariables;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {
        TaxRateEvaluator.class
})
@EnableSalaryVariables( classes = {
        TaxRate.class
})
public class Module2Config {


}
