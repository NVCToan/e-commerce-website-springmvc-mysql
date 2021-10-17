package com.congtoan.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.congtoan.entity.GioHang;

@Controller
@RequestMapping("api/")
@SessionAttributes("gioHang")
public class GioHangAPI {
	
	@GetMapping("themgiohang/")
	@ResponseBody
	public String themGioHang(@RequestParam String anhSanPham,@RequestParam int maSanPham,@RequestParam int maChiTietSanPham ,@RequestParam String tenSanPham,@RequestParam String giaTien, @RequestParam int maMau, @RequestParam String mau, @RequestParam int maSize, @RequestParam String size, @RequestParam int soLuong, HttpSession httpSession) {
		List<GioHang> gioHangs;
		
		if(httpSession.getAttribute("gioHang") == null) {
				gioHangs = new ArrayList<GioHang>();
				httpSession.setAttribute("gioHang", gioHangs);
				GioHang gioHang = new GioHang();
				gioHang.setAnhSanPham(anhSanPham);
				gioHang.setMaSanPham(maSanPham);
				gioHang.setMaChiTietSanPham(maChiTietSanPham);
				gioHang.setTenSanPham(tenSanPham);
				gioHang.setGiaTien(giaTien);
				gioHang.setMaMau(maMau);
				gioHang.setTenMau(mau);
				gioHang.setMaSize(maSize);
				gioHang.setTenSize(size);
				gioHang.setSoLuong(1);
				
				gioHangs.add(gioHang);
				
		}else  {
			gioHangs = (List<GioHang>) httpSession.getAttribute("gioHang");
			addNew(gioHangs,anhSanPham, maSanPham, maChiTietSanPham,tenSanPham, giaTien, maMau, mau, maSize, size, soLuong);
		}
		return gioHangs.size() +"";
		
	
		
		
	}
	
	@PostMapping("giohang/update/")
	@ResponseBody
	public void updateQuantity(@RequestParam int maSanPham,@RequestParam int maMau, @RequestParam int maSize,@RequestParam int soLuong,@RequestParam String action, HttpSession httpSession) {
		List<GioHang> gioHangs =  (List<GioHang>) httpSession.getAttribute("gioHang");
		int index = isExist(maSanPham, maMau, maSize, gioHangs);
	
		if(action.equals("delete")) {
			gioHangs.remove(index);
		}else {
			
			GioHang gioHang = gioHangs.get(index);
			gioHang.setSoLuong(soLuong);
		}
		
	}
	
	public boolean addNew(List<GioHang> gioHangs,String anhSanPham,int maSanPham,int maChiTietSanPham, String tenSanPham,String giaTien, int maMau, String mau, int maSize, String size, int soLuong) {
		int index = isExist(maSanPham, maMau, maSize, gioHangs);
		
		if(index != -1) {
			GioHang gioHang = gioHangs.get(index);
			gioHang.setSoLuong(gioHang.getSoLuong()+1);
			return true;
		}else {
			GioHang gioHang = new GioHang();
			gioHang.setAnhSanPham(anhSanPham);
			gioHang.setMaSanPham(maSanPham);
			gioHang.setMaChiTietSanPham(maChiTietSanPham);
			gioHang.setTenSanPham(tenSanPham);
			gioHang.setGiaTien(giaTien);
			gioHang.setMaMau(maMau);
			gioHang.setTenMau(mau);
			gioHang.setMaSize(maSize);
			gioHang.setTenSize(size);
			gioHang.setSoLuong(1);
			
			gioHangs.add(gioHang);
			return true;
		}
		
		
	}
	public int isExist(int maSanPham, int maMau, int maSize,List<GioHang> gioHangs) {
		for(int i = 0;i < gioHangs.size();i++) {
			if(gioHangs.get(i).getMaSanPham() == maSanPham && gioHangs.get(i).getMaMau() == maMau && gioHangs.get(i).getMaSize() == maSize) {
				return i;
			}
		}

		
		return -1;
		
		
		
	}
	
}
