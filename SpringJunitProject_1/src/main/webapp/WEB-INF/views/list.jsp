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
	width: 900px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">지니뮤직</h3>
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">순위</th>
						<th class="text-center"></th>
						<th class="text-center">제목</th>
						<th class="text-center">아티스트</th>
						<th class="text-center">앨범</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td class="text-center">${vo.no}</td>
							<td class="text-center">
								<img src="${vo.poster}" style="width: 30px; height: 30px;">
							</td>
							<td><a href="/detail?no=${vo.no}">${vo.title}</a></td>
							<td>${vo.singer}</td>
							<td>${vo.album}</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" class="text-center">
							<a href="/?page=${curpage > 1 ? curpage-1 : curpage}" class="btn btn-sm btn-danger">이전</a>
							${curpage} page / ${totalpage} pages
							<a href="/?page=${curpage < totalpage ? curpage+1 : curpage}" class="btn btn-sm btn-danger">다음</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>