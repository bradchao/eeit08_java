package tw.brad.tutor;

import java.util.ArrayList;
import java.util.LinkedList;

import tw.brad.apis.Member;

public class Brad37 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add(0,"Brad1");	// 0
		list.add(0,"Brad2");	// 1
		list.add(0, "Brad3");	// 1
		list.add(0, "Brad4");
		list.add(0, "Brad5");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println("----");
		
		Member m1 = new Member(1, "Brad","","");
		Member m2 = new Member(2, "Eric","","");
		Member m3 = new Member(2, "Tony","","");
		Member m4 = new Member(1, "Andy","","");
		LinkedList<Member> ms = new LinkedList<>();
		ms.add(m1);
		ms.add(m2);
		ms.add(m3);
		ms.add(m4);
		System.out.println(ms.size());
		System.out.println(ms);
		
		
	}
}
