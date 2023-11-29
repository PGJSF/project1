package com.project.Model;

import java.sql.Connection;

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
	
	
	
	
	
	

}
