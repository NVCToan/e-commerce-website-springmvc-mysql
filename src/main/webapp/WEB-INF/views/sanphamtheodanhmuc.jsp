<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../resources/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh mục</title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/animate.min.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/bootstrap4/css/bootstrap.min.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/fontawesome/all.css" />'>
<!-- <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
 -->
</head>
<body>
	<div style="background-color:black !important">
	<%@ include file="./header.jsp" %>
	
	</div>
	
	<div class="container-fluid" style="margin-top:50px">
	
		<div class="row">
			<div class="col-xl-2">
				<h4>Danh mục</h4>
				<ul>
				<c:forEach var="danhmuc" items="${danhMucSanPham}">
				<li>
					<a style="color:gray" class="dropdown-item" href="/spring-mvc-checongbinh/sanpham/${danhmuc.getMadanhmuc()}/${danhmuc.getTendanhmuc()}/">${danhmuc.getTendanhmuc()}</a>
	           		 <div class="dropdown-divider"></div>
				</li>
	          
          		</c:forEach>
					
				</ul>
			</div>
			
			<div class="col-xl-10">
					  <!-- sanpham -->
				        <h2 style="margin-top:100px">${danhMucHienTai}</h2>
				        <div class="row">
				        <c:forEach var= "sanpham" items="${danhSachSanPhamTheoDanhMuc}">
					       
					          <div class="col-xl-3 col-md-4 col-xs-6">
					            <a href="chitiet/${sanpham.getMasanpham()}/" class="">
						            <div class="card card-produce">
						              <img class="card-img-top" src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}"/>' alt="Card image cap">
						              <div class="card-body">
						                <p class="produce-name">${sanpham.getTensanpham()}</p>
						                <p class="price">${sanpham.getGiatien()}</p>
						
						              </div>
						            </div>
						         </a>
					          </div>
				        
				        </c:forEach>
				        <!-- End san pham -->
			
				
			</div>
			
			<div class="col-xl-3">
			<h5>Mô tả sản phẩm</h5>
				${sanphamChiTiet.getMota()}
			</div>
		</div>
	
	</div>
	
	
	
	
	<%@ include file="./footer.jsp" %>
 <script src='<c:url value="/resources/wow.js" />'></script>
 <script>
 new WOW().init();
 </script>
<script src='<c:url value="/resources/bootstrap4/js/jquery-3.6.0.min.js" />'></script>
<script src='<c:url value="/resources/bootstrap4/js/popper.min.js" />'></script>
<script src='<c:url value="/resources/bootstrap4/js/bootstrap.min.js" />'></script>
<script src='<c:url value="/resources/js/custom.js" />'></script>
</body>
</html>