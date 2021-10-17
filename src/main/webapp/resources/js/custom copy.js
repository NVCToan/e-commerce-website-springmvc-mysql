
$(document).ready(function () {
$("#submit-login").click(function(e){
	e.preventDefault();
	var tendangnhap = $("#tendangnhap").val();
	var matkhau = $("#matkhau").val();
	$.ajax({
		url: "/spring-mvc-checongbinh/api/login/",
		type:'POST',
		data:{
			tendangnhap:tendangnhap,
			matkhau:matkhau
		},
		success:function(value){
			if(value == "true"){
				window.location.replace("/spring-mvc-checongbinh/");
				
			}else{
				$(".login-status").text("Dang nhap that bai!")
			}
		}		
	})
});
$("#submit-signup").click(function(e){
		e.preventDefault();
		var email = $("#email").val();
		var password = $("#password").val();
		var passwordAgain = $("#passwordAgain").val();
		
		$.ajax({
			url :"/spring-mvc-checongbinh/api/signup/",
			type:'POST',
			data:{
				email:email,
				password: password,
				passwordAgain: passwordAgain
			},
			success:function(value){
				if(value=="true"){
					window.location.replace("/spring-mvc-checongbinh/dangnhap/");
				}else{
					$("#signup-status").text(value);
				}
			}
			
		})	
	
});
$(".btn-themGioHang").click(function(e){
	e.preventDefault();
	var maSanPham = $("#tenSanPham").attr("data-masp");
	var maChiTietSanPham = $(this).attr("data-machitiet");
	var tenSanPham = $("#tenSanPham").text();
	var giaTien = $("#giaTien").text();
	var maMau = $(this).closest("tr").find(".mau").attr("data-mamau");
	var mau = $(this).closest("tr").find(".mau").text();
	var maSize = $(this).closest("tr").find(".size").attr("data-size");
	var size = $(this).closest("tr").find(".size").text();
	var soLuong = $(this).closest("tr").find(".soLuong").text();
	var anhSanPham = $("#produce-img").attr("data-img")
	$.ajax({
		url:"/spring-mvc-checongbinh/api/themgiohang/",
		type:'GET',
		data:{
			maSanPham: maSanPham,
			maChiTietSanPham:maChiTietSanPham,
			tenSanPham:tenSanPham,
			giaTien: giaTien,
			maMau: maMau,
			mau: mau,
			maSize: maSize,
			size: size,
			soLuong: soLuong,
			anhSanPham: anhSanPham
			
		},success:function(value){
			
			$("#giohang").find("div").addClass("circle-giohang");
			$("#giohang").find("div").html("<span>" + value + "</span>");
		}
		
	})	

})

//Change form login-signup
$(".btn-login").click(function(){
	$(this).addClass("actived")
	$(".btn-signup").removeClass("actived")
	$("#form-login").show();
	$("#form-signup").addClass("hide");
});

$(".btn-signup").click(function(){
	$(this).addClass("actived")
	$(".btn-login").removeClass("actived")
	$("#form-login").hide();
	$("#form-signup").removeClass("hide");
});
//End change form login-signup

//Cap nhat gia khi vao gio hang
$(".quantity").each(function() {
 	var quantity = $(this).val();
	
	$(this).closest("tr").find(".price").each(function(){
    var pricePerProduce = parseFloat($(this).closest("tr").find(".price").attr("data-price-default"));
	var newPrice = pricePerProduce*quantity;
	newPrice  = newPrice.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
	$(this).closest("tr").find(".price").text(newPrice);
	$("#sumPrice").text(getSumPrice());
	})
});



// Cap nhat gia khi tang giam so luong
$(".quantity").change(function(){
	var quantity = $(this).val();
	var pricePerProduce = parseFloat($(this).closest("tr").find(".price").attr("data-price-default"));
	
	var priceShow = $(this).closest("tr").find(".price").text();
	var newPrice = pricePerProduce*quantity;
	newPrice  = newPrice.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
	//Cap nhat gia tuong ung voi so luong san pham
	$(this).closest("tr").find(".price").text(newPrice);
	//Tinh tong gia tat ca san pham
	$("#sumPrice").text(getSumPrice());
	
	//Cap nhat session gioHang
	var maSanPham = parseInt($(this).closest("tr").find(".masanpham").attr("data-masp"));
	var maMau = parseInt($(this).closest("tr").find(".mausanpham").attr("data-mamau"));
	var maSize = parseInt($(this).closest("tr").find(".sizesanpham").attr("data-masize"));
	
	$.ajax({
		
		url:"/spring-mvc-checongbinh/api/giohang/update/",
		type:"POST",
		data:{
			maSanPham: maSanPham,
			maMau: maMau,
			maSize: maSize,
			soLuong: parseInt(quantity),
			action:"update"
		}
	})
	
		
});

function getSumPrice(){
	var sum = 0;
	var all = $(".price").map(function() {
   	 	return this.innerHTML;
		}).get();
		
	for(i=0;i<all.length;i++){
		var tmp = all[i].replaceAll(".","");
		sum = parseFloat(sum) + parseFloat(tmp)
		}
		
	return (sum/1000).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString();
}

// Xoa san pham khoi gio hang
$(".delete-produce-btn").click(function(){
	var maSanPham = parseInt($(this).closest("tr").find(".masanpham").attr("data-masp"));
	var maMau = parseInt($(this).closest("tr").find(".mausanpham").attr("data-mamau"));
	var maSize = parseInt($(this).closest("tr").find(".sizesanpham").attr("data-masize"));
	var seft = $(this);
	$.ajax({
		
		url:"/spring-mvc-checongbinh/api/giohang/update/",
		type:"POST",
		data:{
			maSanPham: maSanPham,
			maMau: maMau,
			maSize: maSize,
			soLuong:0,
			action:"delete"
		},
		success:function(value){
			seft.closest("tr").remove("");
			$("#sumPrice").text(getSumPrice());
		}
	})
	
	
	
	
	
});

// pagging
$(".page-link").click(function(){
	$(".page-item").removeClass("active")
	$(this).closest(".page-item").addClass("active")
	var pageCurrent = $(this).text()
	pageCurrent = pageCurrent.trim()
	

$.ajax({
		url:"/spring-mvc-checongbinh/pagging/",
		type:"POST",
		data:{
			pageCurrent:pageCurrent
		},
		success:function(value){
			var tableBody = $("#tbody-produce")
			tableBody.empty();
			tableBody.append(value);
			console.log(value)
			console.log("-------------------")

		}
	})


})

// Delete produce dashboard
// Check all

 $("#check-all").click(function(){
    $('#checkbox input').prop('checked', this.checked);
});

$(".btn-delete").click(function(){
	var map = {}
	 $("#checkbox input:checked").each(function(){
		var value= parseInt($(this).val());
		Object.assign(map, {[value]:value});
    });
    $.ajax({
			url:"/spring-mvc-checongbinh/delete/",
			type:"POST",
			data:{
				ids:map
			},
		
			success:function(value){
				
			}
		})
		//End ajax
	
    
});
    //upload file
     $("#submitButton").click(function(event) {
 
        // Stop default form Submit.
        event.preventDefault();
 
        // Call Ajax Submit.
 
      	 var form = $('#fileUploadForm')[0];
 
   		 var data = new FormData(form);
        $.ajax({
            type:'POST',
			 enctype: 'multipart/form-data',
            url:'http://localhost:8080/spring-mvc-checongbinh/api/uploadfile/',
            data:data,
           	 contentType: false,
       		 processData: false,
       		 cache:false,
            success:function(value){

            }

        })
 
    });
    $(".anhSanPham").change(function(event){
		
    })
 

})
//End
