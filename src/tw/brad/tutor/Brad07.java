package tw.brad.tutor;

public class Brad07 {

	public static void main(String[] args) {
		int year = 2000;
		boolean isLeap;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					isLeap = true;
				}else {
					isLeap = false;
				}
			}else {
				isLeap = true;
			}
		}else {
			// 平
			isLeap = false;
		}
		
		System.out.printf("%d年是%s年\n", year, isLeap?"潤":"平");
		//--------------------
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			isLeap = true;
		}else {
			isLeap = false;
		}
		
		
		
		
		
	}

}
