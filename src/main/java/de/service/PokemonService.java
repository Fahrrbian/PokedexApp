package de.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.model.Pokemon;
import de.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository Repository;

    @Autowired
    public PokemonService(PokemonRepository Repository) {
        this.Repository = Repository;
    }

    public List<Pokemon> getAllPokemon() {
        return Repository.findAll();
    }

    public Pokemon getPokemonById(Long id) {
        Optional<Pokemon> pokemon = Repository.findById(id);
        return pokemon.orElse(null);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return Repository.save(pokemon);
    }

    public Pokemon updatePokemon(Long id, Pokemon updatedPokemon) {
        if (Repository.existsById(id)) {
            updatedPokemon.setId(id);
            return Repository.save(updatedPokemon);
        }
        return null;
    }

    public boolean deletePokemon(Long id) {
        if (Repository.existsById(id)) {
            Repository.deleteById(id);
            return true;
        }
        return false;
    }
}
