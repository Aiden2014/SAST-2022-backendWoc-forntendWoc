package com.sast.woc.Exception;

import lombok.Data;


@Data
public class LocalRuntimeException extends RuntimeException{
    public LocalRuntimeException(String message){
        super(message);
    }

}
