package com.manzuraz.advanced.bank.pokemon;

public class PokemonTester {
	public static void main(String[] args) {
		Pokedex pokemons = new Pokedex();
		Pokemon charizard = pokemons.createPokemon("Charizard", 100, "Fire");
		Pokemon pikachu = pokemons.createPokemon("Pikachu", 100, "Electric");
		pokemons.attackPokemon(charizard);
		pokemons.attackPokemon(pikachu);
		pokemons.pokemonInfo(charizard);
		pokemons.pokemonInfo(pikachu);
	
	}

}
