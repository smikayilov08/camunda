package com.smof.delagate;

import com.smof.data.UserDTO;
import com.smof.helper.AbstractCommonDelegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import javax.inject.Named;

@Named
public class UserInformation extends AbstractCommonDelegate {

    @Override
    public void doBusiness(DelegateExecution delegateExecution){

        String userName=delegateExecution.getVariable("userName").toString();
        String userPassword="abcd123";
        delegateExecution.setVariable("result",new UserDTO(userName,userPassword));

//        ObjectValue customerDataValue = Variables.objectValue(new UserDTO(userName,userPassword))
//                .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
//                .create();

//        delegateExecution.setVariable("result",customerDataValue);
    }
}
