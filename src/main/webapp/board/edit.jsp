<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="board.BoardVO"/>
<jsp:useBean id="dao" class="board.BoardDAO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	dao.update(vo);
%>
<c:redirect url="${pageContext.request.contextPath}/boardDetail.jsp?num=${vo.num}"/>