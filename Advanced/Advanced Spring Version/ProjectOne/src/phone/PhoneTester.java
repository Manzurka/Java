package phone;

public class PhoneTester {
	public static void main(String[] args) {
		Galaxy S9 = new Galaxy("S9", 99, "verizon", "Ring Ring Ring");
		iPhone iPhoneTen = new iPhone ("X", 100, "AT&T", "Zing");
		S9.displayInfo();
		S9.ring();
		S9.unlock();
		iPhoneTen.displayInfo();
		iPhoneTen.ring();
		iPhoneTen.unlock();
	}
	

}
