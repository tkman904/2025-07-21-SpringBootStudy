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
			<h3 class="text-center">상세보기</h3>
			<table class="table">
				<tbody>
					<tr>
						<th class="danger text-center" width="20%">번호</th>
						<td class="text-center" width="30%">${vo.no}</td>
						<th class="danger text-center" width="20%">작성일</th>
						<td class="text-center" width="30%">${vo.dbday}</td>
					</tr>
					<tr>
						<th class="danger text-center" width="20%">이름</th>
						<td class="text-center" width="30%">${vo.name}</td>
						<th class="danger text-center" width="20%">조회수</th>
						<td class="text-center" width="30%">${vo.hit}</td>
					</tr>
					<tr>
						<th width="20%" class="danger text-center">제목</th>
						<td colspan="4">${vo.subject}</td> 
					</tr>
					<tr>
						<td colspan="4" valign="top" class="text-left">
							<pre style="white-space: pre-wrap; background-color: white; border: none;">${vo.content}</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="text-right">
							<a href="#" class="btn btn-sm btn-danger">수정</a>
							<a href="#" class="btn btn-sm btn-danger">삭제</a>
							<a href="/board/list" class="btn btn-sm btn-danger">목록</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>