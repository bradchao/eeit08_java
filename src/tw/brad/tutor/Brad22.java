package tw.brad.tutor;

public class Brad22 {

	public static void main(String[] args) {
		String s1 = "Brad";
		System.out.println("Brad".charAt(0));
		String s2 = new String();
		byte[] b = {97,98,99,100, 101, 102, 103, 104};
		String s3 = new String(b);
		String s4 = new String(b, 2, 4);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
	}

}
