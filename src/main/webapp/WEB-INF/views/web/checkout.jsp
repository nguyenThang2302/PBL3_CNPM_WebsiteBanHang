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
	<title>Ogani | Thanh toán</title>	
</head>

<body>
<style>
.checkout__order .checkout__order__total span {
    float: right;
    color: #1c1c1c;
}
</style>
	<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Thanh Toán</h2>
                        <div class="breadcrumb__option">
                            <a href="/spring-mvc/trang-chu">Trang Chủ</a>
                            <span>Checkout</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <h4>Chi tiết thanh toán</h4>
                <form action="thanh-toan" method="POST">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">
                        <input type="hidden" name = "user_code" value="${bills.user_code}">
                            <div class="checkout__input">
                                <p>Họ và tên<span>*</span></p>
                                <input type="text" name = "name" value="${bills.name}">
                            </div>
                            <div class="checkout__input">
                                <p>Địa chỉ<span>*</span></p>
                                <input type="text" class="checkout__input__add" name = "address" value = "${bills.address}">
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Số Điện Thoại<span>*</span></p>
                                        <input type="text" name = "phone" value = "${bills.phone}">
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p>Địa Chỉ Email<span>*</span></p>
                                        <input type="text" name = "email" value = "${bills.email}">
                                    </div>
                                </div>
                            </div>
                            <div class="checkout__input">
                                <p>Ghi chú đặt hàng<span>*</span></p>
                                <input type="text"
                                    placeholder="Ghi chú về đơn đặt hàng của bạn, ví dụ: ghi chú đặc biệt cho giao hàng." name = "note">
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="checkout__order">
                                <h4>Đơn Đặt Hàng Của Bạn</h4>
                                <div class="checkout__order__products">Sản Phẩm <span>Giá</span></div>
                                <ul>
	                                <c:forEach var = "item" items = "${Cart}">
	                                    <li>${ item.value.product.name.substring(0, 20) }... x${ item.value.quantity }<span>${ item.value.product.price }</span></li>
	                                </c:forEach>
                                </ul>
                                <div class="checkout__order__subtotal">Tạm tính <span>${TotalPrice}đ</span></div>
                                <div class="checkout__order__total" id = "total_discount">Giảm <span>${PercentDiscount * TotalPrice}đ</span></div>
                                <input type="hidden" name = "total_price" value="${TotalPrice - PercentDiscount * TotalPrice}">
                                <input type="hidden" name = "quantity" value="${TotalQuantity}">
                                <div class="checkout__order__total">Tổng Cộng <span>${TotalPrice - PercentDiscount * TotalPrice}đ</span></div>
                                <div class="checkout__input__checkbox">
                                    <label for="payment">
                                        Thanh toán khi nhận hàng
                                        <input type="checkbox" id="payment">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="checkout__input__checkbox">
                                    <label for="paypal">
                                        Thanh toán bằng VNPAY
                                        <input type="checkbox" id="paypal">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <button type="submit" class="site-btn">ĐẶT HÀNG</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->
</body>

</html>