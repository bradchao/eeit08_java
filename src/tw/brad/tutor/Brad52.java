package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad52 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File source = new File("dir1/coffee.jpg");
		byte[] buf = new byte[4096];
		try (FileInputStream fin = new FileInputStream(source);
				FileOutputStream fout = new FileOutputStream("dir2/coffee3.jpg")){
			int len;
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
