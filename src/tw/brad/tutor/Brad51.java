package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad51 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
				FileOutputStream fout = new FileOutputStream("dir2/coffee.jpg");){
			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
			}
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
