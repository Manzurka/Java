package objectmaster;

public class Human {
	private int strength;
	private int stealth;
	private int intelligence;
	private int health;
	
	public Human(){
		strength = 3;
		stealth = 3;
		intelligence= 3;
		health = 100;
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void displayAttributes() {
		System.out.println("strength:" + strength);
		System.out.println("stealth:" + stealth);
		System.out.println("intelligence:" + intelligence);
		System.out.println("health:" + health );
	}
	
	public void attack(Human name) {
		int health = name.getHealth();
		int points = this.getStrength();
		health = health - points;
		name.setHealth(health);
		System.out.println(name + " was attacked, lost "+ points + " points.Health is now: "+ health);
	}

}