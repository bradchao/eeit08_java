package tw.brad.tutor;

import tw.brad.apis.Bike;

public class Brad23 {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = "Brad";
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		
		int a = 10, b = 10;
		System.out.println(a == b);
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		
		
	}

}
