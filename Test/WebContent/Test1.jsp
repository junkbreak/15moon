<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script>
function loadURL()
{
 var url = document.all.url;
 if(url.value == "") {
  alert("url 을 입력해야합니다.");
  url.focus();
  return;
 }
 
 var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
 xmlhttp.open("GET", url.value, "false");
 xmlhttp.send();
 document.all.output.innerText = xmlhttp.responseText;
}
</script>

 

<input type=text name=url>
<input type=button value="url 로드" onclick="loadURL()">
<div id=output></div>
</body>
</html>