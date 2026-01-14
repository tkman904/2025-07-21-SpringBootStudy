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
	width: 850px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">자료실</h3>
			<table class="table">
				<tr>
					<td>
						<a href="/databoard/insert" class="btn btn-sm btn-primary">등록</a>
					</td>
				</tr>
			</table>
			<table class="table">
				<thead>
					<tr class="success">
						<th width="10%" class="text-center">번호</th>
						<th width="40%" class="text-center">제목</th>
						<th width="15%" class="text-center">이름</th>
						<th width="20%" class="text-center">작성일</th>
						<th width="8%" class="text-center">조회수</th>
						<th width="7%" class="text-center">비고</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr class="success">
							<td width="10%" class="text-center">${vo.no}</td>
							<td width="40%"><a href="/databoard/detail?no=${vo.no}">${vo.subject}</a></td>
							<td width="15%" class="text-center">${vo.name}</td>
							<td width="20%" class="text-center">${vo.dbday}</td>
							<td width="8%" class="text-center">${vo.hit}</td>
							<td width="7%" class="text-center">
								<input type="checkbox" ${vo.filecount == 0 ? '' : 'checked'} disabled="disabled"> 
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="6" class="text-center">
							<a href="#" class="btn btn-sm btn-warning">이전</a>
							${curpage} page / ${totalpage} pages
							<a href="#" class="btn btn-sm btn-warning">다음</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>