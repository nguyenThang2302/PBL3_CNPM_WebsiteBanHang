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
      #search-result .suggest_search {
		    background: #fff;
		    border: 1px solid #eee;
		    top: -24px;
		    z-index: 100000;
		    left: 2px;
		    right: 2px;
		    border-radius: 6px;
		    box-shadow: 0 1px 8px rgb(0 0 0 / 30%);
		}	
		#search-result .suggest_search li {
		    display: block;
		    overflow: hidden;
		    padding: 10px;
		    border-bottom: 1px solid #eee;
		}
		.hero__search__form {
			position: absolute;
			top: 0;
			left: 0;
		}
		#search-result .suggest_search li.ttitle {
		    position: relative;
		}
		#search-result .suggest_search li .viewed {
		    background: #f5f5f5;
		    font-size: 13px;
		    color: #666;
		    font-weight: 400;
		    padding: 10px;
		    margin: -15px -10px;
	    }
	    .search_image {
	    	height: 60px;
    		width: 60px;
	    }
	    .search_name {
	    	color: #252525;
	    }
	    .carousel-inner {
		  position: relative;
		}
		#search-result {
		  position: absolute;
		  z-index: 999;
		  margin-left: 180px;
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
                                        ${ item.value.totalPrice } VNĐ
                                    </td>
                                    <td class="shoping__cart__item__close">
                                    	<a id = "btn-delete-cart" class = "delete-cart" data-id = "${item.value.product.code}"  href = "xoa-khoi-gio-hang/${ item.value.product.code }"><span class="icon_close"></span></a>
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
                                <button id = "btn-apply-discount" type="submit" class="site-btn" onclick="updateAction()">Áp dụng</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="shoping__checkout">
                        <h5>Tổng giỏ hàng</h5>
                        <ul>
                        <c:forEach var = "item" items = "${ Cart }">
                            <li class = "cart-product-${ item.value.product.code }">${ item.value.product.name }<span class = "total-price-products-${ item.value.product.code }">${ item.value.totalPrice } VNĐ</span><span class = "total-quantity-${ item.value.product.code }" style = "margin-right: 185px">x${item.value.quantity}</span> </li>
                        </c:forEach>
                            <li>Tạm tính <span class = "total-price">${TotalPrice} VNĐ</span></li>
                            <li>Giảm <span class = "total-price-discount">Chưa áp dụng mã giảm giá</span></li>
                            <li>Tổng tiền giỏ hàng <span class = "total-price-cart">${TotalPrice} VNĐ</span></li>
                        </ul>
                        <c:choose>
						    <c:when test="${ empty Cart }">
						        <a href="#" class="primary-btn btn-checkout disabled" id="checkout-button">Tiến hành thanh toán</a>
						    </c:when>
						    <c:otherwise>
						        <!-- <a href="thanh-toan" class="primary-btn btn-checkout">Tiến hành thanh toán</a> -->
						        <!-- <a href="javascript:window.location.href='thanh-toan?redirect=' + encodeURIComponent(window.location.href);" class="primary-btn btn-checkout">Tiến hành thanh toán</a> -->
						        <a href="thanh-toan?redirect=<%= java.net.URLEncoder.encode(request.getRequestURL().toString(), "UTF-8") %>&secret_key=pbl3_cnpm" class="primary-btn btn-checkout">Tiến hành thanh toán</a>
						    </c:otherwise>
						</c:choose>
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
    		    	  $('.shoping__cart__total-' + code).html(jsonObj.updatePrice + '.0 VNĐ');
    		    	  $('.total-price').html(jsonObj.TotalPrice + '.0 VNĐ');
    		    	  $('.total-price-products-' + code).html(jsonObj.updatePrice + '.0 VNĐ')
    		    	  $('.total-quantity-' + code).html('x' + quantity);
    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
    		    	  $('.total-price-header').html(jsonObj.TotalPrice);
    		    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPrice) + '.0 VNĐ');
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
    		    	  $('.shoping__cart__total-' + code).html(jsonObj.updatePrice + '.0 VNĐ');
    		    	  $('.total-price').html(jsonObj.TotalPrice + '.0 VNĐ');
    		    	  $('.total-price-products-' + code).html(jsonObj.updatePrice + '.0 VNĐ')
    		    	  $('.total-quantity-' + code).html('x' + quantity);
    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
    		    	  $('.total-price-header').html(jsonObj.TotalPrice);
    		    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPrice) + '.0 VNĐ');
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
		    	  if( jsonObj.TotalPrice == 0) {
		    		  location.reload();
		    	  }
		    	  $('.cart-product-' + jsonObj.deletedCode).remove();
		    	  $('.total-price').html(jsonObj.TotalPrice + '.0 VNĐ');
		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
		    	  $('.total-price-header').html(jsonObj.TotalPrice + '.0 VNĐ');
		    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPrice) + '.0 VNĐ');   	  
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
    			    	  $('.total-price-discount').html(Math.floor(jsonObj.TotalPrice - jsonObj.TotalPriceDiscount) + '.0 VNĐ');
    			    	  $('.total-price-cart').html(Math.floor(jsonObj.TotalPriceDiscount) + '.0 VNĐ');
    			    	  
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
    	
    	 document.getElementById("checkout-button").addEventListener("click", function(event) {
    	        if (${empty Cart}) {
    	            event.preventDefault(); // Ngăn chặn hành động mặc định của nút thanh toán
    	            Toastify({
    	                text: "Giỏ hàng của bạn đang trống!",
    	                duration: 3000,
    	                newWindow: true,
    	                close: true,
    	                gravity: "top",
    	                position: "center",
    	                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
    	          }).showToast(); // Hiển thị thông báo
    	        }
    	    });
    	 
    	 document.getElementById("btn-apply-discount").addEventListener("click", function(event) {
    		 var discountCode = document.getElementById("discount-code").value;
   		     if (!discountCode) {
   			    Toastify({
  	                text: "Bạn chưa chọn mã giảm giá!",
  	                duration: 3000,
  	                newWindow: true,
  	                close: true,
  	                gravity: "top",
  	                position: "center",
  	                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
  	          }).showToast(); // Hiển thị thông báo
   		        return;
   		      } else if (${empty Cart}) {
 	            event.preventDefault(); // Ngăn chặn hành động mặc định của nút thanh toán
 	            Toastify({
 	                text: "Giỏ hàng của bạn đang trống!",
 	                duration: 3000,
 	                newWindow: true,
 	                close: true,
 	                gravity: "top",
 	                position: "center",
 	                backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
 	          }).showToast(); // Hiển thị thông báo
 	        }
 	    });
    	 
    	 function searchProducts(keyword) {
   		  return fetch('http://localhost:8080/spring-mvc/api/products')
   		    .then(res => {
   		      return res.json();
   		    })
   		    .then(products => {
   		      let result = [];
   		      let searchWords = keyword.split("-");
   		      products.forEach(product => {
   		        let searchName = product.search_name.toLowerCase();
   		        let matchCount = 0;
   		        searchWords.forEach(word => {
   		          if (searchName.includes(word)) {
   		            matchCount++;
   		          }
   		        });
   		        if (matchCount === searchWords.length) {
   		          result.push(product);
   		        }
   		      });
   		      return result;
   		    })
   		    .catch(err => {
   		      console.error(err);
   		    });
   		}
   	
   	function convertVietnameseToUnsigned(str) {
   		  // Tạo bảng chuyển đổi ký tự tiếng Việt
   		  var charMap = {
   		    'à': 'a', 'á': 'a', 'ả': 'a', 'ã': 'a', 'ạ': 'a',
   		    'ă': 'a', 'ằ': 'a', 'ắ': 'a', 'ẳ': 'a', 'ẵ': 'a', 'ặ': 'a',
   		    'â': 'a', 'ầ': 'a', 'ấ': 'a', 'ẩ': 'a', 'ẫ': 'a', 'ậ': 'a',
   		    'đ': 'd',
   		    'è': 'e', 'é': 'e', 'ẻ': 'e', 'ẽ': 'e', 'ẹ': 'e',
   		    'ê': 'e', 'ề': 'e', 'ế': 'e', 'ể': 'e', 'ễ': 'e', 'ệ': 'e',
   		    'ì': 'i', 'í': 'i', 'ỉ': 'i', 'ĩ': 'i', 'ị': 'i',
   		    'ò': 'o', 'ó': 'o', 'ỏ': 'o', 'õ': 'o', 'ọ': 'o',
   		    'ô': 'o', 'ồ': 'o', 'ố': 'o', 'ổ': 'o', 'ỗ': 'o', 'ộ': 'o',
   		    'ơ': 'o', 'ờ': 'o', 'ớ': 'o', 'ở': 'o', 'ỡ': 'o', 'ợ': 'o',
   		    'ù': 'u', 'ú': 'u', 'ủ': 'u', 'ũ': 'u', 'ụ': 'u',
   		    'ư': 'u', 'ừ': 'u', 'ứ': 'u', 'ử': 'u', 'ữ': 'u', 'ự': 'u',
   		    'ỳ': 'y', 'ý': 'y', 'ỷ': 'y', 'ỹ': 'y', 'ỵ': 'y'
   		  };
   		  // Chuyển đổi ký tự có dấu thành ký tự không dấu
   		  var result = '';
   		  for (var i = 0; i < str.length; i++) {
   		    var c = str.charAt(i);
   		    result += charMap[c] || c;
   		  }
   		  // Loại bỏ các ký tự không cần thiết
   		  result = result.replace(/[^a-z0-9]+/gi, '-'); 
   		  // Loại bỏ dấu - ở đầu và cuối chuỗi
   		  result = result.replace(/^-+|-+$/g, '');  
   		  // Chuyển đổi chuỗi thành chữ thường
   		  result = result.toLowerCase();  
   		  return result;
   		}
   	
   	var searchForm = document.getElementById('search_form');
   	searchForm.addEventListener("submit", function(event) {
   		event.preventDefault();
   		let foundProducts = [];
   	    var inputValue = document.getElementById("search-input").value;
   	    var searchResult = document.getElementById("search-result");
   	    searchResult.innerHTML = "";
   	    var userInput = convertVietnameseToUnsigned(inputValue);
   	    searchProducts(userInput.toLowerCase()).then(productsFound => {
     		  if (productsFound.length > 0) {
     		    var productHtml = "<ul class = 'suggest_search'>"
     		    	productHtml += "<li class = 'ttitle'>"
     		    	productHtml += "<div class = 'viewed'>Sản phẩm gợi ý</div>";
     		    	productHtml += "</li>"
     		    productsFound.forEach(product => {
     		    	productHtml += "<li class = 'suggest_product'>"
     		    	productHtml += "<img class = 'search_image' src = '" + product.image + "'>"
     		    	productHtml += "<a href = '" + product.code + "' class = 'search_name'>" + product.name + "</a>";
     		        productHtml += "<p>Giá: " + product.price + ".0đ</p>";
     		    	productHtml += "</li>"
     		    	foundProducts.push(product);
     		    });
     		  productHtml += "</ul>";
     		  searchResult.innerHTML += productHtml;
     		  } else {
     		    var productHtml = "<ul class = 'suggest_search'>"
     		    	productHtml += "<li class = 'ttitle'>"
         		    productHtml += "<div class = 'viewed'>Sản phẩm không được tìm thấy</div>";
         		    productHtml += "</li>"
     		    	productHtml += "</ul>"
     		    searchResult.innerHTML += productHtml;
     		  }
     		});
   	});
   	
   	document.addEventListener('click', function(event) {
   		  var searchResult = document.getElementById('search-result');
   		  var searchInput = document.getElementById('search-input');
   		  var target = event.target;
   		  if (target !== searchResult && target !== searchInput) {
   		    searchResult.innerHTML = '';
   		  }
   		});
    	</script>
    </content>

</body>

</html>