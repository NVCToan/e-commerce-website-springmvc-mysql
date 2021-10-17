<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../resources/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dash Board</title>
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
		<div class="row">
			<div class="col-xl-8 produce-table">
				<div class="chucnang" >
					<div class="btn-add btn btn-info">Thêm</div>
					<div class="btn-delete btn btn-danger">Xoá</div>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>
								<div  class="checkbox">
								  <label><input id="check-all" type="checkbox" value=""></label>
								</div>
							</th>
							<th>Tên sản phẩm</th>
							<th>Giá tiền</th>
							<th>Giành cho</th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tbody-produce">
						<c:forEach var="sanpham" items="${danhSachSanPham}">
							<tr>
								
								<td> 
									<div id="checkbox">
									  <label><input style="cursor:pointer" class="checkbox-produce" value="${sanpham.getMasanpham() }" type="checkbox"></label>
									</div>
								</td>
								<td class="tensanpham"> ${sanpham.getTensanpham() }</td>
								<td class="giatien"> ${sanpham.getGiatien() }</td>
								<td class="gianhcho"> ${sanpham.getGianhcho() }</td>
								<td class="edit"><i style="cursor:pointer" data-id="${sanpham.getMasanpham() }" id="edit-produce" class=" fas fa-edit"></i></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Previous">
				        <span class="">Previous</span>
				      </a>
				    </li>
				    <c:forEach var = "i" begin = "1" end = "${pageNumber}">
				    	<c:choose>
				         
				         <c:when test = "${i==1}">
 							<li class="page-item active"><a class="page-link" href="#">${i}</a></li>				         </c:when>
				         <c:otherwise>
				             <li class="page-item "><a class="page-link" href="#">${i}</a></li>
				         </c:otherwise>
				      </c:choose>
			        </c:forEach>
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next">
				        <span class="">Next</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>
				<div class="col-xl-4">
				<h2>Thêm sản phẩm</h2>
				<form id="thongTinSanPham" method="POST">
					<!-- text -->
					<div class="form-group">
					  <label>Tên sản phẩm:</label>
					  <input type="text" name="tenSanPham" class="form-control" id="tenSanPham">
					</div>
					<div class="form-group">
					  <label>Giá tiền</label>
					  <input type = "text" name="giaTien" class="form-control" id="giaTien">
					</div>
					<div class="form-group">
					<label for="phone-number">Danh mục</label>
					<br/>
					<select class="form-group"  name="danhmuc" id="danhmuc">
						<c:forEach var="danhMuc" items="${danhMucSanPham}">
						  <option value="${danhMuc.getMadanhmuc() }">${danhMuc.getTendanhmuc() }</option>
						</c:forEach>
					</select>
					</div>
					<!-- Mo ta -->
					<div class="form-group">
					  <label>Mô tả </label>
					  <textarea class="form-control" name="moTa" rows="5" id="mota"></textarea>
					</div>
						<!-- redio button -->
					<lable>Giành cho</lable>
					<br/>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" checked type="radio" name="gianhCho" id="rd_nam" value="nam">
					  <label class="form-check-label" for="inlineRadio1">Nam</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="gianhCho" id="rd_nu" value="nu">
					  <label class="form-check-label" for="inlineRadio2">Nữ</label>
					</div>
					<br/>
				</form>
				<h3 style="display: inline; margin-right:30px">Chi tiết sản phẩm</h3>
				<form id="containerChiTietSanPham" method="POST" >
					<div style="border-bottom: 1px solid black" data-test="test ne" class="chiTietSanPham">
						<!-- Mau -->
						  <div class="form-group">
						    <select class="form-control" name="mau" id="mau">
							    <c:forEach var="color" items="${colors}">
								  <option value="${color.getMamau() }">${color.getTenmau() }</option>
								</c:forEach>
						    </select>
						  </div>
						<!-- Size -->
						<div class="form-group">
						    <select class="form-control" name="size" id="size">
				    		    <c:forEach var="size" items="${sizes}">
								  <option value="${size.getMasize() }">${size.getSize() }</option>
								</c:forEach>
						    </select>
						  </div>
						<!-- So luong -->
						<input type="number" min="1" name="soLuong" placeholder="Số lượng"/>
						<!-- file upload -->
					  <div class="file-upload">
					    <div class="image-upload-wrap">
					      <input class="file-upload-input" name="hinhSanPham" type='file' accept="image/*" />
					      <div class="drag-text">
					        <h3>Drag and drop a file or select add Image</h3>
					      </div>
					    </div>
					    <div class="file-upload-content">
					      <img class="file-upload-image" src="#" alt="your image" />
					      <div class="image-title-wrap">
					        <button type="button" class="remove-image">Remove <span class="image-title">Uploaded Image</span></button>
					      </div>
					    </div>
					  </div>
						<!-- end file upload -->
					</div>
					
					
				</form>
				<i style="color:#0072ff; cursor:pointer" id="btn-themchitiet" class="fas fa-plus-circle"></i>
				<br/>
				<button type="submit" id="submitButton" class="btn btn-primary">Thêm sản phẩm</button>
				<button type="submit" id="updateButton" class="hidden btn btn-success">Cập nhật</button>
				<button type="submit" id="exitButton" class="hidden btn btn-danger">Thoát</button>
				<br/>
				<span style="color:green" id="statusSuccess"></span>
					<span style="color:red" id="statusError"></span>
				<!-- form an de them khi dung clone -->
				<div id="chiTietSanPham" style="border-bottom: 1px solid black" class="chiTietSanPham">
						<!-- Mau -->
						  <div class="form-group">
						    <select class="form-control" name="mau" id="mau">
							    <c:forEach var="color" items="${colors}">
								  <option value="${color.getMamau() }">${color.getTenmau() }</option>
								</c:forEach>
						    </select>
						  </div>
						<!-- Size -->
						<div class="form-group">
						    <select class="form-control" name="size" id="size">
				    		    <c:forEach var="size" items="${sizes}">
								  <option value="${size.getMasize() }">${size.getSize() }</option>
								</c:forEach>
						    </select>
						  </div>
						<!-- So luong -->
						
						<input type="number" min="1" name="soLuong" placeholder="Số lượng"/>
						
						  <div class="file-upload">
						    <div class="image-upload-wrap " >
						      <input class="file-upload-input" name="hinhSanPham" type='file' accept="image/*" />
						      <div class="drag-text">
						        <h3>Drag and drop a file or select add Image</h3>
						      </div>
						    </div>
						    <div class="file-upload-content">
						      <img class="file-upload-image" src="#" alt="your image" />
						      <div class="image-title-wrap">
						        <button type="button" class="remove-image">Remove <span class="image-title">Uploaded Image</span></button>
						      </div>
						    </div>
						  </div>
					</div>
				<br/>
				
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
 <script class="jsbin" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
 <script src='<c:url value="/resources/js/custom.js" />'></script>
</body>
</html>