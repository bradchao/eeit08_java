package tw.brad.tutor;

public class Brad01 {

	public static void main(String[] args) {
		// byte, short, int, long
		// byte => -128 ~ 127 => 2^8
		// short => 2^16 => -32768 ~ 32767
		// int => 2^32 => default 
		// long => 2^64
		byte var1, var2;
		var1 = 10;
		var2 = 3;
		int var3 = var1 / var2;
		System.out.println(var3);
		
	}

}
