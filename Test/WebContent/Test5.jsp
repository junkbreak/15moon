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
var request = require('request'),
    cheerio = require('cheerio');

var url = "http://apis.data.go.kr/B090041/openapi/service/LunPhInfoService/getLunPhInfo?solYear=2018&solMonth=04&solDay=10&serviceKey=WjughaThdULfdkECwUvSg3aMD0iR1nDXxzk2DUSTi4Gqj%2FtaV5GPsoHLVInvNg5ZdUZx0awqPAoVinLy%2B5xcjA%3D%3D";

request(url, function (err, res, html) {
    if (!err) {
        var $ = cheerio.load(html);
        
        // 블로그 title 정보 가져오기
        $(".lunAge>").each(function (i) {
            var post = {"lunAge": ""};
            var data = $(this);
            
            post["lunAge"] = data.text();
        });
        
    }
})
document.write("ddd");
</script>
</body>
</html>