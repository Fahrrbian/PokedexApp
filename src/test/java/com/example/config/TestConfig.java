package com.example.config;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

import com.example.repository.PokemonRepository;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
public class TestConfig {

	  @Bean
	    public PokemonRepository pokemonRepository() {
	        return Mockito.mock(PokemonRepository.class);
	    }
}
