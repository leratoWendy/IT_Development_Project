package com.wendy.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Rewards")
public class Rewards implements Serializable{
    private Long voucherID;
    private String category;
    private String name;
    private int price;

    public Rewards() {

    }

    public Rewards(Long voucherID, String category, String name, int price) {
        this.voucherID = voucherID;
        this.category = category;
        this.name = name;
        this.price = price;
    }

    @Id
    @SequenceGenerator(name="SEQ_Rewards",sequenceName = "Rewards_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_Rewards")
    @Column(name = "reward_id")
    public Long getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Long voucherID) {
        this.voucherID = voucherID;
    }

    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column(name = "reward_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "reward_price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return price == rewards.price && Objects.equals(voucherID, rewards.voucherID) && Objects.equals(category, rewards.category) && Objects.equals(name, rewards.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherID, category, name, price);
    }


    @Override
    public String toString() {
        return "Rewards{" +
                "voucherID=" + voucherID +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
