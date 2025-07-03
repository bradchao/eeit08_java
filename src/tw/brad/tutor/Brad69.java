package tw.brad.tutor;

public class Brad69 {
	public static void main(String[] args) {
		MyThread mt1 = new MyThread();
		MyThread mt2 = new MyThread();
		mt1.start();
		mt2.start();		
		System.out.println("main");
	}
}
class MyThread extends Thread {
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
