package com.sp.vars;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Component
public class SalaryVariableProcessor implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    @Setter
    private ApplicationContext applicationContext;

    private Map<String, VariableEvaluator> evaluatorMap = new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("============  application context refreshed... ========= "+event.getClass());

        SalaryVariableRegistrar.metaDataMap.forEach((varName, metaData) -> {
            try {
                VariableEvaluator evaluator = applicationContext.getBean(metaData.getEvaluatorClass());
                metaData.setEvaluator(evaluator);
                evaluatorMap.put(varName, evaluator);
                log.info("Registered evaluator: " + metaData.getDescription() + " : " + metaData.getEvaluator().getClass().getSimpleName());
            } catch (Exception e) {
                throw new RuntimeException("Failed to instantiate evaluator for " + metaData.getDescription(), e);
            }
        });

    }


    public void applyVariable(String variable, Map<String, Object> context) {
        VariableEvaluator evaluator = evaluatorMap.get(variable);
        if(evaluator == null) {
            throw new RuntimeException("No evaluator found for variable: " + variable);
        }
        double value = evaluator.evaluate(context);
        context.put(variable, value);
    }


}
