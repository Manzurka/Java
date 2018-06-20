package com.manzuraz.models;

public class Dog extends Animal implements Pet {
	public Dog() {
		
	}
	
	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		double lbs = this.getWeight();
		if (lbs < 30) {
			return this.getBreed() + " " + this.getName() + "hopped into your lap and cuddled you!";
		} else {
		    return this.getBreed() + " " + this.getName() + "curled up next to you!";
		}
	}
}
