package com.sp.vars.annotation;


import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Import(com.sp.vars.SalaryVariableRegistrar.class)
public @interface SalaryVariableTableClass {


    String value();

}
