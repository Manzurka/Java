package com.manzuraz.models;

public class Cat extends Animal implements Pet {
	public Cat() {
		
	}

	public Cat(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		return "Your" + this.getBreed() +" cat, " + this.getName() + ", looked at you with some affection.";
	}
}
