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
	width: 400px;
}
</style>
<script>
	const NO = '${param.no}'
</script>
<script src="https://unpkg.com/vue@3.3.4/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">삭제하기</h3>
			<table class="table">
				<tbody>
					<tr>
						<td class="text-center">
							비밀번호: <input type="password" name="pwd" size="20" class="input-sm" v-model="pwd" ref="pwd">
						</td>
					</tr>
					<tr>
						<td class="text-center">
							<button class="btn-sm btn-danger" @click="del()">삭제</button>
							<button type="button" class="btn-sm btn-primary" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<script>
		const app = Vue.createApp({
			data() {
				return {
					pwd: '',
					no: 0
				}
			},
			mounted() {
				this.no = NO
			},
			methods: {
				del() {
					if(this.pwd === '') {
						this.$refs.pwd.focus()
						return
					}
					
					axios.delete('/databoard/delete_ok/', {
						params: {
							no: this.no,
							pwd: this.pwd
						}
					}).then(response=> {
						if(response.data === 'yes') {
							location.href = '/databoard/list'
						} else {
							alert("잘못된 비밀번호 입니다")
							this.pwd = ''
							this.$refs.pwd.focus()
						}
					})
				}
			}
		})
		app.mount('.container')
	</script>
</body>
</html>