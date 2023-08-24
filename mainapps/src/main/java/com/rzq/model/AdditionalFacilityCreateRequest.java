package com.rzq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdditionalFacilityCreateRequest {
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotNull
    @Min(value = 0)
    private Long price;
}
