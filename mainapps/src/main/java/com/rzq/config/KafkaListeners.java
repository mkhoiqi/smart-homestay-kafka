package com.rzq.config;

import com.rzq.entity.User;
import com.rzq.model.UserDetailsResponse;
import com.rzq.model.UserTokenResponse;
import com.rzq.model.kafka.messages.CreateVirtualAccountResponseMessage;
import com.rzq.model.kafka.messages.PayVirtualAccountResponseMessage;
import com.rzq.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "virtual-account-response", groupId = "groupId")
public class KafkaListeners {

    @Autowired
    TransactionService transactionService;


    @KafkaHandler
    void listener(CreateVirtualAccountResponseMessage responseMessage){
        System.out.println("varesponse listener");
        transactionService.updateVirtualAccount(responseMessage);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }
}
