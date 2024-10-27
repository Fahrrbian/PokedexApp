package com.example.Controller;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.config.TestConfig;
import com.example.demo.PokedexApplication;
import com.example.model.Pokemon;
import com.example.service.PokemonService;
import com.example.repository.PokemonRepository;


@SpringBootTest(classes = {PokedexApplication.class, TestConfig.class})
@AutoConfigureMockMvc
public class PokemonControllerTest {

	   @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private PokemonService pokemonService;
	    
	    @MockBean
	    private PokemonRepository pokemonRepository;
	    
	    @Test
	    public void testGetPokemonById() throws Exception {
	        Pokemon testPokemon = new Pokemon(5, "Pikachu");
	        when(pokemonService.getPokemonById(5L)).thenReturn(testPokemon);

	        mockMvc.perform(get("/pokemon/5")
	                .contentType(MediaType.APPLICATION_JSON))
	                .andDo(MockMvcResultHandlers.print())
	                .andExpect(status().isOk())
	                .andExpect(jsonPath("$.id").value(5))
	                .andExpect(jsonPath("$.name").value("Pikachu"));
	    }

    @Test
    public void testGetPokemonById_NotFound() throws Exception {
        when(pokemonService.getPokemonById(999L)).thenReturn(null);

        mockMvc.perform(get("/pokemon/999")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }
}
