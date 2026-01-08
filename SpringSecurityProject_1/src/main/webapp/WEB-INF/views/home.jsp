<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	width: 350px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">HOME</h3>
			<table class="table">
				<tbody>
					<sec:authorize access="isAuthenticated()">
						<tr>
							<td class="text-center">
								로그인 사용자 : <sec:authentication property="principal.username"/>
							</td>
						</tr>
					</sec:authorize>
					<sec:authorize access="hasRole('ADMIN')">
						<tr>
							<td class="text-center">
								<a href="/admin" class="btn btn-sm btn-primary">관리자 페이지</a>
							</td>
						</tr>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<tr>
							<td class="text-center">
								<a href="/user" class="btn btn-sm btn-info">사용자 페이지</a>
							</td>
						</tr>
					</sec:authorize>
					<tr>
						<td class="text-center">
							<form action="/logout" method="post">
								<button>로그아웃</button>
							</form>
						</td>
					</tr>
					<sec:authorize access="isAnonymous()">
						<tr>
							<td class="text-center">
								<a href="/login" class="btn btn-sm btn-success">로그인</a>
							</td>
						</tr>
					</sec:authorize>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>