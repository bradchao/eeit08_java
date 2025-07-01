package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad48 {

	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		try {
			FileInputStream fin = new FileInputStream(f1);
			int c;
			while ( (c = fin.read()) != -1) {
				System.out.print((char)c);
			}
			fin.close();
			System.out.println();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
