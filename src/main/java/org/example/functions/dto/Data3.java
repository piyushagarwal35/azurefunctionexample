package org.example.functions.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Data3 {

    private String subscriptionId;
    private String subscriptionName;
    private List<String> dates;


}
