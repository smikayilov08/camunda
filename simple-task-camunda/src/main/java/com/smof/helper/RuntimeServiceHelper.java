package com.smof.helper;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RuntimeServiceHelper {

    @Autowired
    private RuntimeService runtimeService;

    public ProcessInstanceWithVariables process(String key, String request) {
        return runtimeService.createProcessInstanceByKey(key)
                .setVariable("userName", request)
                .executeWithVariablesInReturn();
    }

    public <T> T getVairable(VariableMap map, Class<T> clazz) {
        return map.getValue("result", clazz);
    }

    public <T> ResponseEntity executeAndReturn(String key, String request, Class<T> clazz) {

        return new ResponseEntity(getVairable(process(key, request).getVariables(), clazz), HttpStatus.OK);

    }
}
