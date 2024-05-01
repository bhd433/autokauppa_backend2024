package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.domain.Auto;
import com.example.demo.domain.AutoRepository;
import com.example.demo.domain.Kauppa;
import com.example.demo.domain.KauppaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class KauppaController {
    

    @Autowired
    KauppaRepository kauppaRepository;

    @Autowired
    AutoRepository autoRepository;


    // myyjä listaus
    @GetMapping("/shoplist")
    public String shoplist(Model model) {

        model.addAttribute("kaupat", kauppaRepository.findAll());
        return "shoplist";
    }


    // lisää myyjä
    @GetMapping("/addshop")
    public String addshop(Model model) {

        model.addAttribute("shop", new Kauppa());
        return "shopform";
    }
    

    // tallenna myyjä
    @PostMapping("/saveshop")
    public String saveshop(Kauppa shop) {

        kauppaRepository.save(shop);
        return "redirect:/shoplist";
    }
    

    // muokkaa myyjän tietoja
    @GetMapping("/editshop/{id}")
    public String editshop(@PathVariable("id") long id, Model model) {

        model.addAttribute("shop", kauppaRepository.findById(id));
        return "shopform";
    }
    

    // näytä kaupan autot
    @GetMapping("/shopcars/{id}")
    public String kauppacars(@PathVariable("id") Long kauppaid, Model model) {


        Kauppa kauppa = kauppaRepository.findById(kauppaid).orElse(null);
        List<Auto> autot = autoRepository.findByKauppaKauppaid(kauppa.getKauppaid()); 
        
        model.addAttribute("cars", autot);
        model.addAttribute("shop", kauppa);

        return "shopcars";
    }
}
