package com.smof.helper;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public abstract class AbstractCommonDelegate implements JavaDelegate {

    DelegateExecution delegateExecution;

    @Override
    public void execute(DelegateExecution delegateExecution){
        try {
            this.delegateExecution=delegateExecution;
            doBusiness(delegateExecution);
        } catch (BpmnError e) {
            throw new BpmnError("-1","Internal Error");
        }
        catch (Exception e){

        }
    }
    public abstract void doBusiness(DelegateExecution execution);

    public <T> T getVariable(String name){
        return (T)delegateExecution.getVariable(name);
    }
}
