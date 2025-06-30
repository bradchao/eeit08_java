package tw.brad.tutor;

import java.util.HashSet;

import tw.brad.apis.Member;

public class Brad36 {

	public static void main(String[] args) {
		Member m1 = new Member(1, "Brad");
		Member m2 = new Member(2, "Eric");
		Member m3 = new Member(2, "Tony");
		Member m4 = new Member(1, "Andy");
		
		HashSet<Member> members = new HashSet<>();
		members.add(m1);
		members.add(m2);
		members.add(m3);
		members.add(m4);
		
		System.out.println(members.size());
		System.out.println(members);
		
		
		
	}

}
