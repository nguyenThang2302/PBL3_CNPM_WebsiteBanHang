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
	<title>Ogani | Thống kê đơn hàng</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.3/jspdf.umd.min.js"></script>
</head>

<body>
<style>
    body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

h1 {
  text-align: center;
}

.report-container {
  max-width: 800px;
  margin: 0 auto;
  border: 1px solid #ccc;
  padding: 20px;
  box-sizing: border-box;
}

.date-input {
  height: 35px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 5
}

.report-label, .report-value {
  display: block;
}

</style>
     <!-- Breadcrumb Section Begin -->
    <h1>Thống kê đơn hàng</h1>
    <form class="report-container" action="#">
      <div class="report-row">
        <div class="report-item">
          <span class="report-label">Tổng số đơn hàng đã đặt: <span id="total-orders" class="report-value" style="font-size: 16px;"></span></span>
        </div>
        <div class="report-item">
          <span class="report-label">Tổng tiền tất cả đơn hàng: <span id="total-amount" class="report-value" style="font-size: 16px;"></span></span>
        </div>
      </div>
      <div class="report-row">
        <div class="report-item">
          <span class="report-label">Tổng số lượng sản phẩm được bán: <span id="total-quantity" class="report-value" style="font-size: 16px;"></span></span>
        </div>
        <div class="report-item">
          <span class="report-label">Sản phẩm được bán nhiều nhất: <span id="most-sold-product" class="report-value" style="font-size: 16px;"></span></span>
        </div>
      </div>
      <div class="report-row">
        <div class="report-item">
          <span class="report-label">Từ ngày:</span>
          <input type="date" id="from-date" class="date-input" required="required">
        </div>
        <div class="report-item">
          <span class="report-label">Đến ngày:</span>
          <input type="date" id="to-date" class="date-input" required="required">
        </div>
        <div class="report-item">
		  <button type="submit" id="generate-report" class="generate-report-button">Thống kê</button>
        </div>
      </div>
    </form>
	<content tag = "script">
	<script>
	$(document).ready(function() {
		  $(".report-container").submit(function(event) {
		    event.preventDefault();
		    const fromDate = $('#from-date').val();
		    const toDate = $('#to-date').val();
		    var url = "thong-ke/" + fromDate + "/" + toDate;
		    $.ajax({
			      url: url,
			      type: 'GET',
			      success: function(response) {
			    	  $('#total-orders').html(response.total_bills);
			    	  $('#total-amount').html(response.total_price + '.0đ');
			    	  $('#total-quantity').html(response.total_quantity);
			    	  $('#most-sold-product').html(response.product_best_sale);
			      },
			      error: function(xhr) {
			        // Xử lý lỗi khi gửi yêu cầu Ajax.
			    	  Toastify({
							text: "Không có đơn hàng nào trong khoảng thời gian này!",
							duration: 3000,
							newWindow: true,
							close: true,
							gravity: "top",
							position: "center",
							backgroundColor: "linear-gradient(to right, #00b09b, #96c93d)",
						}).showToast();
			      }
			    });
		    });
		  });

	</script>
	</content>
</body>

</html>