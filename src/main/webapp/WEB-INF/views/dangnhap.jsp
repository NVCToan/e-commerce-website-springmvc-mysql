<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="../../resources/common/taglib.jsp" %>
<!doctype html>
<html lang="en">
  <head>
    <title>Title</title>
    <!-- Required meta tags -->


<link rel="stylesheet" href='<c:url value="/resources/css/style.css" />'>
<link rel="stylesheet" href='<c:url value="/resources/bootstrap4/css/bootstrap.min.css" />'>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

</head>
  <body>

    <div id="body-login">
        <div class="container-login">
            <div class="container-login-left">
                <div class="header-top header-left">
                    <h1>Welcome</h1>
                    <span>Hãy tạo nên phong cách của bạn cùng minishop</span>
                </div>
                <div class="content-bottom">
                    <p><img src='<c:url value="/resources/Image/icon_oval.png"/>' alt=""> Luôn cập nhật xu hướng thời trang mới nhất</p>
                    <p><img src='<c:url value="/resources/Image/icon_oval.png"/>' alt=""> Giảm hơn 50% tất cả các mặt hàng cho khách vip</p>
                    <p><img src='<c:url value="/resources/Image/icon_oval.png"/>' alt=""> Tận tình tư vấn để tạo nên phong cách cho bạn</p>
                </div>

            </div>
            <div class="container-login-right">
                <div class="header-top header-right">
                    <span class="actived btn-login">Đăng nhập</span> / <span class="btn-signup">Đăng ký</span>
                </div>
                <form action="" id="form-login" class="form-center" >
                    <input type="text" id="tendangnhap" name ="tendangnhap" placeholder="Email" class="email-icon" />
                    <input type="password" id="matkhau" name = "matkhau" placeholder="Mật khẩu" class="password-icon"/>
                   	<button type="submit" id="submit-login" class="btn btn-primary" style="margin-top:20px">Đăng nhập</button>
                <span style="color:red" class="login-status"> </span>
                </form>
                <form  id="form-signup" class="form-center hide" method="post" >
                    <input type="text" id = "email" name ="email" placeholder="Email" class="email-icon" />
                    <input type="password" id="password" name="password" placeholder="Mật khẩu" class="password-icon"/>
                    <input type="password" id="passwordAgain" name = "passwordAgain" placeholder="Nhập lại mật khẩu" class="password-icon"/>
                   	<button type="submit" id="submit-signup" class="btn btn-primary" style="margin-top:20px">Đăng ký</button>
                	<span id="signup-status" style="color:red"></span>
                </form>
                <div class="login-orther">
                    <img src='<c:url value="/resources/Image/icon_facebook.png"/>' alt="">
                    <img src='<c:url value="/resources/Image/icon_google.png"/>' alt="">
                </div>
            </div>
        </div>

      </div>
 <%--   <%@ include file="./footer.jsp" %> --%>


<script src='<c:url value="/resources/bootstrap4/js/jquery-3.6.0.min.js" />'></script>
<script src='<c:url value="/resources/bootstrap4/js/popper.min.js" />'></script>
<script src='<c:url value="/resources/bootstrap4/js/bootstrap.min.js" />'></script>
<script src='<c:url value="/resources/js/custom.js" />'></script>

  </body>
</html>