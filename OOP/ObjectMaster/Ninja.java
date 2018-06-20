package objectmaster;

public class Ninja extends Human{
	
	public Ninja(){
		super();
		setStealth(10);
		System.out.println("Ninja is set with the following attributes:");
		displayAttributes();
	}
	public void steal(Human name) {
		int health = name.getHealth();
		int points = this.getStealth();
		health = health - points;
		name.setHealth(health);
		int stealth = this.getStealth();
		stealth = stealth + points;
		System.out.println(name + " lost " + points + " points in health. Health is now: " + health + ". Ninja gained " + points + " points in stealth. Stealth is now: " + stealth);
		
	}
	
	public void runAway() {
		int health = this.getHealth();
		health = health - 10;
		this.setHealth(health);
		System.out.println("Ninja ran away and lost 10 points. Health is now: "+ health);
	}
}