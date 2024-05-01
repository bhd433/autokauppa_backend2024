package com.example.demo.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface AutoRepository extends CrudRepository<Auto, Long>{

    
    //find by kauppa id
    List<Auto> findByKauppaKauppaid(long kauppaid);
}
