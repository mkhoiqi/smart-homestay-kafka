package com.rzq.config;

import com.rzq.model.kafka.messages.CreateVirtualAccountRequestMessage;
import com.rzq.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "virtual-account", groupId = "groupId")
public class KafkaListeners {

    @Autowired
    PaymentService paymentService;

    @KafkaHandler
    void listenerDetails(CreateVirtualAccountRequestMessage requestMessage){
        System.out.println(requestMessage);
        System.out.println("Listener received details transactionid: "+ requestMessage.getTransactionId() + "hehe");
        System.out.println("Listener received details amount: "+ requestMessage.getAmount() + "hehe");
        paymentService.create(requestMessage);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }
}
