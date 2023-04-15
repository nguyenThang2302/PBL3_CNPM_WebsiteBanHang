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
<<<<<<< HEAD
<<<<<<< HEAD
                        <a href="#" class="primary-btn">Thêm vào giỏ hàng</a>
                        <a href="/spring-mvc/san-pham-yeu-thich/${products.code}" class="heart-icon"><span class="icon_heart_alt"></span></a>
=======
                        <a href="/spring-mvc/them-vao-gio-hang/${departmentsSlugName.slug_name}/${desProduct.product_code}" class="primary-btn">Thêm vào giỏ hàng</a>
=======
                        <a href="/spring-mvc/them-vao-gio-hang/${departmentsSlugName.slug_name}/${desProduct.product_code}" type = "button" class="primary-btn add-cart" data-id = "${ products.code }">Thêm vào giỏ hàng</a>
<<<<<<< HEAD
                        <%-- <button class="add-cart" data-id = "${ products.code }" type = "button"></button> --%>
>>>>>>> 81f8941 (PBL3-8: Cart)
=======
>>>>>>> 64b8917 (PBL3-8: Cart)
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
>>>>>>> bde99bb (PBL3-8: Cart)
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
            <c:forEach var="item" items ="${departments}">
            <div class="col-lg-3 col-md-4 col-sm-6">
                    <div class="product__item">
                        <div class="product__item__pic set-bg" data-setbg="">
                            
                        </div>
                        <div class="product__item__text">
                            <h6><a href="#"></a></h6>
                            <h5></h5>
                        </div>
                    </div>
                </div>  
            </c:forEach>    
            </div>
        </div>
    </section>
    <!-- Related Product Section End -->
    <content tag = "script">
<<<<<<< HEAD
     	<script>
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
     	</script>
     </content>
=======
    	<script>
    	
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
    	</script>
    </content>
>>>>>>> 81f8941 (PBL3-8: Cart)
</body>

</html>