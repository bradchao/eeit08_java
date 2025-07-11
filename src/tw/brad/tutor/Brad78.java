package tw.brad.tutor;

import java.sql.Connection;
import java.sql.SQLException;

import tw.brad.apis.BradUtils;
import tw.brad.apis.Member;
import tw.brad.apis.MemberDAO;
import tw.brad.apis.MemberDAOImpl;

public class Brad78 {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			conn = BradUtils.getConnection();
			
			conn.setAutoCommit(false);
			MemberDAO dao = new MemberDAOImpl(conn);
			
			Member m1 = dao.findById(3);
			Member m2 = dao.findById(6);
			
			m1.setName("333333");
			dao.updateMember(m1);
			
			System.out.println(10 / 3);
			
			m2.setName("666666");
			dao.updateMember(m2);
			
			System.out.println("OK");
			
			conn.commit();
			
			
		}catch(Exception e) {
			System.out.println(e);
			if (conn != null) {
				try {
					conn.rollback();
					System.out.println("rooback OK");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			}
		}finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}

}
