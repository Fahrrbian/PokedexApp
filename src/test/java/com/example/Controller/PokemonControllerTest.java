package com.example.Controller; 

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.http.MediaType;

import com.example.service.*;
import com.example.demo.PokedexApplication;
import com.example.model.*;

@SpringBootTest(classes = PokedexApplication.class)
@AutoConfigureMockMvc
//@WebMvcTest(PokemonController.class)
public class PokemonControllerTest {
	
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PokemonService pokemonService; // Mocke den PokemonService

    @Test
    public void testGetPokemonById() throws Exception {
        // Hier den Mock-Service definieren
    	Pokemon testPokemon = new Pokemon("5", "Pikachu", null);
        when(pokemonService.getPokemonById((long) 5)).thenReturn(testPokemon); // Beispielobjekt

        // Führen Sie den Test aus
        mockMvc.perform(get("/pokemon/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()) // Dies zeigt detaillierte Infos über die Anfrage/Antwort
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("5"))
                .andExpect(jsonPath("$.name").value("Pikachu"));
    }
    @Test
    public void testGetPokemonById_NotFound() throws Exception {
        // Mock-Service-Verhalten für nicht gefundenes Pokemon
        when(pokemonService.getPokemonById(999L)).thenReturn(null);

        // Führen Sie den Test aus
        mockMvc.perform(get("/pokemon/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }
}