package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.domain.Auto;
import com.example.demo.domain.AutoRepository;
import com.example.demo.domain.Kauppa;
import com.example.demo.domain.KauppaRepository;
import com.example.demo.web.CarController;



@ExtendWith(SpringExtension.class) 
@SpringBootTest
public class CarTests {


@Autowired
private CarController carController;
@Autowired
private AutoRepository carRepository;
@Autowired
private KauppaRepository kauppaRepository;


@Test // lataako car controlleri
public void carControllerLoads() throws Exception {
assertThat(carController).isNotNull();
} 


@Test // toimiiko uuden auton luonti ja tallennus auto repositoryyn
public void createNewCar() {
Auto auto = new Auto();

carRepository.save(auto);
assertThat(auto.getId()).isNotNull();
} 


@Test // toimiiko myyjän luonti ja tallennus myyjä repositoryyn
public void createKauppa() {
Kauppa kauppa = new Kauppa();
kauppaRepository.save(kauppa);
assertThat(kauppa.getKauppaid()).isNotNull();
} 


@Test // onnistuuko auton luominen ja löytyykö siihen liittyvä kauppa
public void carsKauppa() {

    Kauppa kauppa = new Kauppa("Testi kauppa", "Testitie 6");
    kauppaRepository.save(kauppa);
    
    Auto auto = new Auto("Volkswagen", "Testi", 2015, 14000, kauppa);
    
    carRepository.save(auto);
    assertThat(auto.getKauppa()).isNotNull();
    } 
}