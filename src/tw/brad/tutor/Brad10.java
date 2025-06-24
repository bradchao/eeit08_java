package tw.brad.tutor;

public class Brad10 {

	public static void main(String[] args) {
		int a = 10;
		int[] ary;
		ary = new int[3];
		System.out.println(ary[2]);
		System.out.println(ary.length);
		ary[0] = 12;
		ary[2] = 33;
		for (int i = 0; i<ary.length; i++) {
			System.out.println(ary[i]);
		}
		System.out.println("----");
		for (int v : ary) {
			System.out.println(v);
		}
		System.out.println("----");
		System.out.println(a);
		System.out.println(ary);
		
		
		
	}

}
