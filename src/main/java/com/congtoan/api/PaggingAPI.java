package com.congtoan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congtoan.entity.SanPham;
import com.congtoan.serviceimp.SanPhamServiceImp;

@Controller
@RequestMapping("/pagging/")
public class PaggingAPI {
	static String previousPage;
	@Autowired 
	SanPhamServiceImp sanPhamService;
	
	@PostMapping(produces = "text/plan; charset=utf-8")
	@ResponseBody
	public String Default(@RequestParam String pageCurrent) {
		
		if(!pageCurrent.equals("Previous") || !pageCurrent.equals("Next")) {
			previousPage = Integer.parseInt(pageCurrent)-1+"";
			int from = (Integer.parseInt(pageCurrent) - 1)*5;
			System.out.println("from: " + from);
			int to = from + 5;
			System.out.println("to: " + to);
			
			List<SanPham> danhSachSanPhamLimit = sanPhamService.getListProduceLimit(from, to);
			StringBuilder builder = new StringBuilder();
			for(SanPham sanpham : danhSachSanPhamLimit) {
				builder.append("<tr>");
				builder.append("<td>");
				builder.append("<div id=\"checkbox\">");
				builder.append("  <label><input style=\"cursor:pointer\" class=\"checkbox-produce\" value=\"" +  sanpham.getMasanpham()+  "\" type=\"checkbox\"></label>");
				builder.append("</div>");
				builder.append("</td>");
				builder.append("<td class=\"tensanpham\">" +sanpham.getTensanpham()+ "</td>");
				builder.append("<td class=\"giatien\">"+ sanpham.getGiatien()+  "</td>");
				builder.append("<td class=\"gianhcho\">" +  sanpham.getGianhcho() + "</td>");
				builder.append("<td class=\"edit\"><i style=\"cursor:pointer\" data-id=\"" + sanpham.getMasanpham() + " \" id=\"edit-produce\" class=\" fas fa-edit\"></i></td>");
				builder.append("</tr>");
			}
			return builder.toString();
		}else {
			return "";
		}
		
		
	}
}
