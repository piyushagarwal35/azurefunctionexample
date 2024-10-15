package org.example.functions.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Data3 {

    private String subscriptionId;
    private String subscriptionName;
    private List<String> dates;


}
