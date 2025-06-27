package tw.brad.tutor;

import java.util.HashSet;

import tw.brad.apis.Bike;

public class Brad34 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("Brad");
		set.add(new Bike());
		set.add(123);	// int => auto-boxing => Integer
		set.add(12.3);	// double => Double
		System.out.println(set.size());
		set.add(123);
		set.add("Brad");
		set.add(true);
		System.out.println(set.size());
		System.out.println(set);
		
	}

}
