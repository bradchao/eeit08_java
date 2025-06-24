package tw.brad.tutor;

public class Brad15 {

	public static void main(String[] args) {
		int a = -7, b = 4;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		
		System.out.printf("a = %d, b = %d\n", a, b);
		System.out.println(3 & 2);
		System.out.println(3 | 2);
		System.out.println(3 ^ 2);
	}

}
