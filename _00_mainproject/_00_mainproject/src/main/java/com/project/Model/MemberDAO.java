package com.project.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	// DB 데이터를 VO객체로 얻어오거나 추가.
	
	
	//싱글톤 패턴 ---> 메모리 낭비 방지
	//private 생성자
	private MemberDAO() {}
	
	//외부 접근 제한
	private static MemberDAO instance = new MemberDAO();
	
	//read only property --> new 연산자로 객체 생성X, getInstance메소드로 값을 가져와야만 가능.
	//MemberDAO dao = MemberDAO.getInstace()
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	//DBCP 페이지의 내용 -->  getConnection() 메소드
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}
	
	
	//로그인 --> 사용자 인증시 사용하는 메소드
	public int userCheck(String userid, String pw) {
		int result = -1;
		String sql = "select pw from member where userid=?"; // userid 를 통해 pw 확인
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); //
			if(rs.next()) {
				if(rs.getString("pw")!=null && rs.getString("pw").equals(pw)) {
					result = 1; //회원 존재 1
				}else {
					result = 0;
				}
			}else {
				result = -1; //회원 존재 X
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	
	//아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String userid) {
		MemberVO mvo = null;
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); //
			if(rs.next()) {
				mvo = new MemberVO();
				mvo.setId("id");
				mvo.setPw("pw");
				mvo.setName("name");
				mvo.setPhone("phone");
				mvo.setEmail("email");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return mvo;
	}

}
