package tw.brad.tutor;

public class Brad33 {

	public static void main(String[] args) {
		String test = "1224";
		if (test.matches("[0-9]{4}")) {
			long count = test.chars().filter(c -> c == '2').count();
			System.out.println(count);
			System.out.println("----");
			test.chars().forEach(ch -> System.out.println((char)ch));
			
			
		}else {
			System.out.println("XX");
		}
	}

}
