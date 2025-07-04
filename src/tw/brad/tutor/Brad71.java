package tw.brad.tutor;

public class Brad71 {
	public static void main(String[] args) {
		Brad711 obj1 = new Brad711();
		Brad712 obj2 = new Brad712();
		obj1.start();
		//obj2.run();
		Thread t1 = new Thread(obj2);
		t1.start();
	}
}
class Brad711 extends Thread {
	@Override
	public void run() {
		System.out.println("Brad711: run thread");
	}
}
class Brad712 implements Runnable {
	@Override
	public void run() {
		System.out.println("Brad712: run");
	}
}
