package com.example.demojpa.dtos;


import com.example.demojpa.models.Admin;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAdminRequest {

    @NotBlank
    private String name;

    public Admin to(){
        return Admin.builder()
                .name(this.name)
                .build();
    }
}
