package com.sp.module2;

import com.sp.vars.VariableEvaluator;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class TaxRateEvaluator implements VariableEvaluator {

    // repository

    @Override
    public Double evaluate(Map<String, Object> context) {

        // select tax rate from db where year :=?year and lower_limit, upper_limit ...

        return 0.02;
    }


}
