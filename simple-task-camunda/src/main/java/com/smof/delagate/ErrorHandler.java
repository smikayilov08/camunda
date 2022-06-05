package com.smof.delagate;

import com.smof.data.ErrorDTO;
import com.smof.helper.AbstractCommonDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



@Component("errorHandler")
public class ErrorHandler extends AbstractCommonDelegate {

    @Override
    public void doBusiness(DelegateExecution execution) {

        String message=execution.getVariable("globalErrorMessage").toString();
        execution.setVariable("result",new ErrorDTO(message, HttpStatus.resolve(404)));

    }
}
