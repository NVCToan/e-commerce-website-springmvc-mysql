package com.congtoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.congtoan.entity.SanPham;
import com.congtoan.serviceimp.DanhMucServiceImp;

@Controller
@RequestMapping("/sanpham/")
@SessionAttributes("danhMucSanPham")
public class DanhMucSanPhamController {
	@Autowired
	DanhMucServiceImp danhMucService;
	
	@GetMapping("{madanhmuc}/{tenDanhMuc}/")
	public String Default(@PathVariable int madanhmuc,@PathVariable String tenDanhMuc, ModelMap modelMap) {
		List<SanPham> danhSachSanPhamTheoDanhMuc = danhMucService.getAllProduce(madanhmuc);
		modelMap.addAttribute("danhSachSanPhamTheoDanhMuc", danhSachSanPhamTheoDanhMuc);
		modelMap.addAttribute("danhMucHienTai", tenDanhMuc);
		return "sanphamtheodanhmuc";
	}
}
