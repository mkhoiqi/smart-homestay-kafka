package com.rzq.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "smarthomestay", groupId = "groupId")
    void listener(String data){
        System.out.println(data);
//        System.out.println("Listener received: "+ data + "hehe");
    }
}
