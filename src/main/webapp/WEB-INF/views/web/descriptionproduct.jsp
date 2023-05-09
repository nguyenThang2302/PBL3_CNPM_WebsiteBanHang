<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html>

<head>

	<meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Ogani | About Us</title>

</head>

<body>
	<style>
	.product__item__pic{
	height: 150px;
	position: relative;
	overflow: hidden;
	width: 150px;
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
                        <h2>Thông Tin Sản Phẩm</h2>
                        <div class="breadcrumb__option">
                            <a href="/spring-mvc/trang-chu">Trang Chủ</a>
                            <span>Sản phẩm</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                                <iframe width="560" height="315" src="https://www.youtube.com/embed/${desProduct.video_url}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                        </div>
                        <div class="product__details__pic__slider owl-carousel">
                            <img data-imgbigurl="img/product/details/product-details-2.jpg"
                                src="${desProduct.des_image1}" alt="">
                            <img data-imgbigurl="img/product/details/product-details-3.jpg"
                                src="${desProduct.des_image2}" alt="">
                            <img data-imgbigurl="img/product/details/product-details-5.jpg"
                                src="${desProduct.des_image3}" alt="">
                            <img data-imgbigurl="img/product/details/product-details-4.jpg"
                                src="${desProduct.des_image4}" alt="">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${products.name}</h3>
                        <div class="product__details__rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half-o"></i>
                        </div>
                        <div class="product__details__price">${products.price}</div>
                        <div class="product__details__quantity">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <input id = "quantity-cart-${ products.code }" type="number" value="1">
                                </div>
                            </div>
                        </div>
                        <a href="/spring-mvc/san-pham-yeu-thich/${products.code}" class="heart-icon"><span class="icon_heart_alt"></span></a>
                        <a href="/spring-mvc/them-vao-gio-hang/${departmentsSlugName.slug_name}/${desProduct.product_code}" type = "button" class="primary-btn add-cart" data-id = "${ products.code }">Thêm vào giỏ hàng</a>
                        <ul>
                            <li><b>Thương hiệu</b> <span>${desProduct.brand}</span></li>
                            <li><b>Màu sắc</b> <span>${desProduct.color}</span></li>
                            <li><b>Trạng thái</b> <span>${desProduct.status}</span></li>
                        </ul>
                    </div>
                </div>

                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">Mô tả</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">Thông tin</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">Thông số kĩ thuật</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <p>${desProduct.description}</p>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <p>${desProduct.information}</p>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <p>${desProduct.salient}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

    <!-- Related Product Section Begin -->
    <section class="related-product">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title related__product__title">
                        <h2>Sản phẩm liên quan</h2>
                    </div>
                </div>
            </div>
            <div class="row">
            <c:forEach var="item" items ="${related_products}">
            	<div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="${item.image}">
                            <ul class="product__item__pic__hover">
                                <li><a href="/spring-mvc/san-pham-yeu-thich/${item.code}" class="heart-icon"><i class="fa fa-heart"></i></a></li>
                                <li><a href="/spring-mvc/them-vao-gio-hang/${item.code}" class = "add-cart-no-quantity"><i class="fa fa-shopping-cart"></i></a></li>
                            </ul>
                        </div>
                        <div class="product__item__text">
                            <h6><a href="/spring-mvc/${item.code}">${item.name}</a></h6>
                            <h5>${item.price}đ</h5>
                        </div>
                    </div>
                </div>  
            </c:forEach>    
            </div>
        </div>
    </section>
    <!-- Related Product Section End -->
    <content tag = "script">
     	<script>
     	$(document).ready(function() {
    		  $('.add-cart-no-quantity').click(function(event) {
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
    		  $('.heart-icon').click(function(event) {
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
  		    var code = $(this).data("id");
  		    var quantity = $("#quantity-cart-" +  code).val();
  		    var url = $(this).attr('href') + "/" + quantity;
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
    	</script>
    </content>
</body>

</html>