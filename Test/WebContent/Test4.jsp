<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "javax.servlet.jsp.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>
<body>
<script>

var request = new XMLHttpRequest();

request.onreadystatechange = function() {

				alert(request.responseText);
		
	request.open("GET", "http://apis.data.go.kr/B090041/openapi/service/LunPhInfoService/getLunPhInfo?solYear=2018&solMonth=04&solDay=10&serviceKey=WjughaThdULfdkECwUvSg3aMD0iR1nDXxzk2DUSTi4Gqj%2FtaV5GPsoHLVInvNg5ZdUZx0awqPAoVinLy%2B5xcjA%3D%3D");

	request.send();
</script>

</body>
</html>