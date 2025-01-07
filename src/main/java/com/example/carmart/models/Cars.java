package com.example.carmart.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class
Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String brand;
    public String model;
    public String caryear;
    public int noofkms;
    public int price;
    public String fuel;

    protected Cars() {}

    public Cars(String brand, String model, String caryear, int noofkms, int price, String fuel) {
        this.brand = brand;
        this.model = model;
        this.caryear = caryear;
        this.noofkms = noofkms;
        this.price = price;
        this.fuel = fuel;
    }



    public String toString() {
        return String.format("Cars[Id=%s, Brand=%s, Model=%s, Year=%s,NoOfKms=%s,Price=%s,Fuel=%s]",
                id, brand, model, caryear, noofkms, price, fuel);
    }

}
