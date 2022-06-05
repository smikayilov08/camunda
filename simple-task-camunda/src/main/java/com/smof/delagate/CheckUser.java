package com.smof.delagate;

import com.smof.helper.AbstractCommonDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import javax.inject.Named;

@Named
public class CheckUser extends AbstractCommonDelegate {

    @Override
    public void doBusiness(DelegateExecution delegateExecution){

        String userName=(String)delegateExecution.getVariable("userName");

        if (userName.equals("User")){
        delegateExecution.setVariable("checkUser",true);
        }
        else{
            delegateExecution.setVariable("checkUser",false);
        }
    }

}
