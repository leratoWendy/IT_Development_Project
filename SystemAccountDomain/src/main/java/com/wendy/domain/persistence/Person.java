package com.wendy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Persons")
public class Person implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phonenumber;
    private int age;
    private Miles miles;
    private Set<PersonTransactions> personTransactionsSet;

    public Person() {
    }

    public Person(Long id, String name, String surname, String email, String phonenumber, int age,Miles miles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.age = age;
        this.miles = miles;
    }

    public Person(Long id, String name, String surname, String email, String phonenumber, int age, Miles miles, Set<PersonTransactions> personTransactionsSet) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.age = age;
        this.miles = miles;
        this.personTransactionsSet = personTransactionsSet;
    }

    @Id
    @SequenceGenerator(name="SEQ_Person",sequenceName = "Person_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Person")
    @Column(name = "person_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "phone_number")
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToOne(targetEntity = Miles.class, fetch = FetchType.LAZY,optional = true, mappedBy = "person", cascade = CascadeType.PERSIST)
    public Miles getMiles() {
        return miles;
    }

    public void setMiles(Miles miles) {
        this.miles = miles;
    }

    @OneToMany(targetEntity = PersonTransactions.class, fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    public Set<PersonTransactions> getPersonTransactionsSet() {
        return personTransactionsSet;
    }

    public void setPersonTransactionsSet(Set<PersonTransactions> personTransactionsSet) {
        this.personTransactionsSet = personTransactionsSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(email, person.email) && Objects.equals(phonenumber, person.phonenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, phonenumber, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age=" + age +
                '}';
    }
}
