public class Character {
	private String name;
	private int weight;
	private String famous_saying;
	
	
	public Character () {
		name="NoName";
		weight=0;
		famous_saying="May the Fourth be with you";
	}
	public Character (String name, int weight, String saying) {
		this.name = name;
		this.weight = weight;
		famous_saying = saying;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getFamous_saying() {
		return famous_saying;
	}
	public void setFamous_saying(String famous_saying) {
		this.famous_saying = famous_saying;
	}
	public String getAttributes() {
		return "Name: " + name + ". Saying: " + famous_saying + ". Weight: " + weight;
	}
	
	public String greet(Character other) {
		return "Hello "+ other.getName() +", I am "+ name;
		 
	}
}