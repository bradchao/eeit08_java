package tw.brad.tutor;

import java.util.ArrayList;
import java.util.Collections;

public class Brad16 {

	public static void main(String[] args) {
		ArrayList<Integer> poker = new ArrayList<>();
		for (int i=0; i<10; i++) poker.add(i);
		Collections.shuffle(poker);
		for (Integer card: poker) {
			System.out.println(card);
		}
	}

}
