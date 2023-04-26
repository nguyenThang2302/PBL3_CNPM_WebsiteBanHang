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
	<title>Ogani | Sản phẩm yêu thích</title>

</head>

<body>
<style>
.table-cell {
        padding: 10px;
}
</style>
     <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Lịch sử đơn hàng</h2>
                        <div class="breadcrumb__option">
                            <a href="/spring-mvc/trang-chu">Trang chủ</a>
                            <span>Order History</span>
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
                                    <th class="shoping__product table-cell">Mã đơn hàng</th>
                                    <th class="table-cell">Tình trạng đơn hàng</th>
                                    <th class="table-cell">Số lượng</th>
						            <th class="table-cell">Tổng tiền đơn hàng</th>
						            <th class="table-cell">Thời gian tạo đơn hàng</th>
						            <th class="table-cell">Chi tiết đơn hàng</th>
						            <th class="table-cell"></th>
                                </tr>
                            </thead>
                            <tbody>
                             <c:forEach var = "item" items = "${orders}">
                             <tr>
				                <td class="shoping__cart__item table-cell">${item.code}</td>
				                <td class="status_order">${item.status}</td>
				                <td class="shoping__cart__price table-cell">${item.quantity}</td>
				                <td class="count_favourite table-cell">${item.total_price}đ</td>
				                <td class="time-created table-cell">${item.created_at}</td>
				                <td class="detail-order table-cell"><a href="chi-tiet-don-hang/${item.code}">Chi tiết >></a></td>
				                <td class="table-cell"></td>
				            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shoping Cart Section End -->
    <content tag = "script">
    	<script>
    	
    	</script>
    </content>

</body>

</html>