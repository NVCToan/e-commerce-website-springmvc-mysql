<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../resources/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiet</title>
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
					<li>Quan kaki</li>
					<li>Quan kaki</li>
					<li>Quan kaki</li>
					<li>Quan kaki</li>
					<li>Quan kaki</li>
				</ul>
			</div>
			
			<div class="col-xl-7">
				<div class="row">
					<div class="col-xl-4">
						<img id="produce-img" data-img="${sanphamChiTiet.getHinhsanpham() }" style="width:100%" alt="" src='<c:url value="/resources/Image/sanpham/${sanphamChiTiet.getHinhsanpham() }" />'>
					</div>
					<div class="col-xl-8">
						<h4 id="tenSanPham" data-masp = "${sanphamChiTiet.getMasanpham() }">${sanphamChiTiet.getTensanpham() }</h4>
						<div id="giaTien" style="color:red">${sanphamChiTiet.getGiatien() }</div>
						<table class="table">
							<thead>
								<tr>
									<td>Màu sản phẩm</td>
									<td>Size</td>
									<td>Số lượng</td>
								
								</tr>
							</thead>
							<tbody>
								<c:forEach var="chiTietSanPham" items="${sanphamChiTiet.getChitietsanpham()}">
										<tr>
											<td class="mau" data-mamau="${chiTietSanPham.getMausanpham().getMamau()}" > ${chiTietSanPham.getMausanpham().getTenmau() }</td>
											<td class="size" data-size="${chiTietSanPham.getSizesanpham().getMasize() }">${chiTietSanPham.getSizesanpham().getSize() }</td>
											<td class="soLuong" >${chiTietSanPham.getSoluong() }</td>
											<td style="color:red"><button data-machitiet="${chiTietSanPham.getMachitietsanpham() }" class="btn btn-seccondary btn-themGioHang"><i class="fas fa-cart-plus" style="font-size: 20px; color:#f17d3a"></i></button></td>
											
										</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
				
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