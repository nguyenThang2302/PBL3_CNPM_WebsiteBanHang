<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Ogani | Cart</title>

</head>

<body>
     <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Giỏ Hàng</h2>
                        <div class="breadcrumb__option">
                            <a href="/spring-mvc/trang-chu">Trang chủ</a>
                            <span>Shopping Cart</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shoping Cart Section Begin -->
    <section class="shoping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__table">
                        <table>
                            <thead>
                                <tr>
                                    <th class="shoping__product">Sản phẩm</th>
                                    <th>Giá</th>
                                    <th>Số lượng</th>
                                    <th>Tổng tiền</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var = "item" items = "${ Cart }">
                            	<tr>
                                    <td class="shoping__cart__item">
                                        <h5>${ item.value.product.name }</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        ${ item.value.product.price }
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <div class="pro-qty">
                                                <input id = "quantity-cart-${ item.value.product.code }" type="number" value="${ item.value.quantity }">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                        ${ item.value.totalPrice }đ
                                    </td>
                                    <td class="shoping__cart__item__close">
                                    	<button data-id = "${item.value.product.code}" type = "button" class = "btn edit-cart"><img src = "https://i.imgur.com/mGwEMqM.png"/></button>
                                    	<a href = "xoa-khoi-gio-hang/${ item.value.product.code }"><span class="icon_close"></span></a>
                                    </td>
                                </tr>
                            	</c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="shoping__cart__btns">
                        <a href="/spring-mvc/trang-chu" class="primary-btn cart-btn">Tiếp tục mua sắm</a>
                        <a href="#" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                            Cập nhật giỏ hàng</a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Mã giảm giá</h5>
                            <form action="#">
                                <input type="text" placeholder="Nhập mã giảm giá của bạn">
                                <button type="submit" class="site-btn">Áp dụng</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng giỏ hàng</h5>
                        <ul>
                        <c:forEach var = "item" items = "${ Cart }">
                            <li>${ item.value.product.name } x${item.value.quantity}đ <span>${ item.value.totalPrice }đ</span></li>
                        </c:forEach>
                            <li>Tổng tiền <span>${TotalPrice}đ</span></li>
                        </ul>
                        <a href="#" class="primary-btn">Tiến hành thanh toán</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->
    
    <content tag = "script">
    	<script>
    	$(document).ready(function() {
  		  $('.edit-cart').click(function(event) {
  		    event.preventDefault();
  		  	var code = $(this).data("id");
			var quantity = $("#quantity-cart-" +  code).val();
			var url = "cap-nhat-gio-hang/" + code + "/" + quantity;
  		    $.ajax({
  		      url: url,
  		      type: 'GET',
  		      success: function(response) {
  		        // Cập nhật thông tin giỏ hàng hoặc hiển thị thông báo thêm sản phẩm thành công.
  		        // Ở đây bạn có thể xử lý kết quả trả về từ controller và cập nhật trang web tương ứng;
  		      },
  		      error: function(xhr) {
  		        // Xử lý lỗi khi gửi yêu cầu Ajax.
  		        alert('Có lỗi xảy ra!');
  		      }
  		    });
  		  });
  		});
    	</script>
    </content>

</body>

</html>