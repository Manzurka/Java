package objectmaster;

public class HumanTest {
	public static void main(String args[]) {
		Wizard wizardOz = new Wizard();
		Ninja ninjaDojo = new Ninja();
		Samurai Oshiko = new Samurai();
		ninjaDojo.steal(wizardOz);
		ninjaDojo.runAway();
		wizardOz.attack(ninjaDojo);
		wizardOz.fireball(ninjaDojo);
		Oshiko.deathBlow(ninjaDojo);
		wizardOz.heal(Oshiko);
		Oshiko.meditate();
		Oshiko.howMany();
	}
}
