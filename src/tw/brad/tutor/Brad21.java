package tw.brad.tutor;

public class Brad21 {
	public static void main(String[] args) {
//		Brad211 obj1 = new Brad211(0);
//		Brad212 obj2 = new Brad212();
		Brad213 obj31 = new Brad213();
		Brad213 obj32 = new Brad213(1);
		Brad213 obj33 = new Brad213(1.0);
	}
	
	
	
}

class Brad211 extends Object{
	Brad211(int a) {
		// super();
		System.out.println("Brad211(int)");
	}
}
class Brad212 extends Brad211 {
	Brad212(){
		// super();
		super(1);
		System.out.println("Brad212()");
	}
}
class Brad213 extends Brad212 {
	Brad213(){
		System.out.println("Brad213()");
	}
	
	Brad213(int a){
		// super();
		this();
		System.out.println("Brad213(int)");
	}
	
	Brad213(double a){
		this(2);
		System.out.println("Brad213(double)");
	}
	
	
	
	
	
}