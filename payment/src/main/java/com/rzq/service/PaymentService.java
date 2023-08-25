package com.rzq.service;

import com.rzq.model.CreatePaymentRequest;
import com.rzq.model.PaymentDetailsRequest;
import com.rzq.model.PaymentDetailsResponse;
import com.rzq.model.kafka.messages.CreateVirtualAccountRequestMessage;

public interface PaymentService {
    public PaymentDetailsResponse create(CreateVirtualAccountRequestMessage request);
    public PaymentDetailsResponse update(PaymentDetailsRequest request);
    public PaymentDetailsResponse getById();
}
