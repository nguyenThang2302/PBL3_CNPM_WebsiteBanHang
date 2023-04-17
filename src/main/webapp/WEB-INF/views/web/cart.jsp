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
	<style>
	  .cart-button {
        font-size: 0.8rem;
        padding: 0.25rem 0.5rem;
        background-color: #7fad39;
        color: #fff;
        border: none;
        border-radius: 0.25rem;
        cursor: pointer;
        margin-right: 0.5rem;
        height: 100%;
      }

      .quantity-input {
        font-size: 0.8rem;
        margin-right: 0.5rem;
        height: 100%;
        width: 40px;
      }

      .cart-button:hover {
        background-color: #005ea3;
      }
      
      .shoping__checkout ul li span {
	    font-size: 18px;
	    color: black;
	    float: right;
		}
      
</style>
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
                            	<tr class = "cart-product-${ item.value.product.code }">
                                    <td class="shoping__cart__item">
                                        <h5>${ item.value.product.name }</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                        ${ item.value.product.price }
                                    </td>
                                    <td class="shoping__cart__quantity">
                                        <div class="quantity">
                                            <button id="decrease-cart" class="decrease-cart cart-button" data-id = "${item.value.product.code}">-</button>
      											<input type="number" id="quantity-cart" class="quantity-input" value="${ item.value.quantity }" min="1" />
      										<button id="increase-cart" class="increase-cart cart-button" data-id = "${item.value.product.code}">+</button>			
                                        </div>
                                    </td>
                                    <td class="shoping__cart__total-${ item.value.product.code }" >
                                        ${ item.value.totalPrice }đ
                                    </td>
                                    <td class="shoping__cart__item__close">
                                    	<a class = "delete-cart" data-id = "${item.value.product.code}"  href = "xoa-khoi-gio-hang/${ item.value.product.code }"><span class="icon_close"></span></a>
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
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__continue">
                        <div class="shoping__discount">
                            <h5>Mã giảm giá</h5>
                            <form id="discount-form" action="check/discount">
                                <input type="text" id="discount-code" placeholder="Nhập mã giảm giá của bạn" required = "required">
                                <select class = "dropdown-discount" onchange="updateDiscountCode()">
							        <option value="">Chọn mã giảm giá</option>
							        <c:forEach var = "item" items = "${discountCodes}">
							        <option value="${item.code}">${item.name}</option>
							        </c:forEach>
    							</select>
                                <button type="submit" class="site-btn" onclick="updateAction()">Áp dụng</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng giỏ hàng</h5>
                        <ul>
                        <c:forEach var = "item" items = "${ Cart }">
                            <li class = "cart-product-${ item.value.product.code }">${ item.value.product.name }<span class = "total-price-products-${ item.value.product.code }">${ item.value.totalPrice }đ</span><span class = "total-quantity-${ item.value.product.code }" style = "margin-right: 185px">x${item.value.quantity}</span> </li>
                        </c:forEach>
                            <li>Tạm tính <span class = "total-price">${TotalPrice}đ</span></li>
                            <li>Giảm <span class = "total-price-discount">Chưa áp dụng mã giảm giá</span></li>
                            <li>Tổng tiền giỏ hàng <span class = "total-price-cart">${TotalPrice}đ</span></li>
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
    	const decreaseButtons = document.querySelectorAll(".decrease-cart");
    	const increaseButtons = document.querySelectorAll(".increase-cart");
    	const quantityInputs = document.querySelectorAll(".quantity-input");

    	decreaseButtons.forEach((decreaseButton) => {
    	  decreaseButton.addEventListener("click", (event) => {
    	    const index = Array.from(decreaseButtons).indexOf(decreaseButton);
    	    const currentValue = parseInt(quantityInputs[index].value);
    	    var quantity;
    	    if (currentValue > 1) {
    	      quantityInputs[index].value = currentValue - 1;
    	      quantity = currentValue - 1;
    	    } else {
    	      quantityInputs[index].value = 1;
    	      quantity = 1;
    	    }
    	    const code = event.target.getAttribute("data-id");
    	    var url = "cap-nhat-gio-hang/" + code + "/" + quantity;
    	    $.ajax({
    		      url: url,
    		      type: 'GET',
    		      success: function(response) {
    		    	  var jsonObj = JSON.parse(response);
    		    	  $('.shoping__cart__total-' + code).html(jsonObj.updatePrice + '.0đ');
    		    	  $('.total-price').html(jsonObj.TotalPrice + '.0đ');
    		    	  $('.total-price-products-' + code).html(jsonObj.updatePrice + '.0đ')
    		    	  $('.total-quantity-' + code).html('x' + quantity);
    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
    		    	  $('.total-price-header').html(jsonObj.TotalPrice);
    		    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPrice) + '.0đ');
    		      },
    		      error: function(xhr) {
    		        // Xử lý lỗi khi gửi yêu cầu Ajax.
    		        alert('Có lỗi xảy ra!');
    		      }
    		 });
    	  });
    	});

    	increaseButtons.forEach((increaseButton) => {
    	  increaseButton.addEventListener("click", (event) => {
    	    const index = Array.from(increaseButtons).indexOf(increaseButton);
    	    const currentValue = parseInt(quantityInputs[index].value);
    	    quantityInputs[index].value = currentValue + 1;
    	    const code = event.target.getAttribute("data-id");
    	    const quantity = currentValue + 1;
    	    var url = "cap-nhat-gio-hang/" + code + "/" + quantity;
    	    $.ajax({
    		      url: url,
    		      type: 'GET',
    		      success: function(response) {
    		    	  var jsonObj = JSON.parse(response);
    		    	  $('.shoping__cart__total-' + code).html(jsonObj.updatePrice + '.0đ');
    		    	  $('.total-price').html(jsonObj.TotalPrice + '.0đ');
    		    	  $('.total-price-products-' + code).html(jsonObj.updatePrice + '.0đ')
    		    	  $('.total-quantity-' + code).html('x' + quantity);
    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
    		    	  $('.total-price-header').html(jsonObj.TotalPrice);
    		    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPrice) + '.0đ');
    		      },
    		      error: function(xhr) {
    		        // Xử lý lỗi khi gửi yêu cầu Ajax.
    		        alert('Có lỗi xảy ra!');
    		      }
    		 });
    	  });
    	});
    	
    	$(document).ready(function() {
  		  $('.delete-cart').click(function(event) {
  		    event.preventDefault();
  		    var code = $(this).data("id");
  		    var url = $(this).attr('href');
  		  $.ajax({
		      url: url,
		      type: 'GET',
		      success: function(response) {
		    	  var jsonObj = JSON.parse(response);
		    	  $('.cart-product-' + jsonObj.deletedCode).remove();
		    	  $('.total-price').html(jsonObj.TotalPrice + '.0đ');
		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
		    	  $('.total-price-header').html(jsonObj.TotalPrice + '.0đ');
		    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPrice) + '.0đ');   	  
		      },
		      error: function(xhr) {
		        // Xử lý lỗi khi gửi yêu cầu Ajax.
		        alert('Có lỗi xảy ra!');
		      }
		    });
  		  });
  		});
    	
    	function updateDiscountCode() {
            var discountCodeInput = document.getElementById("discount-code");
            var dropdown = document.querySelector(".dropdown-discount");
            var selectedDiscountCode = dropdown.value;
            discountCodeInput.value = selectedDiscountCode;
        }
    	
    	function updateAction() {
    		  var form = document.getElementById("discount-form");
    		  var select = document.querySelector(".dropdown-discount");
    		  var value = select.value;
    		  if (value) {
    		    form.action = "check/discount/" + value;
    		  }
    	}
    	
    	$(document).ready(function() {
    		  $("#discount-form").submit(function(event) {
    		    event.preventDefault();
    		    var code = $("#discount-code").val();
    		    var url = "check/discount/" + code;
    		    $.ajax({
    			      url: url,
    			      type: 'GET',
    			      success: function(response) {
    			    	  var jsonObj = JSON.parse(response);
    			    	  $('.total-price-discount').html(Math.floor(jsonObj.TotalPrice - jsonObj.TotalPriceDiscount) + '.0đ');
    			    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPriceDiscount) + '.0đ');
    			    	  
    			    	  Toastify({
  							text: "Áp dụng mã giảm giá thành công!",
  							duration: 3000,
  							newWindow: true,
  							close: true,
  							gravity: "top",
  							position: "center",
  							backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
  						}).showToast();
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