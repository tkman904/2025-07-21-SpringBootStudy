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
	width: 960px;
}

p {
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}

.nav-link {
	cursor: pointer;
}
</style>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/vue-demi"></script>
<script src="https://unpkg.com/pinia@2/dist/pinia.iife.prod.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td class="text-center" colspan="3">
            <img :src="store.detail.poster" style="width: 960px; height: 450px;">
          </td>
        </tr>
        <tr>
          <td class="text-center" colspan="3"><h2>{{store.detail.title}}</h2></td>
        </tr>
        <tr>
          <td colspan="3">{{store.detail.content}}</td>
        </tr>
        <tr>
          <td class="text-center"><img src="/images/a1.png"></td>
          <td class="text-center"><img src="/images/a2.png"></td>
          <td class="text-center"><img src="/images/a3.png"></td>
        </tr>
        <tr>
          <td class="text-center">{{store.detail.info1}}</td>
          <td class="text-center">{{store.detail.info2}}</td>
          <td class="text-center">{{store.detail.info3}}</td>
        </tr>
        <tr>
          <td class="text-right" colspan="3">
            <a href="javascript:history.back()" class="btn btn-xs btn-warning">목록</a>
          </td>
        </tr>
      </table>
      <table class="table">
        <tr>
          <td colspan="2"><b style="font-size: 24px;">[조리순서]</b></td>
        </tr>
   <%-- <tr v-for="(vo, index) in store.detail">
          <td class="text-left" style="width: 80%; font-size: 18px;">[[${data}]]</td>
          <td class="text-right" width="20%">
            <img src="" style="width: 150px; height: 100px; border-radius: 15%;">
          </td>
        </tr> --%>
      </table>
      <table class="table">
        <tr>
          <td width="20%" class="text-center" rowspan="2">
            <img :src="store.detail.chef_poster" style="width: 100px; height: 100px;" class="img-circle">
          </td>
          <td width="80%">{{store.detail.chef}}</td>
        </tr>
        <tr>
          <td width="80%">{{store.detail.chef_profile}}</td>
        </tr>
      </table>
    </div>
  </div>
  <script src="/recipejs/recipeDetailStore.js"></script>
  <script>
    const detailApp = Vue.createApp({
    	setup() {
    		const store = useRecipeDetailStore()
    		const params = new URLSearchParams(location.search)
    		const no = params.get('no')
    		console.log("no="+no)
    		Vue.onMounted(()=> {
    			store.recipeDetailData(no)
    		})
    		
    		return {
    			store
    		}
    	}
    })
    detailApp.use(Pinia.createPinia())
    detailApp.mount('.container')
  </script>
</body>
</html>