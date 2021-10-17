package com.congtoan.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.congtoan.entity.ChiTietHoaDon;
import com.congtoan.entity.GioHang;
import com.congtoan.entity.HoaDon;
import com.congtoan.serviceimp.HoaDonServiceImp;

@Controller
@RequestMapping("bill/")
@SessionAttributes("gioHang")
public class HoaDonController {
	@Autowired
	HoaDonServiceImp hoaDonService;
	@PostMapping
	public String addBill(WebRequest request, SessionStatus status,HttpSession httpSession,@RequestParam String tenkhachhang, @RequestParam String sodt, @RequestParam String diachigiaohang, @RequestParam String  hinhthucgiaohang, @RequestParam String ghichu ) {
		
		HoaDon hoadon = new HoaDon();
		hoadon.setTenkhachhang(tenkhachhang);
		hoadon.setSodt(sodt);
		hoadon.setHinhthucgiaohang(hinhthucgiaohang);
		hoadon.setDiachigiaohang(diachigiaohang);
		hoadon.setGhichu(ghichu);
		
		Set<ChiTietHoaDon> danhSachChiTietHoaDon = new HashSet<ChiTietHoaDon>();
		
		if(httpSession.getAttribute("gioHang")!=null) {
			for(GioHang gioHang : (List<GioHang>) httpSession.getAttribute("gioHang")) {
				ChiTietHoaDon chitiet = new ChiTietHoaDon();
				chitiet.setMachitietsanpham(gioHang.getMaChiTietSanPham());
				chitiet.setSoluong(gioHang.getSoLuong());
				chitiet.setGiatien(gioHang.getGiaTien());
				chitiet.setHoadon(hoadon);
				
				danhSachChiTietHoaDon.add(chitiet);
				
			}
			hoadon.setDanhSachChiTietHoaDon(danhSachChiTietHoaDon);
		}else {
			System.out.println("Gio hang khong ton tai");
		}
		
		boolean result = hoaDonService.addBill(hoadon);
		if(result  == true) {
			System.out.println("Them hoa don thanh cong");
			 status.setComplete();
			    request.removeAttribute("gioHang", WebRequest.SCOPE_SESSION);
		}else {
			System.out.println("Them that bai");
		}
		return "redirect:/";
	}
}
