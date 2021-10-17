package com.congtoan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.MauSanPham;
import com.congtoan.entity.SanPham;
import com.congtoan.entity.SizeSanPham;
import com.congtoan.serviceimp.DanhMucServiceImp;
import com.congtoan.serviceimp.MauServiceImp;
import com.congtoan.serviceimp.SanPhamServiceImp;
import com.congtoan.serviceimp.SizeServiceImp;

@Controller
@RequestMapping("dash-board/")
public class DashBoardController {
	
	@Autowired
	SanPhamServiceImp sanPhamService;
	
	@Autowired
	SizeServiceImp sizeService;
	
	@Autowired
	DanhMucServiceImp danhMucService;
	
	@Autowired
	MauServiceImp mauService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		Long countProduce = sanPhamService.countProduce();
		System.out.println(countProduce);
		double pageNumber = Math.ceil((double)countProduce/5);
		System.out.println(pageNumber);
		List<SanPham> danhSachSanPham = sanPhamService.getListProduceLimit(0, 5);
		List<SizeSanPham> sizes = sizeService.getSizes();
		List<DanhMucSanPham> danhMucSanPham = danhMucService.getAll();
		List<MauSanPham> colors = mauService.getColors();
		
		modelMap.addAttribute("danhSachSanPham",danhSachSanPham);
		modelMap.addAttribute("pageNumber",pageNumber);
		modelMap.addAttribute("sizes",sizes);
		modelMap.addAttribute("danhMucSanPham", danhMucSanPham);
		modelMap.addAttribute("colors", colors);
		
		
		return "dashboard";
	}
}
