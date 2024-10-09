package org.example.functions.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Error {
    private String code;
    private String message;
}
