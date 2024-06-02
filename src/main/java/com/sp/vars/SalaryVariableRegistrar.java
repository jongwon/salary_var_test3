package com.sp.vars;

import com.sp.vars.annotation.EnableSalaryVariables;
import com.sp.vars.annotation.SalaryVariable;
import com.sp.vars.annotation.SalaryVariableTableClass;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SalaryVariableRegistrar implements ImportBeanDefinitionRegistrar {


    static Map<String, SalaryVariableMetaData> metaDataMap = new HashMap<>();

    public void registerBeanDefinitions(AnnotationMetadata configMetaData, BeanDefinitionRegistry registry) {
        System.out.println("Registering beans =========== "+configMetaData.getClassName());

        Map<String, Object> attributes = configMetaData.getAnnotationAttributes(EnableSalaryVariables.class.getName());
        Class<?>[] classes = (Class<?>[]) attributes.get("classes");

        for (Class<?> clazz : classes) {
            System.out.println("Registered bean: " + clazz.getSimpleName());

            if(clazz.isAnnotationPresent(SalaryVariableTableClass.class)) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(SalaryVariable.class)) {
                        SalaryVariable variable = field.getAnnotation(SalaryVariable.class);

                        String var_name = variable.value();
                        Class<? extends VariableEvaluator> evaluatorClass = variable.evaluator();

                        // TODO : 설정에 필요한 사항이 있으면 여기에 더 추가한다.
                        SalaryVariableMetaData metaData = SalaryVariableMetaData.builder()
                                .variableName(var_name)
                                .evaluatorClass(evaluatorClass)
                                .where(variable.where())
                                .description(clazz.getSimpleName())
                                .build();

                        metaDataMap.put(var_name, metaData);
                        System.out.println("Annotation value: " + metaData);
                    }
                }

            }

        }
    }

}
