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
	<title>Ogani | Chi tiết đơn hàng</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.3/jspdf.umd.min.js"></script>
</head>

<body>
<style>
    /* màu sắc */
    :root {
      --primary-color: #2980b9;
      --secondary-color: #f1c40f;
      --light-color: #f2f2f2;
      --dark-color: #333;
      --text-color: #555;
    }
    
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: var(--light-color);
    }
    
    .container {
      max-width: 800px;
      margin: 0 auto;
      border: 1px solid var(--primary-color);
      border-radius: 5px;
      padding: 20px;
      background-color: #fff;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }
    
    .header {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
      border-bottom: 1px solid var(--primary-color);
      padding-bottom: 20px;
    }
    
    .header h1 {
      margin: 0;
      font-size: 36px;
      color: var(--primary-color);
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
    }
    
    .customer-info {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
      padding: 20px;
      background-color: var(--light-color);
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }
    
    .customer-info div {
      flex-basis: 48%;
    }
    
    .customer-info p {
      margin: 0;
      margin-bottom: 10px;
      font-size: 16px;
      color: var(--text-color);
    }
    
    .customer-info p:first-child {
      font-weight: bold;
      font-size: 20px;
      color: var(--primary-color);
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
    }
    
    .table {
      border-collapse: collapse;
      width: 100%;
    }
    
    .table th,
    .table td {
      border: 1px solid var(--dark-color);
      padding: 8px;
      text-align: left;
    }
    
    .table th {
      background-color: var(--light-color);
      color: var(--text-color);
      font-size: 18px;
    }
    
    .table td {
      font-size: 16px;
      color: var(--text-color);
    }
    
    .total {
      display: flex;
      justify-content: flex-end;
      margin-top: 20px;
      font-size: 24px;
      font-weight: bold;
      color: var(--secondary-color);
      text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
    }
    
    /* hiệu ứng */
    /* hiệu ứng */
@keyframes fadeIn {
  0% {opacity: 0;}
  100% {opacity: 1;}
}

.container {
  animation: fadeIn 1s;
  margin-top: 100px;
}

@media print {
  body {
    background-color: #fff;
  }
  
  .customer-info {
    background-color: transparent;
    box-shadow: none;
    padding: 0;
  }
  
  .table th {
    background-color: transparent;
    color: var(--dark-color);
  }
  
  .total {
    font-size: 20px;
    color: var(--dark-color);
  }

}
</style>
     <!-- Breadcrumb Section Begin -->
    <div class="container">
    <img src="https://i.imgur.com/UjviLay.png"><a href ="/spring-mvc/don-hang"> Trở Về</a></img>
    <div class="header">
      <h1>Ogani Website</h1>
      <p>Mã đơn hàng: ${bills.code}</p>
    </div>
    <div class="customer-info">
      <div>
        <p>Khách hàng:</p>
        <p>Mã khách hàng: ${bills.user_code}</p>
        <p>Địa chỉ: ${bills.address}</p>
        <p>Điện thoại: ${bills.phone}</p>
        <p>Email: ${bills.email}</p>
      </div>
      <div>
        <p>Cửa hàng:</p>
        <p>Địa chỉ: 56 Nguyễn Lương Bằng, Quận Liên Chiểu, Thành Phố Đà Nẵng</p>
        <p>Điện thoại: 0363442302</p>
        <p>Email: pbl3_cnpm@gmail.com</p>
      </div>
    </div>
    
    <table class="table">
      <thead>
        <tr>
          <th>Sản phẩm</th>
          <th>Đơn giá</th>
          <th>Số lượng</th>
          <th>Thành tiền</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var = "item" items = "${billproduct}">
      	<tr>
          <td>${item.name}</td>
          <td>${item.price}đ</td>
          <td>${item.quantity}</td>
          <td>${item.total_price}đ</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    
    <div class="total">
      Tổng cộng: ${bills.total_price}đ
    </div>
  </div>
  <button id="print-btn" style="margin-left: 1250px; margin-top: 15px;">In hóa đơn</button>
    <!-- Shoping Cart Section End -->
    <content tag = "script">
    	<script>
	    	const printBtn = document.querySelector('#print-btn');
	    	printBtn.addEventListener('click', () => {
	    	  window.print();
	    	});
    	</script>
    </content>

</body>

</html>