package controllers;

public class Tester {
	public static void main(String[] args) {
		Character Yoda = new Character("Yoda",100,"Wars not make one great");
		Character Luke = new Character("Luke Skywalker", 150, " I am a Jedi, like my father before me.");
		Character Chewbacca = new Character("Chewbacca",200, "RAWRGWAWGGR");
		System.out.println(Luke.greet(Yoda));
		System.out.println(Yoda.greet(Chewbacca));
		System.out.println(Chewbacca.greet(Luke));
	}
}
