package tw.brad.tutor;

import java.io.FileOutputStream;

public class Brad70 {

	public static void main(String[] args) {
		System.out.println("start");
		
		new Thread() {
			public void run() {
				try {
					FileOutputStream fout = new FileOutputStream("dir1/test1.txt");
					fout.write("Hello, World".getBytes());
					fout.flush();
					fout.close();
					System.out.println("OK");
				}catch(Exception e) {System.out.println(e);}
			};
		}.start();
		
		
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
		
		System.out.println("main finish");
	}

}
