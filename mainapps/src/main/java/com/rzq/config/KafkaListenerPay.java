package com.rzq.config;

import com.rzq.model.kafka.messages.PayVirtualAccountResponseMessage;
import com.rzq.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "pay-virtual-account", groupId = "groupId")
public class KafkaListenerPay {

    @Autowired
    TransactionService transactionService;

    @KafkaHandler
    void listener(PayVirtualAccountResponseMessage responseMessage){
        System.out.println("varesponse listener updatestatus");
        transactionService.updateStatusVa(responseMessage);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }
}
