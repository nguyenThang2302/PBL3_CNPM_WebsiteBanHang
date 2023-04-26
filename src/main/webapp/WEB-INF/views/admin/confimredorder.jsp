<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<style>
    body {
        color: #566787;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
		font-size: 13px;
	}
	.table-responsive {
        margin: 30px 0;
    }
	.table-wrapper {
		min-width: 1000px;
        background: #fff;
        padding: 20px 25px;
		border-radius: 3px;
        box-shadow: 0 1px 1px rgba(0,0,0,.05);
    }
	.table-title {        
		padding-bottom: 15px;
		background: #435d7d;
		color: #fff;
		padding: 16px 30px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.table-title .btn-group {
		float: right;
	}
	.table-title .btn {
		color: #fff;
		float: right;
		font-size: 13px;
		border: none;
		min-width: 50px;
		border-radius: 2px;
		border: none;
		outline: none !important;
		margin-left: 10px;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 100px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
    table.table td:last-child i {
		opacity: 0.9;
		font-size: 22px;
        margin: 0 5px;
    }
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
		outline: none !important;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.edit {
        color: #FFC107;
    }
    table.table td a.delete {
        color: #F44336;
    }
    table.table td i {
        font-size: 19px;
    }
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
    .pagination {
        float: right;
        margin: 0 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 13px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a, .pagination li.active a.page-link {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    }    
	/* Custom checkbox */
	.custom-checkbox {
		position: relative;
	}
	.custom-checkbox input[type="checkbox"] {    
		opacity: 0;
		position: absolute;
		margin: 5px 0 0 3px;
		z-index: 9;
	}
	.custom-checkbox label:before{
		width: 18px;
		height: 18px;
	}
	.custom-checkbox label:before {
		content: '';
		margin-right: 10px;
		display: inline-block;
		vertical-align: text-top;
		background: white;
		border: 1px solid #bbb;
		border-radius: 2px;
		box-sizing: border-box;
		z-index: 2;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		content: '';
		position: absolute;
		left: 6px;
		top: 3px;
		width: 6px;
		height: 11px;
		border: solid #000;
		border-width: 0 3px 3px 0;
		transform: inherit;
		z-index: 3;
		transform: rotateZ(45deg);
	}
	.custom-checkbox input[type="checkbox"]:checked + label:before {
		border-color: #03A9F4;
		background: #03A9F4;
	}
	.custom-checkbox input[type="checkbox"]:checked + label:after {
		border-color: #fff;
	}
	.custom-checkbox input[type="checkbox"]:disabled + label:before {
		color: #b8b8b8;
		cursor: auto;
		box-shadow: none;
		background: #ddd;
	}
	/* Modal styles */
	.modal .modal-dialog {
		max-width: 400px;
	}
	.modal .modal-header, .modal .modal-body, .modal .modal-footer {
		padding: 20px 30px;
	}
	.modal .modal-content {
		border-radius: 3px;
	}
	.modal .modal-footer {
		background: #ecf0f1;
		border-radius: 0 0 3px 3px;
	}
    .modal .modal-title {
        display: inline-block;
    }
	.modal .form-control {
		border-radius: 2px;
		box-shadow: none;
		border-color: #dddddd;
	}
	.modal textarea.form-control {
		resize: vertical;
	}
	.modal .btn {
		border-radius: 2px;
		min-width: 100px;
	}	
	.modal form label {
		font-weight: normal;
	}
	form {
			display: flex;
			flex-direction: column;
			align-items: center;
		}

		label {
			font-weight: bold;
			margin-bottom: 10px;
		}

		input[type="text"] {
			padding: 10px;
			margin-bottom: 20px;
			border-radius: 5px;
			border: 1px solid #ccc;
			width: 300px;
		}

		input[type="submit"] {
			background-color: #4CAF50;
			color: white;
			padding: 10px 20px;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			font-size: 16px;
			margin-bottom: 20px;
		}	
</style>
<script>
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
<title>Trang chủ</title>

</head>

<body>
  <div class="container" style="margin-top:80px; margin-right:150px; font-size: 15px">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<img src="https://i.imgur.com/UjviLay.png"><a href ="/spring-mvc/quan-tri"> Trở Về</a></img>
							<h1>Đơn hàng đã xác nhận</h1>
						</div>
					</div>
					<form id = "search-form" action="tim-kiem-don-hang">
						<label for="code">Tìm kiếm đơn hàng:</label>
						<input type="text" id="order-id" name="code" placeholder="Mã đơn hàng...">
						<input type="submit" value="Tìm kiếm">
					</form>
				</div>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Mã đơn hàng</th>
							<th>Tình trạng đơn hàng</th>
							<th>Số lượng</th>
							<th>Tổng tiền đơn hàng</th>
							<th>Thời gian tạo đơn hàng</th>
							<th>Chi tiết đơn hàng</th>
						</tr>
					</thead>
					<tbody id = "bill_row">
						<c:forEach var="item" items="${confimred}">
						<tr>
							<td id = "td-code">${item.code}</td>
							<td id = "td-status">${item.status}</td>
							<td id = "td-quantity">${item.quantity}</td>
							<td id = "td-total_price">${item.total_price}</td>
							<td id = "td-creatd_at">${item.created_at}</td>
							<td><a href="/spring-mvc/chi-tiet-don-hang/${item.code}">Chi tiết >></a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>        
    </div>
    <content tag = "script">
    	<script>
    	$(document).ready(function() {
  		  $("#search-form").submit(function(event) {
  		    event.preventDefault();
  		    var code = $("#order-id").val();
  		    var url = "tim-kiem-don-hang/" + code;
  		    $.ajax({
  			      url: url,
  			      type: 'GET',
  			      success: function(response) {
  			    	  var jsonObj = JSON.parse(response);
  			    	  console.log(jsonObj.length);
  			    	  jsonObj.status = "Đã xác nhận";
  			    	  $("#bill_row").empty();
	  			    	    var item = jsonObj;
	  			    	    var row = "<tr>" +
	  			    	      "<td>" + item.code + "</td>" +
	  			    	      "<td>" + item.status + "</td>" +
	  			    	      "<td>" + item.quantity + "</td>" +
	  			    	      "<td>" + item.total_price + "</td>" +
	  			    	      "<td>" + item.created_at + "</td>" +
	  			    	      "<td><a href='/spring-mvc/chi-tiet-don-hang/" + item.code + "'>Chi tiết >></a></td>" +
	  			    	      "</tr>";
	  			    	    $("#bill_row").append(row);
  			      },
  			      error: function(xhr) {
  			        // Xử lý lỗi khi gửi yêu cầu Ajax.
  			        $("#bill_row").empty();
  			        var row = "<h3>Không tìm thấy mã đơn hàng!</h3>";
  			        $("#bill_row").append(row);
  			      }
  			    });
  		    });
  		  });
    	</script>
    </content>
</body>

</html>