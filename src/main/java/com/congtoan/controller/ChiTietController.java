package com.congtoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.congtoan.entity.SanPham;
import com.congtoan.serviceimp.SanPhamServiceImp;

@Controller
@RequestMapping("chitiet/")
@SessionAttributes("gioHang")
public class ChiTietController {
	@Autowired 
	SanPhamServiceImp sanphamService;
	
	@GetMapping("{masanpham}")
	public String chiTietSanPham(@PathVariable int masanpham, ModelMap modelMap) {
		SanPham sanphamChiTiet = sanphamService.getProduceDetail(masanpham);
		modelMap.addAttribute("sanphamChiTiet",sanphamChiTiet);
		return "chitiet";
		
	}
}
