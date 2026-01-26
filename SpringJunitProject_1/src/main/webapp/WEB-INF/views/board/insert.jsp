<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	width: 800px;
}
</style>
</head>
<!-- 
	1. JSP : MyBatis => JDBC
	2. AJAX / jQuery
	3. Spring-Boot : MyBatis
	4. Vue / Pinia
	5. Spring-Boot : JPA
	6. React / TanStack-Query
 -->
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">글쓰기</h3>
			<form action="/board/insert_ok" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th class="danger text-center" width="20%">이름</th>
							<td width="80%">
								<input type="text" name="name" size="20" class="input-sm" required>
							</td>
						</tr>
						<tr>
							<th class="danger text-center" width="20%">제목</th>
							<td width="80%">
								<input type="text" name="subject" size="60" class="input-sm" required>
							</td>
						</tr>
						<tr>
							<th class="danger text-center" width="20%">내용</th>
							<td width="80%">
								<textarea rows="10" cols="60" name="content" required></textarea>
							</td>
						</tr>
						<tr>
							<th class="danger text-center" width="20%">비밀번호</th>
							<td width="80%">
								<input type="password" name="pwd" size="10" class="input-sm" required>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">
								<button type="submit" class="btn-sm btn-danger">글쓰기</button>
								<button type="button" class="btn-sm btn-danger" onclick="javascript:history.back()">취소</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>