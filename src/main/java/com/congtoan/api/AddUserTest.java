package com.congtoan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.congtoan.entity.UserTestPostMan;

@RestController
@RequestMapping("api/")
public class AddUserTest {
	
	
	@PostMapping("addUser/")
	public UserTestPostMan addUser(@RequestBody UserTestPostMan userJson) {
		
	
		System.out.println(userJson.toString());
		return userJson;
	}
}
