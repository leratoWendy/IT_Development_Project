package com.wendy.domain.dtos;

import com.wendy.domain.persistence.Miles;
import com.wendy.domain.persistence.Person;

import java.io.Serializable;

public class MilesDto implements Serializable {
    private int NumOfMiles;
    private  int spending;
    private  int healthandsafety;
    private  int driving;

    public MilesDto() {
    }

    public MilesDto(Miles personDto){
        this.NumOfMiles = personDto.getNumOfMiles();
        this.spending = personDto.getSpending();
        this.healthandsafety = personDto.getHealthandsafety();
        this.driving = personDto.getDriving();
    }

    public Miles buildMiles(PersonDto personDto){
        return new Miles(null,this.getNumOfMiles(),this.getSpending(),this.getHealthandsafety(),this.getDriving(),personDto.buildPerson(personDto));
    }

    public MilesDto(int numOfMiles, int spending, int healthandsafety, int driving, Person person) {
        NumOfMiles = numOfMiles;
        this.spending = spending;
        this.healthandsafety = healthandsafety;
        this.driving = driving;
    }

    public int getNumOfMiles() {
        return NumOfMiles;
    }

    public void setNumOfMiles(int numOfMiles) {
        NumOfMiles = numOfMiles;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }

    public int getHealthandsafety() {
        return healthandsafety;
    }

    public void setHealthandsafety(int healthandsafety) {
        this.healthandsafety = healthandsafety;
    }

    public int getDriving() {
        return driving;
    }

    public void setDriving(int driving) {
        this.driving = driving;
    }


    @Override
    public String toString() {
        return "MilesDto{" +
                "NumOfMiles=" + NumOfMiles +
                ", spending=" + spending +
                ", healthandsafety=" + healthandsafety +
                ", driving=" + driving +
                '}';
    }
}
