package com.congtoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.SanPham;
import com.congtoan.serviceimp.DanhMucServiceImp;
import com.congtoan.serviceimp.SanPhamServiceImp;

@Controller
@SessionAttributes({"tendangnhap","danhMucSanPham"})
public class HomeController {
	@Autowired
	SanPhamServiceImp sanPhamService;
	
	@Autowired
	DanhMucServiceImp danhMucService;
	
	@GetMapping("/")
	public String Default(ModelMap modelMap) {
		List<SanPham> danhSachSanPham =  sanPhamService.getListProduce(0);
		List<DanhMucSanPham> danhMucSanPham = danhMucService.getAll();
		
		modelMap.addAttribute("danhSachSanPham", danhSachSanPham);
		modelMap.addAttribute("danhMucSanPham", danhMucSanPham);
		return "home";
	}
}
