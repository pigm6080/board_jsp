<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="dao" class="board.BoardDAO"/>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	BoardVO vo = dao.selectOne(num);
	pageContext.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<h1>수정하기</h1>
	<form action="edit.jsp" method="post">
		<input type="hidden" name ="num" value="${vo.num}"/>
		<input type="text" name="title" placeholder="제목" required/><br>
		<input type="text" name="writer" placeholder="작성자" required/><br>
		<textarea rows="4" cols="20" placeholder="내용"></textarea><br>
		<input type="submit" value="수정" />
	</form>
</body>
</html>