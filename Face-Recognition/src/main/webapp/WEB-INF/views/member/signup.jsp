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
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<!-- bootstrap & JQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Js -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">

	function LoginPageMove() {
		location.href = "signin";
	}

	function memberInsert() {
		$("#commentForm").validate();
		$.extend( $.validator.messages, { 
			required: "필수 항목입니다."
		}
		document.getElementById("commentForm").submit();
	}
</script>
<style>
	.register{
	    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
	    margin-top: 3%;
	    padding: 3%;
	}
	.register-left{
	    text-align: center;
	    color: #fff;
	    margin-top: 4%;
	}
	.register-left input{
	    border: none;
	    border-radius: 1.5rem;
	    padding: 2%;
	    width: 60%;
	    background: #f8f9fa;
	    font-weight: bold;
	    color: #383d41;
	    margin-top: 30%;
	    margin-bottom: 3%;
	    cursor: pointer;
	}
	.register-right{
	    background: #f8f9fa;
	    border-top-left-radius: 10% 50%;
	    border-bottom-left-radius: 10% 50%;
	}
	.register-left img{
	    margin-top: 15%;
	    margin-bottom: 5%;
	    width: 25%;
	    -webkit-animation: mover 2s infinite  alternate;
	    animation: mover 1s infinite  alternate;
	}
	@-webkit-keyframes mover {
	    0% { transform: translateY(0); }
	    100% { transform: translateY(-20px); }
	}
	@keyframes mover {
	    0% { transform: translateY(0); }
	    100% { transform: translateY(-20px); }
	}
	.register-left p{
	    font-weight: lighter;
	    padding: 12%;
	    margin-top: -9%;
	}
	.register .register-form{
	    padding: 10%;
	    margin-top: 10%;
	}
	.btnRegister{
	    float: right;
	    margin-top: 10%;
	    border: none;
	    border-radius: 1.5rem;
	    padding: 2%;
	    background: #0062cc;
	    color: #fff;
	    font-weight: 600;
	    width: 50%;
	    cursor: pointer;
	}
	.register .nav-tabs{
	    margin-top: 3%;
	    border: none;
	    background: #0062cc;
	    border-radius: 1.5rem;
	    width: 28%;
	    float: right;
	}
	.register .nav-tabs .nav-link{
	    padding: 2%;
	    height: 34px;
	    font-weight: 600;
	    color: #fff;
	    border-top-right-radius: 1.5rem;
	    border-bottom-right-radius: 1.5rem;
	}
	.register .nav-tabs .nav-link:hover{
	    border: none;
	}
	.register .nav-tabs .nav-link.active{
	    width: 100px;
	    color: #0062cc;
	    border: 2px solid #0062cc;
	    border-top-left-radius: 1.5rem;
	    border-bottom-left-radius: 1.5rem;
	}
	.register-heading{
	    text-align: center;
	    margin-top: 8%;
	    margin-bottom: -15%;
	    color: #495057;
	}
</style>
<body>
	<form id="commentForm" method="POST" action="memberInsert">
		<div class="container register">
			<div class="row">
				<div class="col-md-3 register-left">
					<img src="/face/resources/img/yuhan.jpg" alt="" />
					<h3>Welcome</h3>
					<p>
						얼굴인식을 통한<br> 유한대학교<br> 사이버강의/종합정보<br> 접속 시스템입니다.
					</p>
					<input type="submit" name="" value="Login"
						onClick="LoginPageMove();" /><br />
				</div>
				<div class="col-md-9 register-right">
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<h3 class="register-heading">회원가입</h3>

							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="학번을 입력해주세요." name="student_id" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="아이디를 입력해주세요." name="id" required />
									</div>
									<div class="form-group">
										<select name="phone_1" class="form-control"
											style="width: 150px; float: right;">
											<option value="010">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
											<option value="017">017</option>
											<option value="018">018</option>
											<option value="019">019</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="이름을 입력해주세요." name="name" required />
									</div>
									<div class="form-group">
										<input type="password" maxlength="16" class="form-control"
											placeholder="비밀번호를 입력해주세요." name="password" required />
									</div>
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="전화번호를 입력해주세요. ('-'제외)" name="phone_2" required />
									</div>
									<input type="submit" class="btnRegister" value="회원가입"
										onClick="memberInsert();" />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>