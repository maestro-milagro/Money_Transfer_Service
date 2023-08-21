package com.milagro.springmoneytransferservice.exceptions;

public class InvalidOperationCode extends Throwable{
    public InvalidOperationCode(String msg){
        super(msg);
    }
}
