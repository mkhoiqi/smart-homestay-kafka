package com.rzq.service;

import com.rzq.model.RoomCreateRequest;
import com.rzq.model.RoomCreateResponse;
import com.rzq.model.RoomGetDetailsResponse;
import com.rzq.model.RoomGetResponse;

import java.util.List;

public interface RoomService {
    public RoomCreateResponse create(String token, RoomCreateRequest request);
    public RoomCreateResponse update(String token, String id, RoomCreateRequest request);
    public RoomGetDetailsResponse getById(String token, String id);
    public List<RoomGetResponse> getAll(String token, String roomCategory);
    public RoomGetResponse archive(String token, String id);
    public RoomGetResponse publish(String token, String id);
}
