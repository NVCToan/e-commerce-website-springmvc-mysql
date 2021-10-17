package com.congtoan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("giohang/")
@SessionAttributes("gioHang")
public class GioHangController {
	
	@GetMapping
	public String Default() {
		
		return "giohang";
	}
}
