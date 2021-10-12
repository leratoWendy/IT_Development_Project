package com.wendy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wendy.domain.persistence.Person;

import java.io.Serializable;

public class PersonDto implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String phonenumber;
    private int age;
    private MilesDto milesDto;

    public PersonDto() {
    }

    public PersonDto(String name, String surname, String email, String phonenumber, int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public PersonDto(String name, String surname, String email, String phonenumber, int age, MilesDto milesDto) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.age = age;
        this.milesDto = milesDto;
    }

    public PersonDto(Person person){
        this.name = person.getName();
        this.surname = person.getSurname();
        this.email = person.getEmail();
        this.phonenumber = person.getPhonenumber();
        this.age = person.getAge();
        if(null != person.getMiles()){
            this.milesDto = new MilesDto(person.getMiles());
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MilesDto getMilesDto() {
        return milesDto;
    }

    public void setMilesDto(MilesDto milesDto) {
        this.milesDto = milesDto;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age=" + age +
                '}';
    }
}
