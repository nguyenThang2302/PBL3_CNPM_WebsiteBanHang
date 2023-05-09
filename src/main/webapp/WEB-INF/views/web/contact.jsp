<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
    <!-- data-setbg="<c:url value='/template/web/img/posterposter.jpg'/>" -->
    <section class="breadcrumb-section set-bg" data-setbg="">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Liên hệ với chúng tôi</h2>
                        <div class="breadcrumb__option">
                            <a href="/spring-mvc/trang-chu">Trang chủ</a>
                            <span>Contact Us</span>Contact Us
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Contact Section Begin -->
    <section class="contact spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_phone"></span>
                        <h4>Phone</h4>
                        <p>+84 363442302</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_pin_alt"></span>
                        <h4>Address</h4>
                        <p>54 Nguyễn Lương Bằng, Hoà Khánh Bắc, Liên Chiểu, Đà Nẵng</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_clock_alt"></span>
                        <h4>Open time</h4>
                        <p>10:00 am to 23:00 pm</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                    <div class="contact__widget">
                        <span class="icon_mail_alt"></span>
                        <h4>Email</h4>
                        <p>pbl3_cnpm@gmail.com</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Contact Section End -->

    <!-- Map Begin -->
    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15335.34976568415!2d108.1498921!3d16.0739232!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314218d68dff9545%3A0x714561e9f3a7292c!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBCw6FjaCBLaG9hIC0gxJDhuqFpIGjhu41jIMSQw6AgTuG6tW5n!5e0!3m2!1svi!2s!4v1676794827638!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        <div class="map-inside">
            <i class="icon_pin"></i>
            <div class="inside-widget">
                <h4>Việt Nam</h4>
                <ul>
                    <li>Phone: +84 363442302</li>
                    <li>Add: 54 Nguyễn Lương Bằng, Hoà Khánh Bắc, Liên Chiểu, Đà Nẵng</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Map End -->

    <!-- Contact Form Begin -->
    <div class="contact-form spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="contact__form__title">
                        <h2>Để lại tin nhắn</h2>
                    </div>
                </div>
            </div>
            <form action="#">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <input type="text" placeholder="Tên của bạn">
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <input type="text" placeholder="Email của bạn">
                    </div>
                    <div class="col-lg-12 text-center">
                        <textarea placeholder="Lời nhắn của bạn"></textarea>
                        <button type="submit" class="site-btn">GỬI TIN NHẮN</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- Contact Form End -->
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