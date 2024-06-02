package com.sp.module2;

import com.sp.vars.annotation.SalaryVariableTableClass;
import com.sp.vars.annotation.SalaryVariable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SalaryVariableTableClass("tax_rate")
public class TaxRate {

    private Long id;

    private int year;

    private double lower_bound;

    private double upper_bound;

    @SalaryVariable(value="tax_rate", description="세율", evaluator = TaxRateEvaluator.class)
    private double rate;

}
