<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--링크로 보내는것은 get방식밖에 없으므로 post방식으로는 보낼수 없다.  -->
<h2>링크에서 Query String으로 요청파라미터 전달</h2>
<!-- <a href="http://127.0.0.1:8088/myweb/form/readqs">Read QueryString 서블릿 요청</a><br> -->
<a href="/myweb/form/readqs?name=김영수&age=20">Read QueryString 서블릿 요청</a><br>
<a href="/myweb/form/readqs?name=김영수&age=20&name=hong&name=park">
         Read QueryString 서블릿 요청2</a>
<!-- <a href="readqs">Read QueryString 서블릿 요청</a>    ./는 생략가능  -->
<hr>
전화번호: ${initParam["phone number"]}<br>
관리자 이메일주소: ${initParam["admin email"]}

</body>
</html>