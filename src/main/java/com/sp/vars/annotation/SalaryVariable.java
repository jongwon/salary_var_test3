package com.sp.vars.annotation;


import com.sp.vars.VariableEvaluator;

import java.lang.annotation.Retention;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface SalaryVariable {

    String value(); // 급여 변수의 이름을 나타냅니다.

    String description(); // 급여 변수의 설명을 나타냅니다.

    String[] where() default {}; // 급여 변수의 조건을 나타냅니다.

    Class<? extends VariableEvaluator> evaluator(); // 급여 변수의 평가자를 나타냅니다.

}
