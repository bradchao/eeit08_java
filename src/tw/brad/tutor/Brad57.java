package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad57 {
	public static void main(String[] args) {
		Brad573 obj = new Brad573();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
					new FileOutputStream("dir1/brad571.obj"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("----");
		try {
			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir1/brad571.obj"));
			Object obj2 = oin.readObject();
			oin.close();
			System.out.println("OK2");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
class Brad571 implements Serializable{
	Brad571(){System.out.println("Brad571");}
}
class Brad572 extends Brad571 {
	Brad572(){System.out.println("Brad572");}
}
class Brad573 extends Brad572 {
	Brad573(){System.out.println("Brad573");}
}





