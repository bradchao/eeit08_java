package tw.brad.tutor;

public class Brad30 {
	public static void main(String[] args) {
		//Brad301 obj1 = new Brad301();
		Brad301 obj1 = new Brad302();
		Brad301 obj2 = new Brad303();
		obj1.m3();
		obj2.m3();
		
		Brad301 obj3 = new Brad301() {
			void m3() {
				System.out.println("Brad301:m3()");
			}
		};
		obj3.m3();
	}
}
abstract class Brad301 {
	Brad301(){System.out.println("Brad301()");}
	void m1() {}
	void m2() {}
	abstract void m3();
}
class Brad302 extends Brad301 {
	void m3() {System.out.println("Brad302:m3()");}
}
class Brad303 extends Brad301 {
	void m3() {System.out.println("Brad303:m3()");}
}
