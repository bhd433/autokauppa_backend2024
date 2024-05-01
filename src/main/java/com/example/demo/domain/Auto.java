package com.example.demo.domain;

import java.util.Locale.Category;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Auto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand;
    private String model;
    private int carYear;
    private double price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "kauppaid")
    private Kauppa kauppa;



    public Auto() {
    };

    public Auto(String brand, String model, int year, int price, Kauppa kauppa) {
        this.brand = brand;
        this.model = model;
        this.carYear = year;
        this.price = price;
        this.kauppa = kauppa;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int year) {
        this.carYear = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Kauppa getKauppa() {
        return kauppa;
    }

    public void setKauppa(Kauppa kauppa) {
        this.kauppa = kauppa;
    }


    @Override
    public String toString() {
        return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + carYear + ", price=" + price + "]";
    }

}
