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
				<h5 class="user-name">QuangSang</h5>
				<h6 class="user-email">quangsang0709@gmail.com</h6>
			</div>
			<div class="about">
				<h5>About</h5>
				<p>I'm QuangSang. Full Stack Designer I enjoy creating user-centric, delightful and human experiences.</p>
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
					<form:input type="text" class="form-control" id="fullName" placeholder="${ LoginInfor.name }" path="name"/>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<form:label for="eMail" path="email">Email</form:label>
					<form:input type="email" class="form-control" id="eMail" placeholder="${ LoginInfor.email }" path="email"/>
				</div>
			</div>
			<div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
				<div class="form-group">
					<form:label for="phone" path="phone">Phone</form:label>
					<c:if test = "${ empty LoginInfor.phone }">
					<form:input type="text" class="form-control" id="phone" placeholder="Enter your phone" path="phone"/>
					</c:if>
					<c:if test = "${ not empty LoginInfor.phone }">
					<form:input type="text" class="form-control" id="phone" placeholder="${ LoginInfor.phone }" path="phone"/>
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
					<form:input type="name" class="form-control" id="address" placeholder="${ LoginInfor.address }" path="address"/>
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