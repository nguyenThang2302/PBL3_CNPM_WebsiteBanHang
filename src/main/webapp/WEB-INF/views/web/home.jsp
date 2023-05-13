<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Trang chủ</title>

</head>

<body>
	<style>
		.trademark{
			text-align: center;
			color: #1c1c1c;
			font-weight: 700;
			position: relative;
			font-size: 2rem;
			font-family: "Cairo", sans-serif;
		}
		.set-bg{
			width: 200px;
		}
		.featured__item__pic {
		    height: 200px;
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
	</style>
	
	<div class= "trademark">
	<h1>Thương Hiệu</h1>
	</div>
	<!-- Categories Section Begin -->
    <section class="categories">
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                <c:forEach var="item" items="${trademarks}">
                	<div class="col-lg-3">
                        <div class="categories__item set-bg" data-setbg="${item.image}">	
                            <h5><a href="${item.url}">${item.name}</a></h5>
                        </div>
                    </div>     
                </c:forEach> 
                </div>
            </div>
        </div>
    </section> 
    <!-- Categories Section End -->
    
        <!-- Latest Product Section Begin -->
    <section class="latest-product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Sản phẩm mới nhất</h4>
                        <c:forEach var = "item" items = "${new_products}">
                        	<div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <a href="${item.code}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.image}" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.name}</h6>
                                        <span>${item.price}đ</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Sản phẩm hàng đầu</h4>
                        <c:forEach var = "item" items = "${top_products}">
                        	<div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <a href="${item.code}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.image}" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.name}</h6>
                                        <span>${item.price}đ</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>Sản phẩm đánh giá cao</h4>
                        <c:forEach var = "item" items = "${favourite_products}">
                        	<div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <a href="${item.code}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.image}" alt="">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.name}</h6>
                                        <span>${item.price}đ</span>
                                    </div>
                                </a>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Featured Section Begin -->
    <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="featured__controls">
                        <ul>
                            <li><a class = "mapper_products" href = "/spring-mvc/danh-muc/tat-ca-san-pham" style="color: #1c1c1c;">Tất cả</a></li>
                            <li><a class = "mapper_products" href = "/spring-mvc/danh-muc/noi-chien-khong-dau" style="color: #1c1c1c;">Nồi Chiên Không Dầu</a></li>
                            <li><a class = "mapper_products" href = "/spring-mvc/danh-muc/lo-nuong" style="color: #1c1c1c;">Lò Nướng</a></li>
                            <li><a class = "mapper_products" href = "/spring-mvc/danh-muc/bep-cac-loai" style="color: #1c1c1c;">Bếp Các Loại</a></li>
                            <li><a class = "mapper_products" href = "/spring-mvc/danh-muc/may-xay-va-may-ep" style="color: #1c1c1c;">Máy Xay Và Máy Ép</a></li>
                        </ul>
                        <ul>
                        	<li><a class = "mapper_products" href = "/spring-mvc/danh-muc/quat-lanh" style="color: #1c1c1c;">Quạt Lạnh</a></li>
                        	<li><a class = "mapper_products" href = "/spring-mvc/danh-muc/may-che-bien-thuc-pham" style="color: #1c1c1c;">Máy Chế Biến Thực Phẩm</a></li>
                        	<li><a class = "mapper_products" href = "/spring-mvc/danh-muc/noi-com-dien-tu" style="color: #1c1c1c;">Nồi Cơm Điện Tử</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            
            <div class="row featured__filter" id="product-list">
            <c:forEach var="item" items = "${ products }">
             		<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
                    <div class="featured__item">
                        <div class="featured__item__pic set-bg" data-setbg="${item.image}">
                            <ul class="featured__item__pic__hover">
                                <li><a class = "add_favourite_product" href="san-pham-yeu-thich/${item.code}"><i class="fa fa-heart"></i></a></li>
                                <li><a class = "add-cart" href="/spring-mvc/them-vao-gio-hang/${item.code}"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="featured__item__text">
                            <h6><a href="${item.code}">${item.name}</a></h6>
                            <h5>${item.price}đ</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
            </div>
        </div>
    </section>
    <!-- Featured Section End -->

    <!-- Banner Begin -->
    <div class="banner">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-1.jpg" alt="">
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="banner__pic">
                        <img src="img/banner/banner-2.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner End -->

    <!-- Blog Section Begin -->
    <section class="from-blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title from-blog__title">
                        <h2>Chuỗi Mới Deal Khủng</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn/2023/05/banner/760x400-760x400-1.jpg" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> Từ 12/05 - 14/05</li>
                            </ul>
                            <h5><a href="https://www.avakids.com/online-gia-re?utm_source=avakids&utm_medium=2050&utm_campaign=ngaycuame">Deal tặng mẹ. Giảm sốc đến 50%</a></h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn/2023/05/banner/760-x-400-NH-760x400-3.png" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> Từ 28/05 - 19/06</li>
                            </ul>
                            <h5><a href="https://www.avakids.com/?utm_source=DMX&utm_medium=Banner2050&utm_campaign=GiadungT5#gia-soc">Đại tiệc gia dụng. Giảm sốc tới nốc 50%</a></h5>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="blog__item">
                        <div class="blog__item__pic">
                            <img src="https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn/2023/03/banner/760-400-760x400-1.png" alt="">
                        </div>
                        <div class="blog__item__text">
                            <ul>
                                <li><i class="fa fa-calendar-o"></i> Từ 13/05 - 17/07</li>
                            </ul>
                            <h5><a href="https://www.dichvutantam.com/">Vệ sinh máy lạnh</a></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Section End -->
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
    		var productList = document.getElementById('product-list');
    		  $('.mapper_products').click(function(event) {
    		    event.preventDefault();
    		    var url = $(this).attr('href');
	    		  $.ajax({
	  		      url: url,
	  		      type: 'GET',
	  		      success: function(response) {	
	  		    	var newProductsHtml = ""; // chuỗi html mới
	  		        response.forEach(function(item) { // lặp qua các sản phẩm trả về
	  		        newProductsHtml += "<div class='col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat'>"
	  		        newProductsHtml += "<div class='featured__item'>"
	  		        newProductsHtml += "<div class='featured__item__pic set-bg' data-setbg='" + item.image + "'style='background-image: url(&quot;" + item.image + "'&quot;);>"
	  		        newProductsHtml += "<ul class='featured__item__pic__hover'>"
	  		        newProductsHtml += "<li><a class = 'add_favourite_product' href='san-pham-yeu-thich/" + item.code + "'><i class='fa fa-heart'></i></a></li>"
	  		        newProductsHtml += "<li><a class = 'add-cart' href='/spring-mvc/them-vao-gio-hang/" + item.code + "'><i class='fa fa-shopping-cart'></i></a></li>"
	  		        newProductsHtml += "</ul>"
	  		    	newProductsHtml += "</div>"
	  		        newProductsHtml += "<div class='featured__item__text'>"
	  		        newProductsHtml += "<h6><a href='" +item.code + "'>" + item.name + "</a></h6>"
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