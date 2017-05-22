<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/myweb/cookie/setcookie1">SetCookie 1 호출</a><br>
<a href="/myweb/cookie/getcookie">GetCookie 호출</a><br>
<a href="/myweb/cookie/setcookie3">SetCookie 3 호출-currentTime쿠키 삭제 </a>

<!-- /어플명/url-p -->

<form action="/myweb/cookie/setcookie2" method="post">  <!--서블릿 SetCookie2Servlet으로 이동  -->
   ID: <input type="text" name="id"><br>
   키워드: <input type="text" name="keyword"><br>
   <input type="submit" value="전송">
 </form>
</body>
</html>