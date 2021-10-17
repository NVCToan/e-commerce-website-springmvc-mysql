<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../resources/common/taglib.jsp" %>
<!-- Start navbar -->
<nav class="navbar navbar-expand-lg navbar-light  bg-transparent">
    <a class="navbar-brand" href="#"><img src='<c:url value="/resources/Image/icon_yame_shop.png"/>' alt=""></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="/spring-mvc-checongbinh/">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="<c:url value='/dash-board/'/>">Dash Board</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Danh Mục
          </a>
          
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          	<c:forEach var="danhmuc" items="${danhMucSanPham}">
	          	<a style="color:gray" class="dropdown-item" href="/spring-mvc-checongbinh/sanpham/${danhmuc.getMadanhmuc()}/${danhmuc.getTendanhmuc()}/">${danhmuc.getTendanhmuc()}</a>
	            <div class="dropdown-divider"></div>
          	</c:forEach>
            
          
          </div>
        
        </li>
        <li>
      	 <a class= "nav-link" href='/spring-mvc-checongbinh/dangnhap/'> Dang nhap</a>
        </li>
      </ul>
      <!-- <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form> -->
      <div id="giohang" class="my-2 my-lg-0 ">
      <a href="/spring-mvc-checongbinh/giohang/"><i class="fas fa-shopping-cart" style="font-size: 20px; color:white"></i></a>
         
         
         <c:if test="${gioHang.size()<=0 || gioHang.size() == null}">
         <div><span></span></div>
         </c:if>
    	
         <c:if test="${gioHang.size()>0}">
         <div class="circle-giohang"><span>${gioHang.size()}</span></div>
         </c:if>
    	
      </div>
    </div>
  </nav>



<!-- End navbar -->