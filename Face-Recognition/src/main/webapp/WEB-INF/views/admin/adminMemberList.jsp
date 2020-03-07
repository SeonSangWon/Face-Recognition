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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
	<title>admin</title>
</head>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	function logout(){
		
		location.href='../logout';
	}
</script>
<c:if test="${sessionScope.student_id eq null}">
	<script>
		location.href='../';
	</script>
</c:if>
<style>
	td{
		text-align: center;
	}
</style>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<td>
					학번
				</td>
				<td>
					이름
				</td>
				<td>
					전화번호
				</td>
				<td>
					탈퇴여부
				</td>
				<td>
					가입일자
				</td>
				<td>
					DB수정일자
				</td>
			</tr>
			<c:forEach items="${adminMemberList}" var="list">
				<tr>
					<td>
						${list.student_id}
					</td>
					<td>
						${list.name}
					</td>
					<td>
						${list.phone}
					</td>
					<td>
						<c:set var="ghost" value="${list.ghost}" />
						<c:if test="${ghost eq 'n'}">
							정상
						</c:if>
						<c:if test="${ghost eq 'y'}">
							탈퇴
						</c:if>
					</td>
					<td>
						${list.create_date}
					</td>
					<td>
						${list.modified_date}
					</td>
				</tr>
			</c:forEach>
		</table>
		<div align="center">
			<button class="btn btn-outline-info"" onClick="logout();">로그아웃</button>
		</div>
	</div>
</body>
</html>