<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profile</title>
</head>
<body>
<style>
body {
    margin: 0;
    color: #2e323c;
    background: #fffff;
    position: relative;
    height: 100%;
}

.container-lg, .container-md, .container-sm, .container-xl, .container-xxl {
    max-width: 1320px;
    padding-bottom: 50px;
}

.account-settings .user-profile {
    margin: 0 0 1rem 0;
    padding-bottom: 1rem;
    text-align: center;
}
.account-settings .user-profile .user-avatar {
    margin: 0 0 1rem 0;
}
.account-settings .user-profile .user-avatar img {
    width: 90px;
    height: 90px;
    -webkit-border-radius: 100px;
    -moz-border-radius: 100px;
    border-radius: 100px;
}
.account-settings .user-profile h5.user-name {
    margin: 0 0 0.5rem 0;
}
.account-settings .user-profile h6.user-email {
    margin: 0;
    font-size: 0.8rem;
    font-weight: 400;
    color: #9fa8b9;
}
.account-settings .about {
    margin: 2rem 0 0 0;
    text-align: center;
}
.account-settings .about h5 {
    margin: 0 0 15px 0;
    color: #007ae1;
}
.account-settings .about p {
    font-size: 0.825rem;
}
.form-control {
    border: 1px solid #cfd1d8;
    -webkit-border-radius: 2px;
    -moz-border-radius: 2px;
    border-radius: 2px;
    font-size: .825rem;
    background: #ffffff;
    color: #2e323c;
}

.card {
    background: #ffffff;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    border: 0;
    margin-bottom: 1rem;
}
.form-infor-user {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 63px;
}
.btn-primary {
    --mdb-btn-hover-border-color: 7fad39;
    --mdb-btn-focus-shadow-rgb: 88,134,210;
    --mdb-btn-active-border-color: #28a745;
    --mdb-btn-active-shadow: 0 8px 9px -4px rgba(0,0,0,0.15),0 4px 18px 0 rgba(0,0,0,0.1);
    --mdb-btn-disabled-color: #fff;
    --mdb-btn-disabled-bg: #7fad39;
    --mdb-btn-disabled-border-color: #7fad39;
    --mdb-btn-bg: #7fad39;
    --mdb-btn-color: #fff;
    --mdb-btn-box-shadow: 0 4px 9px -4px #7fad39;
    --mdb-btn-hover-bg: #7fad39;
    --mdb-btn-hover-color: #fff;
    --mdb-btn-focus-bg: #7fad39;
    --mdb-btn-focus-color: #fff;
    --mdb-btn-active-bg: #7fad39;
    --mdb-btn-active-color: #fff;
}
.btn:hover {
    color: var(--mdb-btn-hover-color);
    background-color: #7fad39;
    border-color: var(--mdb-btn-hover-border-color);
} 
.btn:hover {
    color: #ffffff;
    background-color: #5c9506;
    border-color: var(--mdb-btn-hover-border-color);
}
a:hover, a:focus {
    text-decoration: none;
    outline: none;
    color: #7fad398c;
}
a:hover {
    color: #7fad39;
    text-decoration: none;
}
a {
    color: #7fad39c7;
}
</style>
<div class="container-lg">
<div class="row gutters">
<div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
<div class="card h-100">
	<div class="card-body">
		<div class="account-settings">
			<div class="user-profile">
				<div class="user-avatar">
					<img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin">
				</div>
				<h5 class="user-name">${LoginInfor.name}</h5>
				<h6 class="user-email">${LoginInfor.email}</h6>
			</div>
			<div class="about">
				<h5>About</h5>
				<p>I'm ${LoginInfor.name}. Full Stack Designer I enjoy creating user-centric, delightful and human experiences.</p>
			</div>	
				<p class="text-center">
    				<a href="#" data-toggle="modal" data-target="#myModal">Thay đổi mật khẩu</a>
				</p>
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="myModalLabel">Thay đổi mật khẩu</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				      <form:form action="doi-mat-khau" method="post" modelAttribute="user">
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<%-- <form:label for="oldPassWord" path="password">Mật khẩu cũ</form:label>
									<form:input type="password" class="form-control" id="oldPassWord" placeholder="Nhập mật khẩu mới" path="password"  /> --%>
									<label for="oldPassWord" >Mật khẩu cũ</label>
									<input type="password" class="form-control" id="oldPassWord" placeholder="Nhập mật khẩu mới" name="oldPassword"  />
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="NewPassWord" >Mật khẩu mới</label>
									<input type="password" class="form-control" id="NewPassWord" placeholder="Nhập mật khẩu cũ" name="newPassword"  />
								</div>
							</div>
							<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
								<div class="form-group">
									<label for="RepeatNewPassWord" >Xác nhận mật khẩu mới</label>
									<input type="password" class="form-control" id="RepeatNewPassWord" placeholder="Nhập lại mật khẩu cũ" name="confirmPassword" />
								</div>
							</div>
							<div class="modal-footer">
				        		<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
				        		<!-- <button type="button" class="btn btn-primary">Lưu</button> -->
				        		
				        		<input type="submit" value="Lưu" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal2"/>
				        		<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">CẬP NHẬT</button> -->
				      		</div>
				      		
				      		<div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2" aria-hidden="true">
							    <div class="modal-dialog" role="document">
							        <div class="modal-content">
							            <div class="modal-header">
							                <h5 class="modal-title" id="exampleModalLabel2">THÔNG BÁO</h5>
							            </div>
							            <div class="modal-body">
									    <c:choose>
									        <c:when test="${not empty thanhcong}">
									            <i class="fst-italic">${thanhcong}</i>
									        </c:when>
									        <c:when test="${not empty thatbai}">
									            <i class="fst-italic">${thatbai}</i>
									        </c:when>
									        <c:when test="${not empty thatbai2}">
									            <i class="fst-italic">${thatbai2}</i>
									        </c:when>
									    </c:choose>
							            </div>
							        </div>
							    </div>
							</div>
