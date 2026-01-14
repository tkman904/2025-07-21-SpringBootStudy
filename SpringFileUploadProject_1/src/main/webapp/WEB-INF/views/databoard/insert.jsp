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
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">등록하기</h3>
			<form action="/databoard/insert_ok" method="post" enctype="multipart/form-data">
				<table class="table">
					<tbody>
						<tr>
							<th class="text-center warning" width="15%">이름</th> 
							<td width="85%" class="text-left">
								<input type="text" name="name" size="20" class="input-sm" required="required">
							</td>
						</tr>
						<tr>
							<th class="text-center warning" width="15%">제목</th> 
							<td width="85%" class="text-left">
								<input type="text" name="subject" size="60" class="input-sm" required="required">
							</td>
						</tr>
						<tr>
							<th class="text-center warning" width="15%">내용</th> 
							<td width="85%" class="text-left">
								<textarea rows="10" cols="60" name="content" required="required"></textarea>
							</td>
						</tr>
						<tr>
							<th class="text-center warning" width="15%">첨부파일</th> 
							<td width="85%" class="text-left">
								<input type="file" name="files" size="30" class="input-sm" multiple="multiple">
							</td>
						</tr>
						<tr>
							<th class="text-center warning" width="15%">비밀번호</th> 
							<td width="85%" class="text-left">
								<input type="password" name="pwd" size="10" class="input-sm" required="required">
							</td>
						</tr>
						<tr>
							<td colspan="2" class="text-center">
								<button class="btn-sm btn-danger">등록</button>
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