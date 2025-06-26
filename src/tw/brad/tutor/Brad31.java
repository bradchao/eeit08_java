package tw.brad.tutor;

public class Brad31 {
	public static void main(String[] args) {
		Brad311 obj1 = new Brad312();
		Brad311 obj2 = new Brad313();
		Brad314 obj3 = new Brad312();
		obj1.m1();
		obj3.m3();
		
	}
}
interface Brad311 {
	void m1();
	void m2();
}
class Brad312 extends Object implements Brad311, Brad314{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
class Brad313 implements Brad311{
	public void m1() {}
	public void m2() {}
}
interface Brad314 {
	void m3();
	void m4();
}
interface Brad315 extends Brad311, Brad314 {
	void m5();
	void m6();
}
class Brad316 implements Brad315 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m6() {
		// TODO Auto-generated method stub
		
	}

	
}



