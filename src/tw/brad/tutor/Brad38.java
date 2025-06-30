package tw.brad.tutor;

import java.util.HashMap;
import java.util.Set;

public class Brad38 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Brad");
		person.put("gender", true);
		person.put("age", 18);
		person.put("weight", 80.3);

		System.out.println(person.size());
		System.out.println(person.get("name"));
		System.out.println("-----");
		Set<String> keys = person.keySet();
		for (String key : keys) {
			System.out.print(key + ":" + person.get(key) + "\n");
		}
		
		
	}

}
