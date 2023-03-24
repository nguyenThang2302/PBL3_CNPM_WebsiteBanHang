<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>

<html lang="VI">

<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<style>

</style>

<body>

		<div class="modal-dialog">
			<div class="modal-content">
				<form method = "post" action = "create">
					<div class="modal-header">						
						<h4 class="modal-title">Thêm mã giảm giá</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
 					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input name="discount_name" type="text" class="form-control" required = "required"/>
						</div>
						<div class="form-group">
							<label>Code</label>
							<input name="discount_code" type="text" class="form-control" required = "required"/>
						</div>
						<div class="form-group">
							<label>Percent</label>
							<input name="discount_percent" type="text" class="form-control" required = "required"/>
						</div>	
						<div class="form-group">
							<label>Amount</label>
							<input name="amount" type="number" class="form-control" required="required"/>
						</div>	
						<div class="form-group">
							<label>Valid Date</label>
							<input name="valid_date" type="text" class="form-control" required = "required"/>
						</div>	
					</div>  
					<div class="modal-footer">
						<a href="product-management" type="button" class="btn btn-default" data-dismiss="modal">Cancel</a>
						<input type="submit" class="btn btn-success" value="Add">
					</div> 
				</form>
			</div>
		</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>    
</body>

</html>