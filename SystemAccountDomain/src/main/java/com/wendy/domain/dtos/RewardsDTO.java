package com.wendy.domain.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wendy.domain.persistence.Rewards;

import java.io.Serializable;

public class RewardsDTO implements Serializable {
    private String category;
    private String name;
    private int price;

    public RewardsDTO() {
    }

    public RewardsDTO(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public RewardsDTO(Rewards rewards){
        this.category = rewards.getCategory();
        this.name = rewards.getName();
        this.price = rewards.getPrice();
    }

    @JsonIgnore
    public Rewards buildRewards(RewardsDTO rewardsDTO){
        return new Rewards(null,this.getCategory(),this.getName(),this.getPrice());
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RewardsDTO{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
