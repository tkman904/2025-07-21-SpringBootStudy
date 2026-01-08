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
	width: 350px;
	margin: 0px auto;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">로그인</h3>
			<c:if test="${param.error != null}">
				<table class="table">
					<tbody>
						<tr>
							<td class="text-center">
								<span style="color: red">잘못된 아이디 또는 비밀번호 입니다</span>
							</td>
						</tr>
					</tbody>
				</table>
			</c:if>
			<form action="/login" method="post">
				<table class="table">
					<tbody>
						<tr>
							<td width="30%" class="text-center">ID</td>
							<td width="70%">
								<input type="text" name="username" class="input-sm" size="25">
							</td>
						</tr>
						<tr>
							<td width="30%" class="text-center">PW</td>
							<td width="70%">
								<input type="password" name="password" class="input-sm" size="25">
							</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">
								<button type="submit" class="btn-sm btn-warning">로그인</button>
								<button type="button" class="btn-sm btn-warning" onclick="javascript:history.back()">취소</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>