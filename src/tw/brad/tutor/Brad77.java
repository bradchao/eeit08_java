package tw.brad.tutor;

import java.sql.Connection;
import java.util.List;

import tw.brad.apis.BradUtils;
import tw.brad.apis.Member;
import tw.brad.apis.MemberDAO;
import tw.brad.apis.MemberDAOImpl;

public class Brad77 {

	public static void main(String[] args) {
		try(Connection conn = BradUtils.getConnection()){
			MemberDAO dao = new MemberDAOImpl(conn);
			
//			Member member = new Member();
//			member.setAccount("tony");
//			member.setPasswd("123456");
//			member.setName("Tony");
//			dao.addMember(member);
//			
//			System.out.println("OK");
			

			Member member = dao.findById(3);
			if (member != null) {
				member.setName("I am No3");
				dao.updateMember(member);
			}
			
			dao.delMember(4);
			System.out.println("----");
			List<Member> list = dao.findAll();
			for (Member m: list) {
				System.out.println(m.getName());
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
