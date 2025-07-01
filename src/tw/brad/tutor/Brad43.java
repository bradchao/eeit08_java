package tw.brad.tutor;

import java.security.GeneralSecurityException;

public class Brad43 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(3);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");
		
	}

}

class Bird {
	int leg;
	void setLeg(int n) throws GeneralSecurityException {
		if (n>=0 && n<=2) {
			leg = n;
		}else {
			throw new GeneralSecurityException();
		}
	}
}
