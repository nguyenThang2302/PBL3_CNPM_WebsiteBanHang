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
  <form action ="savemota" method="POST">
   <tr>
	<td colspan="2">
		<h3>Mô tả sản phẩm: ${products.name}</h3>
		<input type="hidden" name="product_code" value="${desProduct.product_code}">
	</td>
   </tr>
    <div class="form-group">
      <label for="brand">Thương Hiệu</label>
      <input
        type="text"
        class="form-control"
        name="brand"
        value="${desProduct.brand}"
     />
    </div>
	<div class="form-group">
      <label for="description">Mô tả</label>
      <div>
      <textarea rows="5" cols="117" name = "description">${desProduct.description}</textarea>
      </div>
    </div>
    <div class="form-group">
      <label for="information">Thông tin</label>
      <div>
      <textarea rows="5" cols="117" name = "information">${desProduct.information}</textarea>
      </div>
    </div>
    <div class="form-group">
      <label for="salient">Thông số kĩ thuật</label>
      <div>
      <textarea rows="5" cols="117" name = "salient">${desProduct.salient}</textarea>
      </div>
    </div>
    <div class="form-group">
      <label for="brand">Video Review</label>
      <input
        type="text"
        class="form-control"
        name="video_url"
        value="${desProduct.video_url}"
     />
    </div>
    <div class="form-group">
      <label for="brand">Mô tả hỉnh ảnh 1</label>
      <input
        type="text"
        class="form-control"
        name="des_image1"
        value="${desProduct.des_image1}"
     />
    </div>
    <div class="form-group">
      <label for="brand">Mô tả hỉnh ảnh 2</label>
      <input
        type="text"
        class="form-control"
        name="des_image2"
        value="${desProduct.des_image2}"
     />
    </div>
    <div class="form-group">
      <label for="brand">Mô tả hỉnh ảnh 3</label>
      <input
        type="text"
        class="form-control"
        name="des_image3"
        value="${desProduct.des_image3}"
     />
    </div>
    <div class="form-group">
      <label for="brand">Mô tả hỉnh ảnh 4</label>
      <input
        type="text"
        class="form-control"
        name="des_image4"
        value="${desProduct.des_image4}"
     />
    </div>
    <div class="form-group">
      <label for="color">Màu sắc</label>
      <input
        type="text"
        class="form-control"
        name="color"
        value="${desProduct.color}"
      /> 
      </div>
      <div class="form-group">
      <label for="status">Tình trạng</label>
      <input
        type="text"
        class="form-control"
        name="status"
        value="${desProduct.status}"
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