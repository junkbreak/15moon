<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="test.Text" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="test" class="test.Text" scope="page" />
<html>
<body>
<%Text te = new Text();%>

<%=te.moon()%>
</body>
</html>