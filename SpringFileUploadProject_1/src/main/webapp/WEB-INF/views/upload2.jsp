<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3.3.4/dist/vue.global.js"></script>
<script src="https://unpkg.com/vue-demi"></script>
<script src="https://unpkg.com/pinia@2.1.7/dist/pinia.iife.prod.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">Vue를 이용한 파일 업로드</h3>
			<input type="file" multiple="multiple" size="20" @change="handlerFile" style="float: left;">
			<button @click="submit" style="float: left;">등록</button>
		</div>
	</div>
	<script>
		const app = Vue.createApp({
			data() {
				return {
					files: []
				}
			},
			methods: {
				handlerFile(e) {
					this.files = e.target.files
					console.log(this.files)
				},
				submit() {
					const formData = new FormData()
					for(let i of this.files) {
						formData.append('files', i)
					}
					console.log(formData)
					axios.post('/multi-upload', formData, {
						headers: {
							'Content-Type': 'multipart/form-data'
						}
					}).then(()=> alert("등록 완료"))
				}
			}
		}).mount('.container')
	</script>
</body>
</html>