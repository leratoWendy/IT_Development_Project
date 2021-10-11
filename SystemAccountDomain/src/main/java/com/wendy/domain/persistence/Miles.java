package com.wendy.domain.persistence;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Miles")
public class Miles implements Serializable{
    private Long milesID;
    private int NumOfMiles;
    private  int spending;
    private  int healthandsafety;
    private  int driving;
    private Person person;


    public Miles() {
    }

    public Miles(Long milesID, int numOfMiles, int spending, int healthandsafety, int driving, Person person) {
        this.milesID = milesID;
        NumOfMiles = numOfMiles;
        this.spending = spending;
        this.healthandsafety = healthandsafety;
        this.driving = driving;
        this.person = person;
    }

    @Id
    @SequenceGenerator(name="SEQ_Miles",sequenceName = "Miles_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Miles")
    @Column(name = "miles_id")
    public Long getMilesID() {
        return milesID;
    }

    public void setMilesID(Long milesID) {
        this.milesID = milesID;
    }

    @Column(name = "miles")
    public int getNumOfMiles() {
        return NumOfMiles;
    }

    public void setNumOfMiles(int numOfMiles) {
        NumOfMiles = numOfMiles;
    }

    @Column(name = "spending")
    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }

    @Column(name = "healthandsafety")
    public int getHealthandsafety() {
        return healthandsafety;
    }

    public void setHealthandsafety(int healthandsafety) {
        this.healthandsafety = healthandsafety;
    }

    @Column(name = "driving")
    public int getDriving() {
        return driving;
    }

    public void setDriving(int driving) {
        this.driving = driving;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Miles miles = (Miles) o;
        return NumOfMiles == miles.NumOfMiles && spending == miles.spending && healthandsafety == miles.healthandsafety && driving == miles.driving && Objects.equals(milesID, miles.milesID) && Objects.equals(person, miles.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(milesID, NumOfMiles, spending, healthandsafety, driving, person);
    }

    @Override
    public String toString() {
        return "Miles{" +
                "milesID=" + milesID +
                ", NumOfMiles=" + NumOfMiles +
                ", spending=" + spending +
                ", healthandsafety=" + healthandsafety +
                ", driving=" + driving +
                ", person=" + person +
                '}';
    }
}
