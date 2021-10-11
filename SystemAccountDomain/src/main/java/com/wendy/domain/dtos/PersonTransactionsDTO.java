package com.wendy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wendy.domain.persistence.Person;
import com.wendy.domain.persistence.PersonTransactions;
import com.wendy.domain.persistence.TypeAccount;

import java.io.Serializable;

public class PersonTransactionsDTO implements Serializable {
    private TypeAccountDTO typeAccount;
    private PersonDto person;
    private double amount;
    private String transType;

    public PersonTransactionsDTO() {
    }

    public PersonTransactionsDTO(TypeAccountDTO typeAccount, PersonDto person, double amount, String transType) {
        this.typeAccount = typeAccount;
        this.person = person;
        this.amount = amount;
        this.transType = transType;
    }

    public PersonTransactionsDTO(PersonTransactions personTransactions){
        this.amount = personTransactions.getAmount();
        this.transType = personTransactions.getTransType();
        if(null!=personTransactions.getTypeAccount()){
            this.typeAccount = new TypeAccountDTO(personTransactions.getTypeAccount());
        }

        if(null!=personTransactions.getPerson()){
            this.person = new PersonDto(personTransactions.getPerson());
        }
    }

    @JsonIgnore
    public PersonTransactions buildTransaction(TypeAccount typeAccount,Person person){
        return new PersonTransactions(null,typeAccount,person,this.getAmount(),this.getTransType());
    }

    public TypeAccountDTO getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccountDTO typeAccount) {
        this.typeAccount = typeAccount;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "PersonTransactionsDTO{" +
                "typeAccount=" + typeAccount +
                ", person=" + person +
                ", amount=" + amount +
                ", transType='" + transType + '\'' +
                '}';
    }
}
