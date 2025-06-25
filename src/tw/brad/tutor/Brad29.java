package tw.brad.tutor;

public class Brad29 {
	public static void main(String[] args) {
		Brad291 obj1 = new Brad291();
		Brad291 obj2 = new Brad292();
		Brad291 obj3 = new Brad293();
		
		obj1.m1();
		obj2.m1();
		obj3.m1();
		Brad292 obj4 = (Brad292)obj2;
		obj4.m2();
		
		System.out.println(obj2 == obj4);
		System.out.println(obj2 instanceof Brad293);
		
	}
}
class Brad291 {
	void m1() {System.out.println("Brad291:m1()");}
}
class Brad292 extends Brad291{
	void m1() {System.out.println("Brad292:m1{}");}
	void m2() {System.out.println("Brad292:m2{}");}
}
class Brad293 extends Brad291{
	void m1() {System.out.println("Brad293:m1()");}
}