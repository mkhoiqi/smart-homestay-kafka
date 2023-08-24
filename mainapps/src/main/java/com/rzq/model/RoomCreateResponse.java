package com.rzq.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rzq.entity.Facility;
import com.rzq.entity.Room;
import com.rzq.entity.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomCreateResponse {
    private String id;

    @JsonProperty("number_of_rooms")
    private Integer numberOfRooms;

    private Long price;

    @JsonProperty("room_category")
    private RoomCategoryCreateResponse roomCategory;

    private Set<FacilityCreateResponse> facilities;
}
