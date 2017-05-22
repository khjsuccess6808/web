<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쿠키 값들</h2>   <!--value 값을 출력  //jsp에서 request를 할때는 request로 정해놓아야한다. 서블릿에서 req로 했든 상관없다.-->
<%=request.getAttribute("message")%>

<p>
<a href="/myweb/cookie/request.jsp">request.jsp</a>
</body>
</html>