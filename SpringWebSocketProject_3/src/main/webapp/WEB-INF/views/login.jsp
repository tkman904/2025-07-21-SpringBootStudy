<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
	margin: 0px auto;
	width: 330px;
}

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>로그인</h3>
			<form action="/login_process" method="post">
				<table class="table">
					<tr>
						<td width="25%" class="text-center">ID</td>
						<td width="75%">
							<input type="text" name="username" size="25" class="input-sm">
						</td>
					</tr>
					<tr>
						<td width="25%" class="text-center" style="border: none;">PW</td>
						<td width="75%" style="border: none;">
							<input type="password" name="password" size="25" class="input-sm">
						</td>
					</tr>
					<tr>
						<td colspan="2" style="border: none;">
							자동로그인 <input type="checkbox" name="remember-me">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button type="submit" class="btn-sm btn-success">로그인</button>
							<button type="button" class="btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
			</form>
			<c:if test="${param.error != null}">
				<p style="color: red; margin: 0px auto;">${sessionScope.loginError}</p>
			</c:if>
		</div>
	</div>
</body>
</html>