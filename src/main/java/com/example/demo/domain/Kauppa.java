package com.example.demo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Kauppa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kauppaid;
    private String nimi;
    private String osoite;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kauppa")
    private List<Auto> cars;

    public Kauppa(String nimi, String osoite) {
        this.nimi = nimi;
        this.osoite = osoite;
    }

    public Kauppa() {
    };


    
    public String getNimi() {
        return nimi;
    }

    public long getKauppaid() {
        return kauppaid;
    }

    public void setKauppaid(long kauppaid) {
        this.kauppaid = kauppaid;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public List<Auto> getCars() {
        return cars;
    }

    public void setCars(List<Auto> cars) {
        this.cars = cars;
    }


    @Override
    public String toString() {
        return "Kauppa [kauppaid=" + kauppaid + ", nimi=" + nimi + ", osoite=" + osoite + "]";
    }
}
