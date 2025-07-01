package tw.brad.tutor;

public class Brad42 {
	public static void main(String[] args) {
		int a = 10, b = 0;
		int c;
		int[] d = {1,2,3,4};
		
		System.out.println("Hello, World");
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[200]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Oooop!(2)");
		}catch(ArithmeticException e) {
			System.out.println("Oooop!(1)");
		}catch(RuntimeException e) {
			System.out.println("xxx");
		}
		System.out.println("Finish");
	}
}
