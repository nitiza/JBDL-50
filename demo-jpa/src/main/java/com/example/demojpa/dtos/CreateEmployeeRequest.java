package com.example.demojpa.dtos;

import com.example.demojpa.models.Employee;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequest {

    @Min(1)
    private Integer id;

    @Max(60)
    @Min(18)
    @NotNull
    private Integer age;

    @NotBlank
    private String name;

    private String address;


    public Employee to() {
        return Employee.builder()
                .id(this.id)
                .name(this.name)
                .address(this.address)
                .age(this.age)
                .build();
    }




}
