<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c태그를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- fmt를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %> 
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
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="alternate" type="application/rss+xml" title="Latest snippets from Bootsnipp.com" href="https://bootsnipp.com/feed.rss">
<link rel="stylesheet" href="/face/resources/css/bootsnipp.min.css">
<meta charset="UTF-8">
	<title>로그인</title>
</head>
<!-- bootstrap & JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">

	function login() {
		
		$("#commentForm").validate();
		$.extend( $.validator.messages, { 
			required: "필수 항목입니다.",
		 } );
		
		document.getElementById("commentForm").submit();
	}
</script>
<style type="text/css">
	
	body{
		background-image: url('/face/resources/img/looping-bg.jpg');
	}
	.form-signin input[type="text"] {
	  margin-bottom: -1px;
	  border-bottom-left-radius: 0;
	  border-bottom-right-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	.form-signin .form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	}
</style>
<body>
	<div class="container" align="center">
		<div class="row" style="margin-top: 60px;">
			<div class="col-md-4 col-md-offset-4">
				<form id="commentForm" method="POST" action="loginCheck"
					accept-charset="UTF-8" role="form" id="commentForm"
					class="form-signin">
					<input name="_token" type="hidden"
						value="32KEVJ2Ty2nq1iHZWbzXTWQHDYqSKy4TORxjfqwu">
					<fieldset>
						<h3 class="sign-up-title"style="color: dimgray; text-align: center">
							Sign in to Yuhan<br>
							Face-Recognition
						</h3>

						<hr class="colorgraph">
						<input class="form-control email-title" placeholder="아이디를 입력해주세요."
							name="id" type="text">
						<input class="form-control" placeholder="비밀번호를 입력해주세요." 
							name="password" type="password">
						<a class="pull-right" href="/">
							Forgot password?
						</a>
						<br>
						<input class="btn btn-lg btn-success btn-block" type="submit"
							value="Login" onClick="login();">
						<p class="text-center" style="margin-top: 10px;">
						<p class="text-center">
							<a href="join">
								회원가입을 하시겠습니까?
							</a>
						</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>