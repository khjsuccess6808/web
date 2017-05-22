<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!--taglib 등록  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>여러 이미지 업로드 결과-</h1>
업로더: ${requestScope.result.uploader }<br>
설명:${requestScope.result.comment }<br>
업로더된 이미지들 <br>

<c:forEach items="${requestScope.result.imageNames }" var="name">

   <img src="${initParam.rootPath }/up_images/${name }" width="350px">
</c:forEach>




<!--조금이라도 이클립스 소스들을 바꾸면 왼쪽 up_images 에 있는 파일들은 다 없어지고 다시 실행해봐도 엑스박스 나온다,
    만약 이걸 고치고 싶으면 사진들을 직접 넣는 수밖에 없다.
  -->



<h1>1개 이미지 업로드 결과</h1>
업로더: ${requestScope.uploader }<br>
설명:${requestScope.comment }<br>
파일 명:${requestScope.image }

<img src="${initParam.rootPath }/up_images/${requestScope.image}"/>

</body>
</html>