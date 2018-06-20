package objectmaster;

public class Wizard extends Human{

	public Wizard(){
		super();
		setIntelligence(8);
		setHealth(50);
		System.out.println("Wizard is set with the following attributes:");
		displayAttributes();
	}
	
	public void heal(Human name) {
		int health = name.getHealth();
		int points = this.getIntelligence();
		health= health + points;
		name.setHealth(health);
		System.out.println(name + " was healed by Wizard and gained "+ points +" points in health. Health is now: "+ health);
	}
	
	public void fireball(Human name) {
		int health = name.getHealth();
		int points = this.getIntelligence();
		health= health - (points*3);
		name.setHealth(health);
		System.out.println(name + " was fireballed by Wizard and lost "+ points +" points in health. Health is now: " + health);
	}
}