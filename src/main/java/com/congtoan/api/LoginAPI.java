package com.congtoan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.congtoan.serviceimp.NhanVienServiceImp;

@Controller
@RequestMapping("api/")
@SessionAttributes("tendangnhap")
public class LoginAPI {
	@Autowired
	NhanVienServiceImp nhanvienService;
	
//	@GetMapping("login/")
//	@ResponseBody
//	public String Default() {
//		System.out.println("get api");
//		return "";
//	}
	@PostMapping("login/")
	@ResponseBody
	public String handleLogin(@RequestParam String tendangnhap, @RequestParam String matkhau,ModelMap modelMap) {
		boolean result = nhanvienService.getInfo(tendangnhap, matkhau);
		modelMap.addAttribute("tendangnhap",tendangnhap);
		return ""+result;
	}
}
