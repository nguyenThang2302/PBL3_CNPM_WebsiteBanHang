<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <!-- Favicons -->
  <link rel="stylesheet" href="<c:url value='assets/img/favicon.png'/>" type="text/css" rel="icon">
  <link rel="stylesheet" href="<c:url value='assets/img/apple-touch-icon.png'/>" type="text/css" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/bootstrap/css/bootstrap.min.css'/>" type="text/css">
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/bootstrap-icons/bootstrap-icons.css'/>" type="text/css">
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/boxicons/css/boxicons.min.css'/>" type="text/css">
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/quill/quill.snow.css'/>" type="text/css">
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/quill/quill.bubble.css'/>" type="text/css">
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/remixicon/remixicon.css'/>" type="text/css">
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/vendor/simple-datatables/style.css'/>" type="text/css">

  <!-- Template Main CSS File -->
  <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/style.css'/>" rel="stylesheet" type="text/css">

</head>
<body id="page-top">

  <dec:body/>
	
  <script src="<c:url value='/template/admin/assets/vendor/apexcharts/apexcharts.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/chart.js/chart.umd.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/echarts/echarts.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/quill/quill.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/simple-datatables/simple-datatables.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/tinymce/tinymce.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/vendor/php-email-form/validate.js'/>"></script>
  
  <dec:getProperty property="page.script"></dec:getProperty>
	
</body>
</html>