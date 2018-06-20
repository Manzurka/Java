package phone;

public class iPhone extends Phone implements Ringable {
	
	public iPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
    	String ring = this.getRingTone();
    	return "iPhone" + this.getVersionNumber() + " says " + ring;
    
    }
    @Override
    public String unlock() {
    	return "Unlocked via facial recognition";
    			
    }
    @Override
    public void displayInfo() {
    	System.out.println("iPhone info: version: " + this.getVersionNumber()+ ",battery: " + this.getBatteryPercentage() + " carrier: " + this.getCarrier());     
    }
}
