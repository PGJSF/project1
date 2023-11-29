package com.project.Model;

public class MemberVO {
	private String id; 			//01. ID - 중복 확인
	private String nick;		//02. NickName - 중복확인
	private String pw;			//03. Password
	private String name;		//04. Name
	private String phone;		//05. Phone	-인증서비스
	private String email;		//06. Email
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", nick=" + nick + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	

}
