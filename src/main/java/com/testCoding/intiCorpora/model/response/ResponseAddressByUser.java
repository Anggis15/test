package com.testCoding.intiCorpora.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAddressByUser {
    private String id;
    private String address;
}
