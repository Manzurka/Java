package com.codingdojo.projectone;

class Gorilla extends Mammal {
	
	public Gorilla(){
		System.out.println("Energy level was set at 100 points");
		displayEnergy();
	}
	
	public void throwSomething() { 
		setEnergy(-5);
		System.out.println("Gorilla throw something at people and lost energy(-5)");
		displayEnergy();
	}
	
	public void eatBananas() {
		setEnergy(+10);
		System.out.println("Gorilla ate bananas and gained energy(+10)");
		displayEnergy();
	}
	
	public void climb() {
		setEnergy(-10);
		System.out.println("Gorilla climbed the tree and lost energy(-10)");
		displayEnergy();
	}

}
