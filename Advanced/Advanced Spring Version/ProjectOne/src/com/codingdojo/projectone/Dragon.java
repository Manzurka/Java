package com.codingdojo.projectone;

class Dragon extends Mammal  {
	public Dragon(){
		setEnergy(200);
		System.out.println("Energy level was set at 300 points");
		displayEnergy();
	}
	
	public void fly() { 
		setEnergy(-50);
		System.out.println("Dragon is taking off DRRRR and lost energy(-50)");
		displayEnergy();
	}
	
	public void eatHumans() {
		setEnergy(+25);
		System.out.println("Dragon ate and gained energy(+25)");
		displayEnergy();
	}
	
	public void attackTown() {
		setEnergy(-100);
		System.out.println("Dragon attacked a town and lost energy(-100)");
		displayEnergy();
	}
}
