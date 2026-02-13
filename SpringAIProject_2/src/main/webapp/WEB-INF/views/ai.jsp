<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 500px;
}

h3 {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<input type="text" class="input-sm" v-model="message">
			<button class="btn-sm btn-warning" @click="find()">전송</button>
		</div>
		<div class="row" style="margin-top: 30px;">
			{{list.generate}}
		</div>
	</div>
	<script>
		let app = Vue.createApp({
			data() {
				return {
					message: '점심 메뉴',
					list: {}
				}
			},
			mounted() {
				this.dataRecv()
			},
			methods: {
				dataRecv() {
					axios.get('/ai/generate', {
						params: {
							message: this.message
						}
					}).then(response=> {
						console.log(response.data)
						this.list = response.data
					})
				},
				find() {
					this.dataRecv()
				}
			}
		})
		app.mount('.container')
	</script>
</body>
</html>