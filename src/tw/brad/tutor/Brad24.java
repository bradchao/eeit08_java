package tw.brad.tutor;

public class Brad24 {

	public static void main(String[] args) {
		String name = "Brad不來的";
		System.out.println(name);
		String name2 = name.concat("Chao");
		System.out.println(name);
		System.out.println(name2);
		System.out.println(name.length());
		String name3 = name.replace('a', 'A');
		System.out.println(name3);
		System.out.println("-----");
		String s1 = new String("Brad");
		String s2 = s1;
		System.out.println(s1 == s2);
		s2 = "Brad";
		System.out.println(s1 == s2);
		
		
	}

}
