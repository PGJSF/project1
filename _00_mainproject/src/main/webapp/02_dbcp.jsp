<%@page import="java.sql.Connection"%>
<%@page import="com.project.Model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	MemberDAO memdao = MemberDAO.getInstance();
	Connection conn = memdao.getConnection();
	out.print("DBCP 연동 성공");
	%>
</body>
</html>