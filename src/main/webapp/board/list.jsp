<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "board.*, java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<%
	BoardDao dao = new BoardDao();
	List<BoardVo> ls = dao.selectAll();
	pageContext.setAttribute("ls",ls);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<h2>게시글 목록</h2>
<table border = "1">
<tr>
	<th>번호</th>
	<th>제목</th>
	<th>작성자</th>
	<th>등록일</th>
	<th>조회수</th>
</tr>
<c:forEach var = "board" items= "${ls}" >
<tr>
	<th>${board.num}</th>
	<th><a href="${pageContext.request.contextPath}/boardDetail.jsp?num=${board.num}">${board.title}</a></th>
	<th>${board.writer}</th>
	<th>${board.regdate}</th>
	<th>${board.cnt}</th>
</tr>
</c:forEach>
</table>
</body>
</html>