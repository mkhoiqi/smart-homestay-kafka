package com.rzq.controller;

import com.rzq.model.*;
import com.rzq.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/api/v1/transactions/{id}")
    public WebResponse<TransactionGetDetailsResponse> getById(@RequestHeader(value = "X-API-TOKEN", required = false) String token, @PathVariable("id") String id){
        TransactionGetDetailsResponse response = transactionService.getById(token, id);
        return WebResponse.<TransactionGetDetailsResponse>builder()
                .data(response).build();
    }

    @GetMapping("/api/v1/transactions/myTransaction")
    public WebResponse<List<TransactionGetResponse>> myTransaction(@RequestHeader(value = "X-API-TOKEN", required = false) String token){
        List<TransactionGetResponse> responses = transactionService.getMyTransaction(token);
        return WebResponse.<List<TransactionGetResponse>>builder()
                .data(responses).build();
    }
    @GetMapping("/api/v1/transactions/allTransaction")
    public WebResponse<List<TransactionGetResponse>> allTransaction(@RequestHeader(value = "X-API-TOKEN", required = false) String token){
        List<TransactionGetResponse> responses = transactionService.getAllTransaction(token);
        return WebResponse.<List<TransactionGetResponse>>builder()
                .data(responses).build();
    }

    @PostMapping("/api/v1/transactions")
    public WebResponse<TransactionOrderResponse> order(@RequestHeader(value = "X-API-TOKEN", required = false) String token, @RequestBody TransactionOrderRequest request){
        TransactionOrderResponse response = transactionService.order(token, request);
        return WebResponse.<TransactionOrderResponse>builder()
                .data(response).build();
    }

    @PutMapping("/api/v1/transactions/{id}")
    public WebResponse<TransactionOrderResponse> approval(@RequestHeader(value = "X-API-TOKEN", required = false) String token, @PathVariable("id") String id, @RequestParam(value = "action", required = true) String action){
        TransactionOrderResponse response = transactionService.approval(token, id, action);
        return WebResponse.<TransactionOrderResponse>builder()
                .data(response).build();
    }

    @PostMapping("/api/v2/transactions")
    public WebResponse<TransactionOrderResponse> orderV2(@RequestHeader(value = "X-API-TOKEN", required = false) String token, @RequestBody TransactionOrderRequest request){
        TransactionOrderResponse response = transactionService.orderV2(token, request);
        return WebResponse.<TransactionOrderResponse>builder()
                .data(response).build();
    }

    @PutMapping("/api/v2/transactions/{id}")
    public WebResponse<TransactionOrderResponse> approvalV2(@RequestHeader(value = "X-API-TOKEN", required = false) String token, @PathVariable("id") String id, @RequestParam(value = "action", required = true) String action){
        TransactionOrderResponse response = transactionService.approval(token, id, action);
        return WebResponse.<TransactionOrderResponse>builder()
                .data(response).build();
    }
}
