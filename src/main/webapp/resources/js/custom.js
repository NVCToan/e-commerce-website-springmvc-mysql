
var maSanPham = 0;
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
$("body").on("click",".page-link",function(){
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
		
		}
	})
})

// Delete produce dashboard
// Check all
$("body").on('click',"#check-all",function(){
	console.log("co check all")
	 $('#checkbox input').prop('checked', this.checked);
})

$("body").on('click',".btn-delete",function(){
	var map = {}
	 $("#checkbox input:checked").each(function(){
		var value= parseInt($(this).val());
		Object.assign(map, {[value]:value});
    });
    console.log(map)
    $.ajax({
			url:"/spring-mvc-checongbinh/delete/",
			type:"POST",
			data:{
				ids:map
			},
		
			success:function(value){
				 $("#checkbox input:checked").each(function(){
					$(this).closest("tr").remove()
			    });
			}
		})
		//End ajax
})

function ajaxSubmitForm() {

 var tmp =  $('#containerChiTietSanPham').find(".chiTietSanPham input[type=file]");
	console.log("lenght: " + tmp.length);
	$.each(tmp, function(index, value){
		if(value.files && value.files[0])
		console.log(index ,value.files[0].name)
	});
    // Get form hinh anh chi tiet de gui qua server upload
  	var form = $('#containerChiTietSanPham')[0];
    var data = new FormData(form);
    
    // Get form thong tin chinh cua san pham
 	var formData = $('#thongTinSanPham').serializeArray();
 	
 	var json = {};
 	var arrayChiTiet =[];
 	
 	$.each(formData,function(index, value){
		json[value.name] = value.value;
	});
 	//Gan du lieu chi tiet
 	$("#containerChiTietSanPham > .chiTietSanPham").each(function(){
		var objectChiTiet ={}
		var mausanpham = $(this).find('select[name="mau"]').val()
		var sizesanpham = $(this).find('select[name="size"]').val()
		var soluong = $(this).find('input[name="soLuong"]').val()
		var hinhsanpham = $(this).find('input[name="hinhSanPham"]').val().split('\\').pop();;
		
		objectChiTiet["mausanpham"] = mausanpham; 
		objectChiTiet["sizesanpham"] = sizesanpham; 
		objectChiTiet["soluong"] = soluong; 
		objectChiTiet["hinhsanpham"] = hinhsanpham; 
		
		arrayChiTiet.push(objectChiTiet);
		
	})
	json["chitietsanpham"] = arrayChiTiet;
 	json = JSON.stringify(json);
 	console.log(json)

    $("#submitButton").prop("disabled", true);
     $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/spring-mvc-checongbinh/api/uploadfile/",
        data: data,
 
        // prevent jQuery from automatically transforming the data into a query string
        processData: false,
        contentType: false,
        cache: false,
        timeout: 1000000
        
        ,
        success: function(data, textStatus, jqXHR) {
 
            $("#result").html(data);
            console.log("SUCCESS : ", data);
            $("#submitButton").prop("disabled", false);
            $('#thongTinSanPham')[0].reset();
            $('#containerChiTietSanPham')[0].reset();
        },
        error: function(jqXHR, textStatus, errorThrown) {  
 
            $("#result").html(jqXHR.responseText);
            console.log("ERROR : ", jqXHR.responseText);
            $("#submitButton").prop("disabled", false);
 
        }
    });
    
 	$.ajax({
		type:"POST",
		url:"/spring-mvc-checongbinh/api/themsanpham/",
		data:{
			json:json
		}
});  
}
function ajaxUpdateForm() {

 	var tmp =  $('#containerChiTietSanPham').find(".chiTietSanPham input[type=file]");
    // Get form hinh anh chi tiet de gui qua server upload
  	var form = $('#containerChiTietSanPham')[0];
    var data = new FormData(form);
    
    // Get form thong tin chinh cua san pham
 	var formData = $('#thongTinSanPham').serializeArray();
 	
 	var json = {};
 	var arrayChiTiet =[];
 	
 	$.each(formData,function(index, value){
		json[value.name] = value.value;
	});
 	//Gan du lieu chi tiet
 	$("#containerChiTietSanPham > .chiTietSanPham").each(function(){
		var objectChiTiet ={}
		var mausanpham = $(this).find('select[name="mau"]').val()
		var sizesanpham = $(this).find('select[name="size"]').val()
		var soluong = $(this).find('input[name="soLuong"]').val()
		var hinhsanpham = $(this).find('input[name="hinhSanPham"]').val().split('\\').pop();;
		
		objectChiTiet["mausanpham"] = mausanpham; 
		objectChiTiet["sizesanpham"] = sizesanpham; 
		objectChiTiet["soluong"] = soluong; 
		objectChiTiet["hinhsanpham"] = hinhsanpham; 
		
		arrayChiTiet.push(objectChiTiet);
		
	})
	
	json["masanpham"] = maSanPham;
	json["chitietsanpham"] = arrayChiTiet;
 	json = JSON.stringify(json);
 	

    $("#submitButton").prop("disabled", true);
     $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/spring-mvc-checongbinh/api/uploadfile/",
        data: data,
 
        // prevent jQuery from automatically transforming the data into a query string
        processData: false,
        contentType: false,
        cache: false,
        timeout: 1000000,
        success:function(){
		$("#statusSuccess").text("Cập nhật thành công")
		}
        
       /* ,
        success: function(data, textStatus, jqXHR) {
 
            $("#result").html(data);
            console.log("SUCCESS : ", data);
            $("#submitButton").prop("disabled", false);
            $('#fileUploadForm')[0].reset();
        },
        error: function(jqXHR, textStatus, errorThrown) {  
 
            $("#result").html(jqXHR.responseText);
            console.log("ERROR : ", jqXHR.responseText);
            $("#submitButton").prop("disabled", false);
 
        }
        */
    });
    
 	$.ajax({
		type:"POST",
		url:"/spring-mvc-checongbinh/api/updatesanpham/",
		data:{
			json:json
		}
});  
}