<!-- 							<script src="/views/script.js"></script>
 -->							
					  </form:form>
				      </div>
				    </div>
				  </div>
				</div>
		</div>
	</div>
</div>
</div>
<div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
<div class="card h-100">
	<div class="card-body">
	<div class = "form-infor-user">
		<form:form action="cap-nhat-thong-tin" method="post" modelAttribute="user"> 
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<h6 class="mb-2 text-primary">Personal Details</h6>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<form:label for="fullName" path="name">Full Name</form:label>
					<form:input type="text" class="form-control" id="fullName" value="${ LoginInfor.name }" path="name"/>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<form:label for="eMail" path="email">Email</form:label>
					<form:input type="email" class="form-control" id="eMail" value="${ LoginInfor.email }" path="email"/>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<form:label for="phone" path="phone">Phone</form:label>
					<c:if test = "${ empty LoginInfor.phone }">
					<form:input type="text" class="form-control" id="phone" placeholder="Enter your phone" path="phone"/>
					</c:if>
					<c:if test = "${ not empty LoginInfor.phone }">
					<form:input type="text" class="form-control" id="phone" value="${ LoginInfor.phone }" path="phone"/>
					</c:if>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<form:label for="address" path="address">Address</form:label>
					<c:if test = "${ empty LoginInfor.address }">
					<form:input type="name" class="form-control" id="address" placeholder="Enter your address" path="address"/>
					</c:if>
					<c:if test = "${ not empty LoginInfor.address }">
					<form:input type="name" class="form-control" id="address" value="${ LoginInfor.address }" path="address"/>
					</c:if>
				</div>
			</div>
		</div>
		<div class="row gutters">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="text-right">
 					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">CẬP NHẬT</button>
				</div>
			</div>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">XÁC NHẬN THAY ĐỔI</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <i class="fst-italic" >Bấm Lưu thay đổi để xác nhận, Đóng để thoát!</i>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
		        <input type="submit" value="lưu thay đổi" class="btn btn-primary"/>
		      </div>
		    </div>
		  </div>
		</div>
    	</form:form>
	</div>
	</div>
</div>
</div>
</div>
</div>
</body>
</html>