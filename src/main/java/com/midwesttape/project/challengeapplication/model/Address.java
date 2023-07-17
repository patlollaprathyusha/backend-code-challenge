package com.midwesttape.project.challengeapplication.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Address {
    private Long id;
    private String address1;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String address2;
    private String city;
    private String state;
    private String postal;
}