package com.congtoan.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.congtoan.entity.NhanVien;
import com.congtoan.serviceimp.NhanVienServiceImp;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	NhanVienServiceImp nhanVienService;
	@GetMapping
	public String Default() {
		
		return "dangnhap";
	}
	
	@PostMapping
	public String handdleDangNhap(@RequestParam String tendangnhap, @RequestParam String matkhau) {
		boolean result = nhanVienService.getInfo(tendangnhap, matkhau);
//		if(nhanVien != null) {
//			System.out.println(nhanVien.getHoten() + " - " + nhanVien.getCmnd());
//		}
//		
		return "dangnhap";
	}
	
}
