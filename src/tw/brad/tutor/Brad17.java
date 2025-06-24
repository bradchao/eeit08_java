package tw.brad.tutor;

import tw.brad.apis.Bike;

public class Brad17 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		System.out.println("---");
		//b2.speed = 20.1;
		//System.out.println(b1.speed);
		//System.out.println(b2.speed);
		
		
	}

}
