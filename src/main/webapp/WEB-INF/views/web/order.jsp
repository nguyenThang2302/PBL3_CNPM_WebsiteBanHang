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