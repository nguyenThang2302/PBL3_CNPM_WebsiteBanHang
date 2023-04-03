<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</style>
    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-5">
                    <div class="sidebar">
                        <div class="sidebar__item">
                            <h4>Giá</h4>
                            <div class="price-range-wrap">
                                <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                    data-min="10" data-max="540">
                                    <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                    <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                </div>
                                <div class="range-slider">
                                    <div class="price-input">
                                        <input type="text" id="minamount">
                                        <input type="text" id="maxamount">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="sidebar__item sidebar__item__color--option">
                            <h4>Màu sắc</h4>
                            <div class="sidebar__item__color sidebar__item__color--white">
                                <label for="white">
                                    Trắng
                                    <input type="radio" id="white">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--gray">
                                <label for="gray">
                                    Vàng
                                    <input type="radio" id="gray">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--red">
                                <label for="red">
                                    Đỏ
                                    <input type="radio" id="red">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--black">
                                <label for="black">
                                    Đen
                                    <input type="radio" id="black">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--blue">
                                <label for="blue">
                                    Xanh biển
                                    <input type="radio" id="blue">
                                </label>
                            </div>
                            <div class="sidebar__item__color sidebar__item__color--green">
                                <label for="green">
                                    Xanh lá
                                    <input type="radio" id="green">
                                </label>
                            </div>
                        </div>
                        <div class="sidebar__item">
                            <h4>Kích cỡ</h4>
                            <div class="sidebar__item__size">
                                <label for="large">
                                    Lớn
                                    <input type="radio" id="large">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="medium">
                                    Trung bình
                                    <input type="radio" id="medium">
                                </label>
                            </div>
                            <div class="sidebar__item__size">
                                <label for="small">
                                    Nhỏ
                                    <input type="radio" id="small">
                                </label>
                            </div>
                        </div>
                        <div class="sidebar__item">
                            <div class="latest-product__text">
                                <h4>Sản phẩm mới</h4>
                                <div class="latest-product__slider owl-carousel">
                                    <div class="latest-prdouct__slider__item">
                                    <c:forEach var = "item" items = "${products}">
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
                            <c:forEach var = "item" items = "${products}">
                            <div class="col-lg-4">
	                              <div class="featured__item">
			                        <div class="featured__item__pic set-bg" data-setbg="${item.image}">
			                            <ul class="featured__item__pic__hover">
			                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
			                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
			                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
                    <div class="row">
                    <c:forEach var="item" items = "${ products }">
             		<div class="col-lg-3 col-md-4 col-sm-6 mix oranges fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${item.image}">
	                            <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
	                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
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
</body>

</html>