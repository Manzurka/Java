package com.manzuraz.advanced.bank.pokemon;

public abstract class PokemonAbstract implements PokemonInterface{
	
	public Pokemon createPokemon(String name, int health, String type) {
		Pokemon p = new Pokemon(name, health, type);
		System.out.println(p.getName()+" was created");
		return p;
	}
	
	public void attackPokemon(Pokemon pokemon) {
		int health = pokemon.getHealth();
		health = health - 10;
		pokemon.setHealth(health);
		System.out.println(pokemon.getName() + " was attacked. Its health is now " + health);
	}
}
