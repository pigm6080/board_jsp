<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제확인</title>
</head>
<body>
	
	<form action="delete.jsp">
		<input type="hidden" value="<%=num%>" name="num"/>
			삭제하시겠습니까?<input type="submit" value="예">
		
	
	</form>
</body>
</html>