<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
	
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Đăng Nhập</title>

</head>

<body>

<style>
	.container{
	display: center;
	background-color: #FFFFFF;
	margin-top: 150px;
	width: 900px;
	height: 650px;
	filter:
		drop-shadow(10px 10px 10px #000);
	border-radius: 30px;
	}
</style>
<div class = "container"> 
<!-- Pills navs -->
<ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
  <li class="nav-item" role="presentation">
    <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="#pills-login" role="tab"
      aria-controls="pills-login" aria-selected="true">Đăng Nhập</a>
  </li>
  <li class="nav-item" role="presentation">
    <a class="nav-link" href="/spring-mvc/dang-ky" aria-selected="true">Đăng Ký</a>
  </li>
</ul>
<!-- Pills navs -->

<!-- Pills content -->
<div class="tab-content">
  <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
    <form:form action="hoan-thanh" method="post" modelAttribute="user"> 
      <div class="text-center mb-3">
            <a href="/spring-mvc/trang-chu"><img src="<c:url value='/template/web/img/logo.png'/>"alt=""></a>
      </div>

      <!-- Email input -->
      <div class="form-outline mb-4">
        <form:input type="email" class="form-control" path="email" />  
        <form:label class="form-label" for="loginName" path="email" >Email or username</form:label>
      </div>

      <!-- Password input -->
      <div class="form-outline mb-4">
        <form:input type="password" class="form-control" path="password" />  
        <form:label class="form-label" for="loginPassword" path="password">Password</form:label>
      </div>

      <!-- 2 column grid layout -->
      <div class="row mb-4">
        <div class="col-md-6 d-flex justify-content-center">
          <!-- Checkbox -->
          <div class="form-check mb-3 mb-md-0">
            <input class="form-check-input" type="checkbox" value="" id="loginCheck" checked />
            <label class="form-check-label" for="loginCheck"> Lưu đăng nhập </label>
          </div>
        </div>

        <div class="col-md-6 d-flex justify-content-center">
          <!-- Simple link -->
          <a href="#!">Quên mật khẩu?</a>
        </div>
      </div>
      
      <div class="text-center">
      	<h6 style="color: #FF0000" class="fst-italic" >${ status_Login }</h6>
      </div>
	
      <!-- Submit button -->
      <input type="submit" value="Đăng nhập" class="btn btn-primary btn-block mb-3"/>

      <!-- Register buttons -->
      <div class="text-center">
        <p>Bạn chưa có tài khoản? <a href="/spring-mvc/dang-ky">Đăng ký | </a> <a href="/spring-mvc/trang-chu">Trang chủ</a></p>
      </div>	
    </form:form>
  </div>
  <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
    <form>
      <div class="text-center mb-3">
        <p>Đăng ký với:</p>
        <button type="button" class="btn btn-link btn-floating mx-1">
          <i class="fab fa-facebook-f"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
          <i class="fab fa-google"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
          <i class="fab fa-twitter"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
          <i class="fab fa-github"></i>
        </button>
      </div>

      <p class="text-center">hoặc:</p>

      <!-- Name input -->
      <div class="form-outline mb-4">
        <input type="text" id="registerName" class="form-control" 
        	placeholder="Họ và Tên"/>
        <label class="form-label" for="registerName">Name</label>
      </div>

      <!-- Username input -->
      <div class="form-outline mb-4">
        <input type="text" id="registerUsername" class="form-control"
        	placeholder="Tên đăng nhập"/>
        <label class="form-label" for="registerUsername">Username</label>
      </div>

      <!-- Email input -->
      <div class="form-outline mb-4">
        <input type="email" id="registerEmail" class="form-control" 
        	placeholder="Email"/>
        <label class="form-label" for="registerEmail">Email</label>
      </div>

      <!-- Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="registerPassword" class="form-control" 
        	placeholder="Password"/>
        <label class="form-label" for="registerPassword">Password</label>
      </div>

      <!-- Repeat Password input -->
      <div class="form-outline mb-4">
        <input type="password" id="registerRepeatPassword" class="form-control" />
        <label class="form-label" for="registerRepeatPassword">Repeat password</label>
      </div>

      <!-- Checkbox -->
      <div class="form-check d-flex justify-content-center mb-4">
        <input class="form-check-input me-2" type="checkbox" value="" id="registerCheck" checked
          aria-describedby="registerCheckHelpText" />
        <label class="form-check-label" for="registerCheck">
          Tôi đã đọc và đồng ý với các điều khoản
        </label>
      </div>

      <!-- Submit button -->
      <button type="submit" class="btn btn-primary btn-block mb-3">Đăng Ký</button>
    </form>
  </div>
</div>
<!-- Pills content -->
	</div>
</body>
</html>