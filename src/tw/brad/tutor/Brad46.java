package tw.brad.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad46 {

	public static void main(String[] args) {
		String mesg = "Hello, Brad\nabcdefg\n1234567\n7654321";
		byte[] buf = mesg.getBytes();
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file1.txt");
			fout.write(buf);
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
