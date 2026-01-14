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
	width: 800px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">내용 보기</h3>
			<table class="table">
				<tbody>
					<tr>
						<th width="20%" class="text-center warning">번호</th>
						<td width="30%" class="text-center">${vo.no}</td>
						<th width="20%" class="text-center warning">작성일</th>
						<td width="30%" class="text-center">${vo.dbday}</td>
					</tr>
					<tr>
						<th width="20%" class="text-center warning">이름</th>
						<td width="30%" class="text-center">${vo.name}</td>
						<th width="20%" class="text-center warning">조회수</th>
						<td width="30%" class="text-center">${vo.hit}</td>
					</tr>
					<tr>
						<th width="20%" class="text-center warning">제목</th>
						<td width="30%" class="text-center">${vo.subject}</td>
					</tr>
					<c:if test="${vo.filecount != 0}">
						<tr>
							<th width="20%" class="text-center warning">첨부파일</th>
							<td colspan="3" class="text-left">
								<ul>
									<c:forEach var="f" items="${fList}" varStatus="s">
										<li><a href="/databoard/download?fn=${f}">${f}</a>(${sList[s.index]}Bytes)</li>
									</c:forEach>
								</ul>
							</td>
						</tr>
					</c:if>
					<tr>
						<td colspan="4" class="text-left" valign="top" height="200">
							<pre style="white-space: pre-wrap; border: none; background-color: white;">${vo.content}</pre>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="text-right">
							<a href="#" class="btn btn-xs btn-danger">수정</a>
							<a href="/databoard/delete?no=${vo.no}" class="btn btn-xs btn-info">삭제</a>
							<a href="/databoard/list" class="btn btn-xs btn-primary">목록</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>