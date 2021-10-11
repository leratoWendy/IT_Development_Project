package com.wendy.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GetResponse <R> implements Serializable {
    private final boolean succesful;
    private final transient  R payload;

    public GetResponse(boolean succesful, R payload){
        this.succesful = succesful;
        this.payload = payload;
    }
    public boolean isSuccesful(){
        return succesful;
    }

    public R getPayload() {
        return payload;
    }
    @Override
    public boolean equals(Object O){
        if(this == O) return true;
        if(O == null || getClass()!= O.getClass()) return false;
        return succesful == this.succesful && Objects.equals(payload, this.payload);
    }
    @Override
    public int hashCode(){return Objects.hash(succesful,payload);}

    @Override
    public String toString(){
        return "GetResponse{" +
                "succesful =" + succesful +
                "payload =" + payload+
                "}";
    }
}
