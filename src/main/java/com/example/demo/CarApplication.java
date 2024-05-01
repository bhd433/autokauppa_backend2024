package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Auto;
import com.example.demo.domain.AutoRepository;
import com.example.demo.domain.Kauppa;
import com.example.demo.domain.KauppaRepository;

// kielen vaihtoa varten
//import org.springframework.context.support.ResourceBundleMessageSource;
//import java.util.Locale;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class CarApplication //implements WebMvcConfigurer
{

	/* 
	private final LocaleChangeInterceptor localeChangeInterceptor;

	public CarApplication(LocaleChangeInterceptor localeChangeInterceptor) {
		this.localeChangeInterceptor = localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor);
	}

	*/
	public static void main(String[] args) {


		//ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		//messageSource.setBasenames("lang/messages");
		//messageSource.setDefaultEncoding("UTF-8");
		////System.out.println(messageSource.getMessage("hello", null, Locale.ENGLISH));

		SpringApplication.run(CarApplication.class, args);
	}


	@Bean CommandLineRunner demo(AutoRepository autoRepository, KauppaRepository kauppaRepository) {

		return (args) -> {

			// Luodaan autokaupat ja autot, ja lisätään ne repositoryihin
			Kauppa k1 = new Kauppa("Vantaan Automyymälä", "Vantaantie 7");
			Kauppa k2 = new Kauppa("AutoPate", "Tampereenkuja 15");
			Kauppa k3 = new Kauppa("Matin Autokauppa", "Helsinginkatu 3");
			kauppaRepository.save(k1);
			kauppaRepository.save(k2);
			kauppaRepository.save(k3);

			Auto a1 = new Auto("Volkswagen", "Polo", 2015, 14000, k3);
			Auto a2 = new Auto("Mercedes Benz", "E", 2006, 11000, k2);
			Auto a3 = new Auto("Toyota", "Corolla", 1997, 3000, k1);
			Auto a4 = new Auto("Skoda", "Octavia", 2012, 19000, k3);
			Auto a5 = new Auto("Volkswagen", "Golf", 2020, 26000, k2);
			Auto a6 = new Auto("Audi", "A4", 2009, 7000, k1);
			Auto a7 = new Auto("Toyota", "RAV4", 2018, 29000, k3);
			Auto a8 = new Auto("Audi", "RS6", 2020, 89000, k2);
			Auto a9 = new Auto("Mazda", "6", 2010, 6000, k1);
			autoRepository.save(a1);
			autoRepository.save(a2);
			autoRepository.save(a3);
			autoRepository.save(a4);
			autoRepository.save(a5);
			autoRepository.save(a6);
			autoRepository.save(a7);
			autoRepository.save(a8);
			autoRepository.save(a9);
		};
	}
}
