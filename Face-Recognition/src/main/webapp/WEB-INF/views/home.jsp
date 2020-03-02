<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c태그를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- fmt를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- Favicon -->
<link rel="apple-touch-icon" sizes="180x180" href="/face/resources/icon/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="/face/resources/icon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="/face/resources/icon/favicon-16x16.png">
<link rel="manifest" href="/face/resources/icon/site.webmanifest">
<meta name="msapplication-TileColor" content="#da532c">
<meta name="theme-color" content="#ffffff">
<!-- End Favicon -->
<!-- bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- CSS -->
<link rel="stylesheet" href="/face/resources/css/main.css">
<meta charset="UTF-8">
	<title>유한대학교</title>
</head>
<!-- bootstrap & JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.btnStyle{
		width: 200px;
		height: 200px;
	}
	.fontStyle{
		font-size: 20px;
		color: white;
		font-weight: bold;
		text-align: center;
	}
</style>
<body>

	<div class="container" style="margin-top: 150px;">
		<div style="float:left"></div>
			<div align="center" style="float:left">
				<div class="item button-jittery" style="background: #f1c40f; width: 300px; height: 300px; text-align: center;
					padding-top: 50px; border-radius: 10px; margin-right: 20px; margin-left: 100px;">
					<button class="btnStyle" onClick="location.href='signup'">
						<p class="fontStyle">회원가입</p>
					</button>
				</div>
			</div>
		
		<div style="float:left; margin-left: 60px;">
			<div class="item button-jittery" style="background: #e67e22; width: 300px; height: 300px; text-align: center;
				padding-top: 50px; border-radius: 10px; margin-right: 20px;">
				<button class="btnStyle" onClick="">
					<p class="fontStyle">로그인</p>
				</button>
			</div>
		</div>
	</div>
	
</body>
</html>