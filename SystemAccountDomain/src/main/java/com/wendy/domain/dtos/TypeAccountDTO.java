package com.wendy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wendy.domain.persistence.TypeAccount;

import java.io.Serializable;
import java.time.LocalDate;

public class TypeAccountDTO implements Serializable {
    private String name;
    private String nmonic;

    public TypeAccountDTO() {
    }

    public TypeAccountDTO(String name, String nmonic) {
        this.name = name;
        this.nmonic = nmonic;
    }

    public TypeAccountDTO(TypeAccount typeAccount){
        this.name = typeAccount.getName();
        this.nmonic = typeAccount.getNmonic();
    }

    @JsonIgnore
    public TypeAccount buildTypeaccount(TypeAccountDTO  typeAccountDTO){
        return new TypeAccount(null,this.getName(),this.getNmonic(),LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNmonic() {
        return nmonic;
    }

    public void setNmonic(String nmonic) {
        this.nmonic = nmonic;
    }

    @Override
    public String toString() {
        return "TypeAccountDTO{" +
                "name='" + name + '\'' +
                ", nmonic='" + nmonic + '\'' +
                '}';
    }
}
