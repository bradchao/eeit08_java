package tw.brad.apis;

import java.util.Objects;

public class Member {
	private int id;
	private String name;
	private String passwd;	// plain or hash => plain
	private String account;
	
	public Member(int id, String name, String account, String passwd){
		this.id = id; this.name = name;
		this.account = account; this.passwd = passwd;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAccount() {
		return account;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Member other = (Member)obj;
		
		return this.id == other.id;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return String.format("%d:%s", id, name);
	}
	
}
