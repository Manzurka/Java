package objectmaster;

public class Samurai extends Human{
	private int count = 0;
	
	public Samurai(){
		super();
		setHealth(200);
		System.out.println("Samurai is set with the following attributes:");
		displayAttributes();
	}
	
	public void deathBlow(Human name) {
		int health = this.getHealth();
		health = health/2;
		this.setHealth(health);
		name.setHealth(0);
		name.setStealth(0);
		name.setStrength(0);
		name.setIntelligence(0);
		count++;
		System.out.println("Samurai killed " + name + " and lost 50% of health. Health is now: "+ health);
		System.out.println(name + " lost life.");
		name.displayAttributes();
	}
	public void meditate() {
		int health = this.getHealth();
		health = health +(health/2);
		this.setHealth(health);
		System.out.println("Samurai is healed for 50%. Health is now: " + health);
	}
	public void howMany() {
		System.out.println("Samurai killed: " + count + " human(s)");
	}
		
}