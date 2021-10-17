<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../resources/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/animate.min.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/bootstrap4/css/bootstrap.min.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/fontawesome/all.css" />'>
<!-- <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
 -->
</head>
<body>
<div class="container-fluid header-slider">
		<%@ include file="./header.jsp" %>
		<%@ include file="./slider.jsp" %>
</div>
		<h1>Spring Boot File Upload with jQuery Ajax</h1>
      <form method="POST" id="fileUploadForm">
         Description: <br/>
   		<input  class="soluong" type="text"/>
        <div class="chitiet">
            File to upload (1): <input class="inputCloneTest" type="file" name="files"/><br />
        
        </div>
        
       
         <input type="submit" value="Submit" id="submitButtonHome"/>
      </form>
           <div id="chitiet" class="chitiet">
                File to upload (1): <input class="inputCloneTest" type="file" name="files"/><br />
            
            </div>
         <button class="btn-clone">ButtonClone</button>   
      <h2>Upload Results:</h2>
      <div style="border:1px solid #ccc;padding: 5px;">
         <span id="result"></span>
      </div>
    <!-- Start body -->
      <!-- Info -->
      <div id ="info" class="container">
        <div class="row">
          <div class="col-md-4 col-xl-4 info-content" data-wow-duration="2s">
            <img class="icon" src='<c:url value="/resources/Image/icon_chatluong.png"/>' alt=""><br>
            <span style="font-size: 32px; font-weight: 500px;">Chất lượng</span><br>
            <span>Chúng tôi cam kết chất lượng sản phẩm tốt nhất</span>
          </div>
          <div class="col-md-4 col-xl-4 info-content">
            <img class="icon" src='<c:url value="/resources/Image/icon_giaohang.png"/>' alt=""><br>
            <span style="font-size: 32px; font-weight: 500px;">Giao hàng</span><br>
            <span>Chúng tôi cam kết giao hàng nhanh chóng và an toàn</span>
          </div>
          <div class="col-md-4 col-xl-4 info-content">
            <img class="icon" src='<c:url value="/resources/Image/icon_conheo.png"/>' alt=""><br>
            <span style="font-size: 32px; font-weight: 500px;">Tiết kiệm</span><br>
            <span>Chúng tôi cam kết giá cả hợp lý và luôn luôn rẻ</span>
          </div>

        </div>
        <!-- End info -->
        <!-- sanpham -->
        <h2 style="margin-top:100px">SẢN PHẨM HOT</h2>
        <div class="row">
        <c:forEach var= "sanpham" items="${danhSachSanPham}">
	       
	          <div class="col-xl-3 col-md-4 col-xs-6">
	            <a href="chitiet/${sanpham.getMasanpham()}" clas="">
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
    <!-- End body -->






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