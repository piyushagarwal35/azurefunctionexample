package org.example.functions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.functions.model.FocusExport;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Api6Request {

    private String subscriptionId;
    private String subscriptionName;
    private List<FocusExport> usageMetrics;

}
