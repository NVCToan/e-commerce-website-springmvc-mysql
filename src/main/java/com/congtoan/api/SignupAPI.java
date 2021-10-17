package com.congtoan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congtoan.entity.NhanVien;
import com.congtoan.serviceimp.NhanVienServiceImp;

@Controller
@RequestMapping("api/")
public class SignupAPI {
	@Autowired
	NhanVienServiceImp nhanvienService;
	
	@PostMapping("signup/")
	@ResponseBody
	public String signupHandle(@RequestParam String email, @RequestParam String password, @RequestParam String passwordAgain, ModelMap modelMap) {
		if(isValidEmailAddress(email)) {
			if(nhanvienService.checkAccount(email)) {
				modelMap.addAttribute("signupError","Tai khoan da ton tai");
				return "" + modelMap.getAttribute("signupError");
			}else {
				if(password!="" && passwordAgain!="" && password.equals(passwordAgain)) {
					NhanVien nhanVien = new NhanVien();
					nhanVien.setTendangnhap(email);
					nhanVien.setEmail(email);
					nhanVien.setMatkhau(password);
					return "" + nhanvienService.addNhanVien(nhanVien);
				}else {
					modelMap.addAttribute("signupError","Xac nhan mat khau khong chinh xac");
					return "" + modelMap.getAttribute("signupError");
				}
			
			}
			
			
		}else {
			modelMap.addAttribute("signupError","Vui long nhap dung email");
			return "" + modelMap.getAttribute("signupError");
		}
		
	}
	
	
	   public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
}
