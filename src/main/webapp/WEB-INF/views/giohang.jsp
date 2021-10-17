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
	<div class="container" >
		<div class="row" >
			<div id="buyer-info" class="col-xl-5">
				<h4>Thông tin người nhận/mua</h4>
				<form action="/spring-mvc-checongbinh/bill/" method="POST">
					<!-- text -->
					<div class="form-group">
					  <label for="user-name">Tên người nhận/mua:</label>
					  <input type="text" name="tenkhachhang" class="form-control" id="user-name">
					</div>
					<div class="form-group">
					  <label for="phone-number">Điện thoại liên lạc:</label>
					  <input type = "text" name="sodt" class="form-control" id="phone-number">
					</div>
					<!-- redio button -->
					<div class="radio">
					  <label><input type="radio" name="hinhthucgiaohang" value="Giao hàng tận nơi" checked>Giao hàng tận nơi</label>
					</div>
					<div class="radio">
					  <label><input type="radio" name="hinhthucgiaohang" value="Nhận hàng tại cửa hàng">Nhận hàng tại cửa hàng</label>
					</div>
					<!-- Dia chi -->
					<div class="form-group">
					  <label for=""address"">Địa chỉ nhận hàng</label>
					  <input type = "text" name="diachigiaohang" class="form-control" id="address">
					</div>
					<br/>
					<!-- Ghi chu -->
					<div class="form-group">
					  <label for="note">Ghi chú:</label>
					  <textarea class="form-control" name="ghichu" rows="5" id="note"></textarea>
					</div>
					<button type="submit" class="btn btn-block btn-primary">Đặt hàng</button>
				</form>
			</div>
			<div id="produce-info" class="col-xl-7">
				<table class="table">
					<thead>
						<tr>
							<td></td>
							<td>Tên sản phẩm</td>
							<td>Màu</td>
							<td>Size</td>
							<td>SL</td>
							<td>Giá tiền</td>
							<td></td>
						</tr>
					
					</thead>
					
					<tbody>
						<c:forEach var="sanpham" items="${gioHang}">
							<tr>
								<td><img id="produce-img" data-img="${sanpham.getAnhSanPham() }" style="width:100%" alt="" src='<c:url value="/resources/Image/sanpham/${sanpham.getAnhSanPham() }" />'></td>
								<td class="masanpham" data-masp="${sanpham.getMaSanPham()}">${sanpham.getTenSanPham() }</td>
								<td class="mausanpham" data-mamau="${sanpham.getMaMau() }"> ${sanpham.getTenMau() }</td>
								<td class="sizesanpham" data-masize="${sanpham.getMaSize() }" >${sanpham.getTenSize() }</td>
								<td ><input class="quantity"  type="number" value="${sanpham.getSoLuong()}" min="1"></td>
								<td class="price" data-price-default="${sanpham.getGiaTien()}">${sanpham.getGiaTien() }</td>
								<td><button class="btn btn-danger delete-produce-btn">X</button></td>
							</tr>
						</c:forEach>	
						
					</tbody>
				</table>
				<h3>Tổng tiền: <span style="color:red" id="sumPrice"></span></h3>
				
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