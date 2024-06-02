package com.sp.module1;


import com.sp.vars.VariableEvaluator;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class SenioritySalaryEvaluator implements VariableEvaluator {

    // repository

    @Override
    public Double evaluate(Map<String, Object> context) {

        return 0.0;
    }

}
