package com.sp.vars;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryVariableMetaData {

    private String variableName;

    private String description; // class name

    private String[] where;

    private Class<? extends VariableEvaluator> evaluatorClass;

    private VariableEvaluator evaluator; // bean ...

}
