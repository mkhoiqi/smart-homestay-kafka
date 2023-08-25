package com.rzq.controller;

import com.rzq.model.PaymentDetailsRequest;
import com.rzq.model.PaymentDetailsResponse;
import com.rzq.model.WebResponse;
import com.rzq.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("")
    public WebResponse<PaymentDetailsResponse> pay(@RequestBody PaymentDetailsRequest request){
        PaymentDetailsResponse response = paymentService.update(request);
        return WebResponse.<PaymentDetailsResponse>builder()
                .data(response).build();
    }
}
