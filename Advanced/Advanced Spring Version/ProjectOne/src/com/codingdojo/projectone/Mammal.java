package com.codingdojo.projectone;

public class Mammal {
	private int energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	
	public void displayEnergy() {
		System.out.println(energyLevel);
	}
	
	public void setEnergy(int points) {
			energyLevel+=points;
	}
	

}
