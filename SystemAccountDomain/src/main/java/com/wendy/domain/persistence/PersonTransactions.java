package com.wendy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "Person_Transactions")
public class PersonTransactions implements Serializable {
    private Long id;
    private TypeAccount typeAccount;
    private Person person;
    private double amount;
    private String transType;


    public PersonTransactions() {
    }

    public PersonTransactions(Long id, TypeAccount typeAccount, Person person, double amount, String transType) {
        this.id = id;
        this.typeAccount = typeAccount;
        this.person = person;
        this.amount = amount;
        this.transType = transType;
    }

    @Id
    @SequenceGenerator(name="SEQ_Transactions",sequenceName = "Transaction_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Transactions")
    @Column(name = "transaction_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_account_id")
    public TypeAccount getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(TypeAccount typeAccount) {
        this.typeAccount = typeAccount;
    }


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "type")
    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonTransactions that = (PersonTransactions) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(typeAccount, that.typeAccount) && Objects.equals(person, that.person) && Objects.equals(transType, that.transType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeAccount, person, amount, transType);
    }

    @Override
    public String toString() {
        return "PersonTransactions{" +
                "id=" + id +
                ", typeAccount=" + typeAccount +
                ", person=" + person +
                ", amount=" + amount +
                ", transType='" + transType + '\'' +
                '}';
    }
}


