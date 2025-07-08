package tw.brad.tutor;

public class Brad73 {
	public static void main(String[] args) {
		Brad731 b1 = new Brad731("A", 10);
		Brad731 b2 = new Brad731("B", 20);
		b1.start();
		b2.start();
		System.out.println("main start");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		
		try {
			b1.join();
		} catch (InterruptedException e) {
		}
		System.out.println("main finish");
	}
}
class Brad731 extends Thread {
	private String name;
	private int count;
	Brad731(String name, int count){this.name = name; this.count = count;}
	@Override
	public void run() {
		for (int i=0; i<count; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}