//clone them chi tiet
$("body").on('click',"#btn-themchitiet",function(){
	var chitietclone = $("#chiTietSanPham").clone();
	chitietclone.removeAttr("id");
	
	$("#containerChiTietSanPham").append(chitietclone);
})


// file upload ui
$("body").on('change',".file-upload-input",function(){
    readURL(this);
})

$("body").on('click',".remove-image",function(){

    removeUpload(this);
})
function readURL(input) {
	
    var parent = $(input).closest(".file-upload");

    if (input.files && input.files[0]) {
        
      var reader = new FileReader();
  
      reader.onload = function(e) {
        parent.find(".image-upload-wrap").hide();
       // $('.image-upload-wrap').hide();
       parent.find(".file-upload-content .file-upload-image").attr('src', e.target.result);
       parent.find(".file-upload-content").show();
       parent.find(".file-upload-content .image-title").html(input.files[0].name);
      };
  
      reader.readAsDataURL(input.files[0]);
  
    } else {
      removeUpload(input);
    }
  }
  
  function removeUpload(input) {
    var parent = $(input).closest(".file-upload");
    parent.find('input[name="hinhSanPham"]').replaceWith($('#chiTietSanPham input[name="hinhSanPham"]').clone());
    parent.find('.file-upload-content').hide();
    parent.find('.image-upload-wrap').show();
  }
function handleDragOver(input) {
   
    $(input).addClass('image-dropping');
};
function hadleDragLeave(input) {
    $(input).removeClass('image-dropping');
};
$("#submitButton").click(function(event){
	event.preventDefault();
 
      		  // Call Ajax Submit.
 
	ajaxSubmitForm();
	
})
// Edit san pham
$("body").on('click',"#edit-produce",function(){
	$("#updateButton").removeClass("hidden")
	$("#exitButton").removeClass("hidden")
	$("#submitButton").addClass("hidden")
	maSanPham = $(this).attr("data-id");
	$.ajax({
		type:'POST',
		url:'/spring-mvc-checongbinh/api/update/',
		data:{
			maSanPham: maSanPham
		},
		success:function(sanphamJson){
			console.log(JSON.stringify(sanphamJson))
			$("#tenSanPham").val(sanphamJson.tensanpham)
			$("#giaTien").val(sanphamJson.giatien)
			$("#danhmuc").val(sanphamJson.danhmuc.madanhmuc);
			$("#mota").val(sanphamJson.mota)
			if(sanphamJson.gianhcho === "nam" || sanphamJson.gianhcho === "Nam" ){
				$("#rd_nam").prop("checked",true)
			}else if(sanphamJson.gianhcho === "nu" || sanphamJson.gianhcho === "Nữ" || sanphamJson.gianhcho === "nữ"){
				$("#rd_nu").prop("checked",true)
			}
			// Show chi tiet
				$("#containerChiTietSanPham .chiTietSanPham").remove()
			for( i=0; i< sanphamJson.chitietsanpham.length;i++){
				console.log("length chi tiet: " +  sanphamJson.chitietsanpham.length)
				var chitiet = sanphamJson.chitietsanpham[i];
				var chiTietClone = $("#chiTietSanPham").clone().removeAttr("id")
				chiTietClone.find('select[name="mau"]').val(chitiet.mausanpham.mamau);
				chiTietClone.find('select[name="size"]').val(chitiet.sizesanpham.masize)
				chiTietClone.find('input[name="soLuong"]').val(chitiet.soluong)
				
				$("#containerChiTietSanPham").append(chiTietClone);
			}
			
		}
		
		
	})	
	
})
$("#updateButton").click(function(){
	event.preventDefault();
	ajaxUpdateForm();
		
	
})
$("#exitButton").click(function(){
	$("#updateButton").addClass("hidden")
	$("#exitButton").addClass("hidden")
	$("#submitButton").removeClass("hidden")
})