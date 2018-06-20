package phone;

public class Galaxy extends Phone implements Ringable {
	
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	String ring = this.getRingTone();
    	return "Galaxy" + this.getVersionNumber() + "says " + ring;
    }
    @Override
    public String unlock() {
    	return "Unlocked via finger print";
    }
    @Override
    public void displayInfo() {
    	System.out.println("Galaxy info: version: " + this.getVersionNumber()+ ",battery: " + this.getBatteryPercentage() + " carrier: " + this.getCarrier());      
    }
}

