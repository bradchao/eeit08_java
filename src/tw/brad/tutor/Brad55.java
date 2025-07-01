package tw.brad.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Student;

public class Brad55 {

	public static void main(String[] args) {
		Student s1 = new Student("Brad", 76, 87, 32);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		System.out.println(s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed().getSpeed());
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/brad.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(s1);
			fout.flush();
			fout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
