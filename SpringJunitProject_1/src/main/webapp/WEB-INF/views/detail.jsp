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
.container-fluid {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 100%;
}

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<c:forEach var="vo" items="${list}">
				<div class="col-md-4">
					<div class="thumbnail">
						<embed src="http://youtube.com/embed/${vo.key}" title="${vo.title}" style="width: 585px; height: 300px;">
						<div class="caption">
							<p>${vo.title}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>