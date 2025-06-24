package tw.brad.apis;

public class Scooter extends Bike{
	private int gear;	// 0
	
	public void upSpeed() {
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed * 1.8 * gear;
		}
	}
	
	public int changeGear(int gear) {
		if (gear >= 0 && gear <=4 ) {
			this.gear = gear;
		}
		
		return this.gear;
	}
	
}
