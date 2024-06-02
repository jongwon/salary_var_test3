package com.sp.vars.annotation;


import com.sp.vars.SalaryVariableRegistrar;
import com.sp.vars.VariableEvaluator;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(java.lang.annotation.ElementType.TYPE)
@Import(SalaryVariableRegistrar.class)
public @interface EnableSalaryVariables {

    Class<?>[] classes();

}
