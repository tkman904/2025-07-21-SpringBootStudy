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
	width: 600px;
}

h3 {
	text-align: center;
}
</style>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
<script>
	function connect() {
		const socket = new SockJS('/ws-chat')
		stompClient = Stomp.over(socket)
		
		stompClient.connect({}, function() {
			stompClient.subscribe('/topic/public', function(msg) {
				const data = JSON.parse(msg.body)
				showMessage(data)
			})
		})
	}
	
	function sendMessage() {
		stompClient.send('/app/chat.send', {}, JSON.stringify({
			sender: $('#sender').val(),
			message: $('#message').val() 
		}))
	}
	
	function showMessage(data) {
		//const li = document.createElement('li')
		//li.innerText = '[' + data.sender + ']' + data.message + '(' + data.time + ')'
		$('#chat').append(
			'<li>[' + data.sender + ']' + data.message + '(' + data.time + ')</li>'
		)
	}
	
	connect()
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3>간단한 WebSocket 채팅</h3>
			<table class="table">
				<tbody>
					<tr>
						<th width="15%" class="text-center" style="line-height: 30px">이름</th>
						<td width="85%" class="text-left">
							<input type="text" id="sender" size="20" class="input-sm">
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center" style="line-height: 30px">메시지</th>
						<td width="85%" class="text-left">
							<input type="text" id="message" size="50" class="input-sm">
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button class="btn-sm btn-primary" onclick="sendMessage()">전송</button>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<ul id="chat">
							
							</ul>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>