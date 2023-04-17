<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<style>

</style>

<body>

<div class="container mt-4">
  <form action ="save" method="POST">
   <tr>
	<td colspan="2">
		<h3>Chỉnh sửa thông tin mã giảm giá: ${discountcode.name}</h3>
		<input type="hidden" name="id" value="${discountcode.id}">
	</td>
   </tr>
    <div class="form-group">
      <label for="name">Name</label>
      <input
        type="text"
        class="form-control"
        name="name"
        value="${discountcode.name}"
     />
    </div>
	<div class="form-group">
      <label for="code">Mã giảm giá</label>
      <input
        type="text"
        class="form-control"
        name="code"
        value="${discountcode.code}"
      />
    </div>
    <div class="form-group">
      <label for="price">Phần trăm giảm</label>
      <input
        type="text"
        class="form-control"
        name="percent"
        value="${discountcode.percent}"
      />
    </div>
    <div class="form-group">
      <label for="price">Số lượng</label>
      <input
        type="text"
        class="form-control"
        name="amount"
        value="${discountcode.amount}"
      />
    </div>
    <div class="form-group">
      <label for="price">Thời gian hiệu lực</label>
      <input
        type="date"
        class="form-control"
        name="valid_date"
        value="${discountcode.valid_date}"
      />
    </div>
    <button type="submit" class="btn btn-primary">Lưu Lại</button>
  </form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>    
</body>

</html>