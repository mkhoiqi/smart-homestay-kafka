package com.rzq.service;

import com.rzq.model.TransactionGetDetailsResponse;
import com.rzq.model.TransactionGetResponse;
import com.rzq.model.TransactionOrderRequest;
import com.rzq.model.TransactionOrderResponse;
import com.rzq.model.kafka.messages.CreateVirtualAccountResponseMessage;
import com.rzq.model.kafka.messages.PayVirtualAccountResponseMessage;

import java.util.List;

public interface TransactionService {
    public TransactionGetDetailsResponse getById(String token, String id);
    public List<TransactionGetResponse> getMyTransaction(String token);
    public List<TransactionGetResponse> getAllTransaction(String token);
    public TransactionOrderResponse order(String token, TransactionOrderRequest request);
    public TransactionOrderResponse approval(String token, String id, String action);
    public TransactionOrderResponse orderV2(String token, TransactionOrderRequest request);
    public TransactionOrderResponse approvalV1(String token, String id, String action);

    public String updateVirtualAccount(CreateVirtualAccountResponseMessage responseMessage);
    public String updateStatusVa(PayVirtualAccountResponseMessage responseMessage);
}
