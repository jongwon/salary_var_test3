package com.sp.module1;

import com.sp.vars.annotation.SalaryVariableTableClass;
import com.sp.vars.annotation.SalaryVariable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 직급비
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SalaryVariableTableClass("seniority_salary")
public class SenioritySalary {

    private Long id;

    // 직급
    private String position;

    // 근속년수
    private int yearsOfService;

    // 직급수당
    @SalaryVariable(value="seniority_salary", description="직급수당", evaluator = SenioritySalaryEvaluator.class)
    private double salary;

}
