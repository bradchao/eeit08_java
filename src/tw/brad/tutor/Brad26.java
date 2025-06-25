package tw.brad.tutor;

public class Brad26 {
	public static void main(String[] args) {
//		Brad261.m2();
//		Brad261.m2();
//		Brad261.m2();
		
//		Brad261 obj1 = new Brad261();
		Brad261 obj2 = new Brad261();
	}
}
class Brad261 {
	{
		System.out.println("Brad261{}");
		m1();
		m2();
	}
	static {
		System.out.println("Brad261:static{}");
		m2();
	}
	Brad261(){
		System.out.println("Brad261()");
		m1();
	}
	void m1() {
		System.out.println("Brad261:m1()");
	}
	static void m2() {
		System.out.println("Brad261:static:m2()");
	}
}
