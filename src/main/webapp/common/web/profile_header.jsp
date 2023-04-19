<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglib.jsp" %>

	<style>
		.header__top {
			background: #f5f5f5;
			height: 48px;
		}
	</style>
	
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="/spring-mvc/trang-chu"><img src="<c:url value='/template/web/img/logo.png'/>"alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="<c:url value='/template/web/img/vietnam.png'/>" alt="">
                <div>Tiếng Việt</div>
                <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Tiếng Anh</a></li>
                    <li><a href="#">Tiếng Việt</a></li>
                </ul>
            </div>
            <div class="header__top__right__social">
                <a href="/spring-mvc/dang-nhap"><i class="fa fa-user"></i>Đăng nhập</a>
            	<a href="/spring-mvc/dang-ky"><i class="fa fa-user"></i>Đăng ký</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <!-- <li class="active"><a href="./index.html">Trang chủ</a></li> -->
                <li class="active"><a href="/spring-mvc/trang-chu">Trang Chủ</a></li>
                <li><a href="/spring-mvc/shopping">Shopping</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="/spring-mvc/gio-hang">Giỏ Hàng</a></li>
                        <li><a href="/spring-mvc/thanh-toan">Thanh Toán</a></li>
                    </ul>
                </li>
                <li><a href="/spring-mvc/about-us">About</a></li>
                <li><a href="/spring-mvc/lien-he">Liên Hệ</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href ="https://www.facebook.com/bachkhoaDUT"><img src="<c:url value='/template/web/img/icon_fb.png'/>"alt=""></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i>pbl3_cnpm@gmail.com</li>
                <li>Miễn phí giao hàng cho</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i>pbl3_cnpm@gmail.com</li>
                				<li>Miễn phí giao hàng</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
            					<a href ="https://www.facebook.com/bachkhoaDUT"><img src="<c:url value='/template/web/img/icon_fb.png'/>"alt=""></a>
        					</div>
                            <div class="header__top__right__language">
                                <img src="<c:url value='/template/web/img/vietnam.png'/>" alt="">
                                <div>Tiếng Việt</div>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Tiếng Anh</a></li>
                    				<li><a href="#">Tiếng Việt</a></li>
                                </ul>
                            </div>
                            <c:if test = "${ empty LoginInfor }">
                             <div class="header__top__right__social">
                                <a href="/spring-mvc/dang-nhap"><i class="fas fa-sign-in-alt"></i>&nbsp;&nbsp;Đăng nhập</a>       	
                            </div>
                            <div class="header__top__right__auth">
                                <a href="/spring-mvc/dang-ky"><i class="fa fa-user"></i>&nbsp;Đăng ký</a>
                            </div>
                            </c:if>
                            <c:if test = "${ not empty LoginInfor }">
							<div class="header__top__right__language">
                                <i class="fas fa-user-circle">&nbsp;&nbsp;&nbsp;${ LoginInfor.name }</i>
                                <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="/spring-mvc/thong-tin-nguoi-dung">Tài khoản</a></li>
                    				<li><a href="/spring-mvc/dang-xuat">Đăng xuất</a></li>
                                </ul>
							</div>
<!-- 							<div class="header__top__right__auth">
								<a href="/spring-mvc/dang-xuat"><i class="fas fa-sign-out-alt"></i>&nbsp;&nbsp;Đăng Xuất</a>
							</div> -->
						</c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="/spring-mvc/trang-chu"><img src="<c:url value='/template/web/img/logo.png'/>" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="/spring-mvc/trang-chu">Trang Chủ</a></li>
                            <li><a href="/spring-mvc/shopping">Shopping</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="/spring-mvc/gio-hang">Giỏ Hàng</a></li>
                                    <li><a href="/spring-mvc/thanh-toan">Thanh Toán</a></li>
                                </ul>
                            </li>
                            <li><a href="/spring-mvc/about-us">About</a></li>
                            <li><a href="/spring-mvc/lien-he">Liên Hệ</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$150.00</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Danh mục sản phẩm</span>
                        </div>
                        <ul>
                        <c:forEach var = "item" items = "${departments}">
                            <li><a href="/spring-mvc/danh-muc-san-pham/${item.slug_name}">${item.name}</a></li>
                        </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    Tất cả sản phẩm
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="Tìm kiếm sản phẩm ...">
                                <button type="submit" class="site-btn">Tìm kiếm</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+84 363442302</h5>
                                <span>hỗ trợ mua hàng 24/7</span>
                            </div>
                        </div>
                    </div>
                    <%-- <div class="hero__item set-bg" data-setbg="<c:url value='/template/web/img/posterposter.jpg'/>">
                        <div class="hero__text">
                            <a href="/spring-mvc/trang-chu" class="primary-btn">SHOP NOW</a>
                        </div>
                    </div> --%>
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->
        <!-- Breadcrumb Section Begin -->
<%--     <section class="breadcrumb-section set-bg" data-setbg="<c:url value='resources/img/breadcrumb.jpg'/>">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>THÔNG TIN NGƯỜI DÙNG</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Profile</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End --> --%>