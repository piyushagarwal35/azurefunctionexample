package org.example.functions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CostResponse<T> {
    private String message;
    private T data;
    private List<Error> errors;


    public void addError(String code , String message){
        if(this.errors == null){
            this.errors = new ArrayList<>();
        }
        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);
        this.errors.add(error);
    }
}
