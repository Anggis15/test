package com.testCoding.intiCorpora.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateContactRequest {
    private String address;
    private String userId;
}
