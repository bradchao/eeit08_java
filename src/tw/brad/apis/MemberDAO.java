package tw.brad.apis;

import java.util.List;

public interface MemberDAO {
	void addMember(Member member);
	void updateMember(Member member);
	void delMember(int id);
	Member findById(int id);
	List<Member> findAll();
}
