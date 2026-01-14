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
	width: 500px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">파일 업로드</h3>
			<form action="/upload_ok" method="post" enctype="multipart/form-data">
				<input type="file" name="file" size="20" style="float: left;">
				<button type="submit" style="float: left;">업로드</button>
			</form>
		</div>
		<div class="row" style="margin-top: 20px;">
			<h3 class="text-center">파일 다중 업로드</h3>
			<form action="/multi-upload" method="post" enctype="multipart/form-data">
				<input type="file" name="files" size="20" style="float: left;" multiple="multiple">
				<button type="submit" style="float: left;">업로드</button>
			</form>
		</div>
	</div>
</body>
</html>