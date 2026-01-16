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
	width: 900px;
}

h3 {
	text-align: center;
}

.chat-body {
	height: 450px;
	overflow-y: auto; 
}

.my-msg {
	text-align: right;
	color: #337ab7;
}
</style>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/vue-demi"></script>
<script src="https://unpkg.com/pinia@2/dist/pinia.iife.prod.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript">
	 const LOGIN_USER = '${sessionScope.userid}'
</script>
</head>
<body>
	<div class="container" id="app">
		<div class="row">
			<div class="col-sm-3">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<b>접속자 목록</b>
					</div>
					<ul class="list-group">
						<li class="list-group-item" @click="store.changeRoom(u)" style="cursor: pointer;" v-for="(u, i) in store.users" :key="i">{{u}}</li>
						<li class="list-group-item" @click="store.changeRoom('public')" style="cursor: pointer;">전체 채팅</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-9">
				<div class="panel panel-primary">
					<div class="panel-heading text-center">
						<b>{{store.currentRoom === 'public' ? '전체 채팅' : '1:1 채팅 -' + store.currentRoom}}</b>
					</div>
					<div class="panel-body chat-body">
						<div v-for="(m, i) in store.messages">
							<div :class="{'my-msg' : m.sender === store.loginUser}">
								<b>{{m.sender}}</b>: {{m.message}}
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<div class="input-group">
							<input type="text" class="form-control" v-model="store.msg" @keyup.enter="store.send()" placeholder="메시지 입력">
							<span class="input-group-btn">
								<button class="btn-sm btn-primary" @click="store.send()">전송</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/chatStore.js"></script>
	<script>
		const { createApp, onMounted, ref } = Vue
		const { createPinia } = Pinia
		const chatApp = createApp({
			setup() {
				const store = useChatStore()
				
				onMounted(()=> {
					store.loginUser = LOGIN_USER
					store.connect()
				})
				
				return {
					store
				}
			}
		})
		chatApp.use(createPinia())
		chatApp.mount('#app')
	</script>
</body>
</html>