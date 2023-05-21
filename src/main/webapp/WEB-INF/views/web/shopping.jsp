<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html>

<head>

	<meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Ogani | Contact</title>

</head>

<body>
<style>
		.product__discount__item__pic {
		    height: 180px;
		    width: 180px;
		    position: relative;
		    overflow: hidden;
		}
		.featured__item__pic {
		    height: 180px;
		    width: 180px;
		    position: relative;
		    overflow: hidden;
		    background-position: center center;
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
		.item_brand {
		  	border: 1px solid;
		    padding: 4px;
		    border-radius: 10px;
		}
		.c-btnbox, .item_brand {
		    align-items: center;
		    border: 1px solid #e0e0e0;
		    border-radius: 4px;
		    color: #333;
		    display: flex;
		    font-size: 14px;
		    justify-content: center;
		    line-height: 17px;
		    margin-bottom: 10px;
		    margin-right: 10px;
		    padding: 2px;
		}
		.filter-list {
		    display: flex;
		    flex-wrap: wrap;
		    margin-left: -32px;
		}
</style>
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Giá</h4>
                            <ul class = "filter-list">
                            	<li class = "item_price"><a href = "0/1000000" class = "c-btnbox">Dưới 1 triệu</a></li>
                            	<li class = "item_price"><a href = "1000000/5000000" class = "c-btnbox">Từ 1 đến 5 triệu</a></li>
                            	<li class = "item_price"><a href = "5000000/90000000" class = "c-btnbox">Từ 5 đến 9 triệu</a></li>
                            	<li class = "item_price"><a href = "9000000/50000000" class = "c-btnbox">Trên 9 triệu</a></li>
                            </ul>
                        </div>
                        <div class="sidebar__item sidebar__item__color--option">
                            <h4>Màu sắc</h4>
                            <!-- <ul class = "filter-list">
                            	<li><a href = "Trắng" class = "item_color">Màu Trắng</a></li>
                            	<li><a href = "Vàng" class = "item_color" style="background-color: yellow;">Màu Vàng</a></li>
                            	<li><a href = "Xám" class = "item_color" style="background-color: gray;">Màu Xám</a></li>
                            	<li><a href = "Đen" class = "item_color" style="background-color: black; color: white;">Màu Đen</a></li>
                            	<li><a href = "Đỏ" class = "item_color" style="background-color: #D62D2D; color: white;">Màu Đỏ</a></li>
                            	<li><a href = "Xanh" class = "item_color" style="background-color: #249BC8; color: white;">Màu Xanh</a></li>
                            </ul> -->
                             <div class="sidebar__item__color sidebar__item__color--white">
                                 <a href = "color/white" class = "item_color" id = "white">
                                     <label for = "white">Trắng</label>
                                 </a>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--gray">
                                <a href = "color/yellow" class = "item_color" id = "gray">
                                     <label for = "gray">Vàng</label>
                                </a>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--red">
                                <a href = "color/red" class = "item_color" id = "red">
                                     <label for = "red">Đỏ</label>
                                </a>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--black">
                                <a href = "color/black" class = "item_color" id = "black">
                                     <label for = "black">Đen</label>
                                </a>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--blue">
                                <a href = "color/blue" class = "item_color" id = "blue">
                                     <label for = "blue">Xanh biển</label>
                                </a>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--green">
                                <a href = "color/green" class = "item_color" id = "green">
                                     <label for = "green">Xanh lá</label>
                                </a>
                            </div>
                        </div>
                        	<div class="sidebar__item">
	                            <h4>Thương Hiệu</h4>
	                            <ul class = "filter-list">
	                            	<c:forEach var = "item" items = "${trademarks}">
		                            	<div class="sidebar__item__size">
			                                <li class = "item_price"><a href = "${item.name}" class = "item_brand">Hiệu ${item.name}</a></li>
			                            </div>
		                            </c:forEach>
	                            </ul>
	                        </div>
                        <div class="sidebar__item">
                            <div class="latest-product__text">
                                <h4>Sản phẩm mới</h4>
                                <div class="latest-product__slider owl-carousel">
                                    <div class="latest-prdouct__slider__item">
                                    <c:forEach var = "item" items = "${new_products}">
                                    	<a href="/spring-mvc/${item.code}" class="latest-product__item">
                                            <div class="latest-product__item__pic">
                                                <img src="${item.image}" alt="">
                                            </div>
                                            <div class="latest-product__item__text">
                                                <h6>${item.name}</h6>
                                                <span>${item.price}đ</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 col-md-7">
                    <div class="product__discount">
                        <div class="section-title product__discount__title">
                            <h2>Sản phẩm nổi bật</h2>
                        </div>
                        <div class="row">
                            <div class="product__discount__slider owl-carousel">
                            <c:forEach var = "item" items = "${top_products}">
                            <div class="col-lg-4">
	                              <div class="featured__item">
			                        <div class="featured__item__pic set-bg" data-setbg="${item.image}">
			                            <ul class="featured__item__pic__hover">
			                                <li><a class = "add_favourite_product" href="/spring-mvc/san-pham-yeu-thich/${item.code}"><i class="fa fa-heart"></i></a></li>
			                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
			                                <li><a class = "add-cart" href="/spring-mvc/them-vao-gio-hang/${item.code}"><i class="fa fa-shopping-cart"></i></a></li>
			                            </ul>
			                        </div>
			                        <div class="featured__item__text">
			                            <h6><a href="/spring-mvc/${item.code}">${item.name}</a></h6>
			                            <h5>${item.price}đ</h5>
			                        </div>
	                   			 </div>
                                </div>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="filter__item">
                        <div class="row">
                            <div class="col-lg-4 col-md-5">
                            </div>
                            <div class="col-lg-4 col-md-4">
                            <h2>Tất cả sản phẩm</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row featured__filter">
                    <c:forEach var="item" items = "${ products }">
             		<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${item.image}">
	                            <ul class="featured__item__pic__hover">
	                                <li><a class = "add_favourite_product" href="/spring-mvc/san-pham-yeu-thich/${item.code}"><i class="fa fa-heart"></i></a></li>
	                                <li><a class = "add-cart" href="/spring-mvc/them-vao-gio-hang/${item.code}"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul>
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="/spring-mvc/${item.code}">${item.name}</a></h6>
	                            <h5>${item.price}đ</h5>
	                        </div>
	                    </div>
	                   </div>
            		</c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Section End -->
    <content tag = "script">
     <script>
     	$(document).ready(function() {
    		  $('.add_favourite_product').click(function(event) {
    		    event.preventDefault();
    		    var url = $(this).attr('href');
    		  $.ajax({
  		      url: url,
  		      type: 'GET',
  		      success: function(response) {	  		    	  
  		    	  Toastify({
  		    		  text: "Bạn đã thích sản phẩm này!",
  		    		  duration: 3000,
  		    		  newWindow: true,
  		    		  close: true,
  		    		  gravity: "top", // hiển thị ở trên cùng màn hình
  		    		  position: "center", // căn giữa theo chiều ngang
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
    	$(document).ready(function() {
  		  $('.add-cart').click(function(event) {
  		    event.preventDefault();
  		    var url = $(this).attr('href');
  		  	var code = $(this).attr('href').split('/').pop();
  		  $.ajax({
		      url: url,
		      type: 'GET',
		      success: function(response) {	
		    	  var jsonObj = JSON.parse(response);
		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
		    	  $('.total-price-header').html(jsonObj.TotalPrice + '.0đ');
		    	  
		    	  Toastify({
		    		  text: "Thêm vào giỏ hàng thành công!",
		    		  duration: 3000,
		    		  newWindow: true,
		    		  close: true,
		    		  gravity: "top", // hiển thị ở trên cùng màn hình
		    		  position: "center", // căn giữa theo chiều ngang
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
  	
  	$(document).ready(function() {
		  $('.item_brand').click(function(event) {
		    event.preventDefault();
		    var url = $(this).attr('href');
		    $.ajax({
		      url: url,
		      type: 'GET',
		      success: function(response) {	
		    	  if (response == 0) {
		    		  Toastify({
	    		    		  text: "Không tìm thấy sản phẩm tương ứng!",
	    		    		  duration: 3000,
	    		    		  newWindow: true,
	    		    		  close: true,
	    		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	    		    		  position: "center", // căn giữa theo chiều ngang
	    		    		  backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
	    		    		}).showToast();
		    	  }
		    	  var newProductsHtml = ""; // chuỗi html mới
	  		        response.forEach(function(item) { // lặp qua các sản phẩm trả về
	  		        newProductsHtml += "<div class='col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat'>"
	  		        newProductsHtml += "<div class='featured__item'>"
	  		        newProductsHtml += "<div class='featured__item__pic set-bg' data-setbg='" + item.image + "'style='background-image: url(&quot;" + item.image + "'&quot;);>"
	  		        newProductsHtml += "<ul class='featured__item__pic__hover'>"
	  		        newProductsHtml += "<li><a class = 'add_favourite_product' href='/spring-mvc/san-pham-yeu-thich/" + item.code + "'><i class='fa fa-heart'></i></a></li>"
	  		        newProductsHtml += "<li><a class = 'add-cart' href='/spring-mvc/them-vao-gio-hang/" + item.code + "'><i class='fa fa-shopping-cart'></i></a></li>"
	  		        newProductsHtml += "</ul>"
	  		    	newProductsHtml += "</div>"
	  		        newProductsHtml += "<div class='featured__item__text'>"
	  		        newProductsHtml += "<h6><a href='/spring-mvc/" +item.code + "'>" + item.name + "</a></h6>"
	  		        newProductsHtml += "<h5>" + item.price + "đ</h5>"
	  		        newProductsHtml += "</div>"
	  		    	newProductsHtml += "</div>"
	  		    	newProductsHtml += "</div>"
	  		    		$(document).ready(function() {
	  		      		  $('.add-cart').click(function(event) {
	  		      		    event.preventDefault();
	  		      		    var url = $(this).attr('href');
	  		      		  	var code = $(this).attr('href').split('/').pop();
	  		      		  $.ajax({
	  		    		      url: url,
	  		    		      type: 'GET',
	  		    		      success: function(response) {	
	  		    		    	  var jsonObj = JSON.parse(response);
	  		    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
	  		    		    	  $('.total-price-header').html(jsonObj.TotalPrice + '.0đ');
	  		    		    	  
	  		    		    	  Toastify({
	  		    		    		  text: "Thêm vào giỏ hàng thành công!",
	  		    		    		  duration: 3000,
	  		    		    		  newWindow: true,
	  		    		    		  close: true,
	  		    		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	  		    		    		  position: "center", // căn giữa theo chiều ngang
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
	  		    	
	  		      $(document).ready(function() {
	  	    		  $('.add_favourite_product').click(function(event) {
	  	    		    event.preventDefault();
	  	    		    var url = $(this).attr('href');
	  	    		  $.ajax({
	  	  		      url: url,
	  	  		      type: 'GET',
	  	  		      success: function(response) {	  		    	  
	  	  		    	  Toastify({
	  	  		    		  text: "Bạn đã thích sản phẩm này!",
	  	  		    		  duration: 3000,
	  	  		    		  newWindow: true,
	  	  		    		  close: true,
	  	  		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	  	  		    		  position: "center", // căn giữa theo chiều ngang
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
	  		    });
	  		    // Cập nhật dữ liệu mới vào giao diện
	  		    $('.featured__filter').html(newProductsHtml);
		      },
		      error: function(xhr) {
		        // Xử lý lỗi khi gửi yêu cầu Ajax.
		        alert('Có lỗi xảy ra!');
		      }
		    });
		  });
		});
  	
  	$(document).ready(function() {
		  $('.c-btnbox').click(function(event) {
		    event.preventDefault();
		    var url = $(this).attr('href');
		    $.ajax({
		      url: url,
		      type: 'GET',
		      success: function(response) {
		    	  if (response == 0) {
		    		  Toastify({
	    		    		  text: "Không tìm thấy sản phẩm tương ứng!",
	    		    		  duration: 3000,
	    		    		  newWindow: true,
	    		    		  close: true,
	    		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	    		    		  position: "center", // căn giữa theo chiều ngang
	    		    		  backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
	    		    		}).showToast();
		    	  }
		    	  var newProductsHtml = ""; // chuỗi html mới
	  		        response.forEach(function(item) { // lặp qua các sản phẩm trả về
	  		        newProductsHtml += "<div class='col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat'>"
	  		        newProductsHtml += "<div class='featured__item'>"
	  		        newProductsHtml += "<div class='featured__item__pic set-bg' data-setbg='" + item.image + "'style='background-image: url(&quot;" + item.image + "'&quot;);>"
	  		        newProductsHtml += "<ul class='featured__item__pic__hover'>"
	  		        newProductsHtml += "<li><a class = 'add_favourite_product' href='/spring-mvc/san-pham-yeu-thich/" + item.code + "'><i class='fa fa-heart'></i></a></li>"
	  		        newProductsHtml += "<li><a class = 'add-cart' href='/spring-mvc/them-vao-gio-hang/" + item.code + "'><i class='fa fa-shopping-cart'></i></a></li>"
	  		        newProductsHtml += "</ul>"
	  		    	newProductsHtml += "</div>"
	  		        newProductsHtml += "<div class='featured__item__text'>"
	  		        newProductsHtml += "<h6><a href='/spring-mvc/" +item.code + "'>" + item.name + "</a></h6>"
	  		        newProductsHtml += "<h5>" + item.price + "đ</h5>"
	  		        newProductsHtml += "</div>"
	  		    	newProductsHtml += "</div>"
	  		    	newProductsHtml += "</div>"
	  		    		$(document).ready(function() {
	  		      		  $('.add-cart').click(function(event) {
	  		      		    event.preventDefault();
	  		      		    var url = $(this).attr('href');
	  		      		  	var code = $(this).attr('href').split('/').pop();
	  		      		  $.ajax({
	  		    		      url: url,
	  		    		      type: 'GET',
	  		    		      success: function(response) {	
	  		    		    	  var jsonObj = JSON.parse(response);
	  		    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
	  		    		    	  $('.total-price-header').html(jsonObj.TotalPrice + '.0đ');
	  		    		    	  
	  		    		    	  Toastify({
	  		    		    		  text: "Thêm vào giỏ hàng thành công!",
	  		    		    		  duration: 3000,
	  		    		    		  newWindow: true,
	  		    		    		  close: true,
	  		    		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	  		    		    		  position: "center", // căn giữa theo chiều ngang
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
	  		    	
	  		      $(document).ready(function() {
	  	    		  $('.add_favourite_product').click(function(event) {
	  	    		    event.preventDefault();
	  	    		    var url = $(this).attr('href');
	  	    		  $.ajax({
	  	  		      url: url,
	  	  		      type: 'GET',
	  	  		      success: function(response) {	  		    	  
	  	  		    	  Toastify({
	  	  		    		  text: "Bạn đã thích sản phẩm này!",
	  	  		    		  duration: 3000,
	  	  		    		  newWindow: true,
	  	  		    		  close: true,
	  	  		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	  	  		    		  position: "center", // căn giữa theo chiều ngang
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
	  		    });
	  		    // Cập nhật dữ liệu mới vào giao diện
	  		    $('.featured__filter').html(newProductsHtml);
		      },
		      error: function(xhr) {
		        // Xử lý lỗi khi gửi yêu cầu Ajax.
		        alert('Có lỗi xảy ra!');
		      }
		    });
		  });
		});
  	
  	$(document).ready(function() {
		  $('.item_color').click(function(event) {
		    event.preventDefault();
		    var url = $(this).attr('href');
		    $.ajax({
		      url: url,
		      type: 'GET',
		      success: function(response) {
		    	  if (response == 0) {
		    		  Toastify({
	    		    		  text: "Không tìm thấy sản phẩm tương ứng!",
	    		    		  duration: 3000,
	    		    		  newWindow: true,
	    		    		  close: true,
	    		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	    		    		  position: "center", // căn giữa theo chiều ngang
	    		    		  backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
	    		    		}).showToast();
		    	  }
		    	  var newProductsHtml = ""; // chuỗi html mới
	  		        response.forEach(function(item) { // lặp qua các sản phẩm trả về
	  		        newProductsHtml += "<div class='col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat'>"
	  		        newProductsHtml += "<div class='featured__item'>"
	  		        newProductsHtml += "<div class='featured__item__pic set-bg' data-setbg='" + item.image + "'style='background-image: url(&quot;" + item.image + "'&quot;);>"
	  		        newProductsHtml += "<ul class='featured__item__pic__hover'>"
	  		        newProductsHtml += "<li><a class = 'add_favourite_product' href='/spring-mvc/san-pham-yeu-thich/" + item.code + "'><i class='fa fa-heart'></i></a></li>"
	  		        newProductsHtml += "<li><a class = 'add-cart' href='/spring-mvc/them-vao-gio-hang/" + item.code + "'><i class='fa fa-shopping-cart'></i></a></li>"
	  		        newProductsHtml += "</ul>"
	  		    	newProductsHtml += "</div>"
	  		        newProductsHtml += "<div class='featured__item__text'>"
	  		        newProductsHtml += "<h6><a href='/spring-mvc/" +item.code + "'>" + item.name + "</a></h6>"
	  		        newProductsHtml += "<h5>" + item.price + "đ</h5>"
	  		        newProductsHtml += "</div>"
	  		    	newProductsHtml += "</div>"
	  		    	newProductsHtml += "</div>"
	  		    		$(document).ready(function() {
	  		      		  $('.add-cart').click(function(event) {
	  		      		    event.preventDefault();
	  		      		    var url = $(this).attr('href');
	  		      		  	var code = $(this).attr('href').split('/').pop();
	  		      		  $.ajax({
	  		    		      url: url,
	  		    		      type: 'GET',
	  		    		      success: function(response) {	
	  		    		    	  var jsonObj = JSON.parse(response);
	  		    		    	  $('.total-quantity').html(jsonObj.TotalQuantity);
	  		    		    	  $('.total-price-header').html(jsonObj.TotalPrice + '.0đ');
	  		    		    	  
	  		    		    	  Toastify({
	  		    		    		  text: "Thêm vào giỏ hàng thành công!",
	  		    		    		  duration: 3000,
	  		    		    		  newWindow: true,
	  		    		    		  close: true,
	  		    		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	  		    		    		  position: "center", // căn giữa theo chiều ngang
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
	  		    	
	  		      $(document).ready(function() {
	  	    		  $('.add_favourite_product').click(function(event) {
	  	    		    event.preventDefault();
	  	    		    var url = $(this).attr('href');
	  	    		  $.ajax({
	  	  		      url: url,
	  	  		      type: 'GET',
	  	  		      success: function(response) {	  		    	  
	  	  		    	  Toastify({
	  	  		    		  text: "Bạn đã thích sản phẩm này!",
	  	  		    		  duration: 3000,
	  	  		    		  newWindow: true,
	  	  		    		  close: true,
	  	  		    		  gravity: "top", // hiển thị ở trên cùng màn hình
	  	  		    		  position: "center", // căn giữa theo chiều ngang
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
	  		    });
	  		    // Cập nhật dữ liệu mới vào giao diện
	  		    $('.featured__filter').html(newProductsHtml);
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