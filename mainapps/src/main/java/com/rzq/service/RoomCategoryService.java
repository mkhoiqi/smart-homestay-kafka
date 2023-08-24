package com.rzq.service;

import com.rzq.model.RoomCategoryCreateRequest;
import com.rzq.model.RoomCategoryCreateResponse;
import com.rzq.model.RoomCategoryGetDetailsResponse;
import com.rzq.model.RoomCategoryGetResponse;

import java.util.List;

public interface RoomCategoryService {
    public RoomCategoryCreateResponse create(String token, RoomCategoryCreateRequest request);
    public RoomCategoryCreateResponse update(String token, String id, RoomCategoryCreateRequest request);
    public RoomCategoryGetDetailsResponse getById(String token, String id);
    public List<RoomCategoryGetResponse> getAll(String token);
    public RoomCategoryGetResponse archive(String token, String id);
    public RoomCategoryGetResponse publish(String token, String id);
}
