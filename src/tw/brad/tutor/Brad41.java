package tw.brad.tutor;

import java.io.File;
import java.io.IOException;

public class Brad41 {

	public static void main(String[] args) {
		File f1 = new File("d:/brad/dir1/file1");
//		if (!f1.exists()) {
			try {
				if (f1.createNewFile()) {
					System.out.println("OK");
				}else {
					System.out.println("XX");
				}
				System.out.println("OK2");
			} catch (IOException e) {
				System.out.println(e);
			}
//		}
			
	}

}
