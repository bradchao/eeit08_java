package tw.brad.tutor;

public class Brad28 {
	public static void main(String[] args) {

	}
}
class Brad281 {
	protected Number m1() {
		System.out.println("Brad281:m1()");
		return null;
	}
	void m2() {}
}
class Brad282 extends Brad281 {
	public Byte m1() {
		System.out.println("Brad282:m1()");
		super.m2();
		return null;
	}
}
