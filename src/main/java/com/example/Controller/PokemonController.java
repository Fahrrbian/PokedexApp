package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Pokemon;
import com.example.service.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

	 private final PokemonService pokemonService;

	    @Autowired
	    public PokemonController(PokemonService pokemonService) {
	        this.pokemonService = pokemonService;
	    }

	    // Endpoint zum Abrufen aller Pokémon
	    @GetMapping
	    public List<Pokemon> getAllPokemon() {
	        return pokemonService.getAllPokemon();
	    }

	    // Endpoint zum Abrufen eines bestimmten Pokémon
	    @GetMapping("/{id}")
	    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
	        Pokemon pokemon = pokemonService.getPokemonById(id);
	        return pokemon != null ? ResponseEntity.ok(pokemon) : ResponseEntity.notFound().build();
	    }
	    // Endpoint zum Erstellen eines neuen Pokémon
	    @PostMapping
	    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
	        return pokemonService.createPokemon(pokemon);
	    }

	    // Endpoint zum Aktualisieren eines Pokémon
	    @PutMapping("/{id}")
	    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long id, @RequestBody Pokemon updatedPokemon) {
	        Pokemon pokemon = pokemonService.updatePokemon(id, updatedPokemon);
	        return pokemon != null ? ResponseEntity.ok(pokemon) : ResponseEntity.notFound().build();
	    }

	    // Endpoint zum Löschen eines Pokémon
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
	        return pokemonService.deletePokemon(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	    }
}
