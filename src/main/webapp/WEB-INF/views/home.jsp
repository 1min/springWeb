<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P><!-- serverTime 어트리뷰트 가져옴 -->
<p><img src="/springex/resources/candy.jpg"/></p>

<p><img src="/springex/myResources/candy.jpg"/></p><!-- 이미지파일 가져오기 -->


</body>
</html>
