package com.rzq.service.impl;

import com.rzq.entity.Payment;
import com.rzq.model.PaymentDetailsRequest;
import com.rzq.model.PaymentDetailsResponse;
import com.rzq.model.kafka.messages.CreateVirtualAccountRequestMessage;
import com.rzq.model.kafka.messages.CreateVirtualAccountResponseMessage;
import com.rzq.model.kafka.messages.PayVirtualAccountResponseMessage;
import com.rzq.repository.PaymentRepository;
import com.rzq.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public PaymentDetailsResponse create(CreateVirtualAccountRequestMessage request) {
        LocalDateTime now = LocalDateTime.now();

        Payment payment = new Payment();
        payment.setVirtualAccount(UUID.randomUUID().toString());
        payment.setCreatedAt(now);
        payment.setUpdatedAt(now);
        payment.setStatus("New");
        payment.setAmount(request.getAmount());
        payment.setVirtualAccountExpiredAt(now.plusMinutes(30));
        paymentRepository.save(payment);

        System.out.println("siap kirim");


        kafkaTemplate.send("virtual-account-response", toCreateVirtualAccountResponseMessage(payment, request.getTransactionId()));
        System.out.println("sudah dikirim");

        return null;
    }

    @Override
    public PaymentDetailsResponse update(PaymentDetailsRequest request) {
        Optional<Payment> payment = paymentRepository.findById(request.getVirtualAccount());

        if(!payment.isEmpty()){
            Payment paymentData = payment.get();
            if(paymentData.getVirtualAccountExpiredAt().isBefore(LocalDateTime.now())){ //udah expired
                paymentData.setUpdatedAt(LocalDateTime.now());
                paymentData.setStatus("Failed");
            } else{
                paymentData.setUpdatedAt(LocalDateTime.now());
                paymentData.setStatus("Success");
                paymentData.setPayorNumber(request.getPayorNumber());
            }

            paymentRepository.save(paymentData);

            System.out.println("siap kirim");


            kafkaTemplate.send("pay-virtual-account", toPayVirtualAccountResponseMessage(paymentData));
            System.out.println("sudah dikirim");

        }
        return null;
    }

    @Override
    public PaymentDetailsResponse getById() {
        return null;
    }

    private CreateVirtualAccountResponseMessage toCreateVirtualAccountResponseMessage(Payment payment, String transactionId){

        return CreateVirtualAccountResponseMessage.builder()
                .virtualAccount(payment.getVirtualAccount())
                .amount(payment.getAmount())
                .payorNumber(payment.getPayorNumber())
                .status(payment.getStatus())
                .transactionId(transactionId)
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .virtualAccountExpiredAt(payment.getVirtualAccountExpiredAt()).build();
    }

    private PayVirtualAccountResponseMessage toPayVirtualAccountResponseMessage(Payment payment){

        return PayVirtualAccountResponseMessage.builder()
                .virtualAccount(payment.getVirtualAccount())
                .amount(payment.getAmount())
                .payorNumber(payment.getPayorNumber())
                .status(payment.getStatus())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .virtualAccountExpiredAt(payment.getVirtualAccountExpiredAt()).build();
    }
}
