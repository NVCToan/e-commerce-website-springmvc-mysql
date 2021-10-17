package com.congtoan.api;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.congtoan.UploadForm;
import com.congtoan.entity.ChiTietSanPham;
import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.MauSanPham;
import com.congtoan.entity.SanPham;
import com.congtoan.entity.SizeSanPham;
import com.congtoan.serviceimp.SanPhamServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Component
@RequestMapping("/api/")
public class UpLoadSanPhamVaHinhAnh {
	@Autowired
	ServletContext context;
	@Autowired
	SanPhamServiceImp sanphamService;
	
	@PostMapping("uploadfile/")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) {
//		// Lay r ds ten file
			MultiValueMap<String, MultipartFile>  form = request.getMultiFileMap();
			
			List<MultipartFile> files = form.get("hinhSanPham");
			String pathSaveFile = "";
			for(MultipartFile mpf : files) {
				if( mpf.getOriginalFilename().equals("")) {
					continue;
				}
//			B1: lay ra duong dan se luu file
				pathSaveFile = context.getRealPath("/resources/Image/sanpham/" );
//			B2: Tao file
				File file = new File(pathSaveFile + mpf.getOriginalFilename());
//			B3: dung ham trong thu vien commmon de save
				try {
					mpf.transferTo(file);
				} catch (IOException e) {
					System.err.println(e.getStackTrace());
				}
				
			}
			
			System.out.println(pathSaveFile);
			return "upload thanh cong";
	}
	
	
	@PostMapping("themsanpham/")
	@ResponseBody
	public String themSanPham(@RequestParam String json) {
		JsonMapper jsonMapper = new JsonMapper();
		JsonNode jsonObjectSanPham;
		try {
			jsonObjectSanPham = jsonMapper.readTree(json);
			// Mot mang chi tiet san pham
			JsonNode arrayChiTiet = jsonObjectSanPham.get("chitietsanpham");
			SanPham sanpham = new SanPham();
			Set<ChiTietSanPham> danhSachChiTiet = new HashSet<ChiTietSanPham>();
			
			DanhMucSanPham danhmuc = new DanhMucSanPham();
			danhmuc.setMadanhmuc(jsonObjectSanPham.get("danhmuc").asInt());
			
			sanpham.setTensanpham(jsonObjectSanPham.get("tenSanPham").asText());
			sanpham.setGiatien(jsonObjectSanPham.get("giaTien").asText());
			sanpham.setDanmuc(danhmuc);
			sanpham.setMota(jsonObjectSanPham.get("moTa").asText());
			sanpham.setGianhcho(jsonObjectSanPham.get("gianhCho").asText());
			sanpham.setHinhsanpham(arrayChiTiet.get(0).get("hinhsanpham").asText());
			
			System.out.println(jsonObjectSanPham);
			for(JsonNode objectChiTiet : arrayChiTiet ) {
				ChiTietSanPham chitiet = new ChiTietSanPham();
				MauSanPham mausanpham = new MauSanPham();
				SizeSanPham sizeSanPham = new SizeSanPham();
				mausanpham.setMamau(objectChiTiet.get("mausanpham").asInt());
				sizeSanPham.setMasize(objectChiTiet.get("sizesanpham").asInt());
				chitiet.setMausanpham(mausanpham);
				chitiet.setSizesanpham(sizeSanPham);
				chitiet.setSoluong(objectChiTiet.get("soluong").asInt());
				chitiet.setSanpham(sanpham);
				danhSachChiTiet.add(chitiet);
			}
			sanpham.setChitietsanpham(danhSachChiTiet);
			sanphamService.themSanPham(sanpham);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return"";
		
		
		
	}
	@PostMapping("updatesanpham/")
	@ResponseBody
	public String updateSanPham(@RequestParam String json) {
		JsonMapper jsonMapper = new JsonMapper();
		JsonNode jsonObjectSanPham;
		try {
			jsonObjectSanPham = jsonMapper.readTree(json);
			// Mot mang chi tiet san pham
			JsonNode arrayChiTiet = jsonObjectSanPham.get("chitietsanpham");
			SanPham sanpham = new SanPham();
			Set<ChiTietSanPham> danhSachChiTiet = new HashSet<ChiTietSanPham>();
			
			DanhMucSanPham danhmuc = new DanhMucSanPham();
			danhmuc.setMadanhmuc(jsonObjectSanPham.get("danhmuc").asInt());
			
			sanpham.setTensanpham(jsonObjectSanPham.get("tenSanPham").asText());
			sanpham.setGiatien(jsonObjectSanPham.get("giaTien").asText());
			sanpham.setDanmuc(danhmuc);
			sanpham.setMota(jsonObjectSanPham.get("moTa").asText());
			sanpham.setGianhcho(jsonObjectSanPham.get("gianhCho").asText());
//			sanpham.setHinhsanpham(arrayChiTiet.get(0).get("hinhsanpham").asText());
			
			System.out.println(jsonObjectSanPham);
			for(JsonNode objectChiTiet : arrayChiTiet ) {
				ChiTietSanPham chitiet = new ChiTietSanPham();
				MauSanPham mausanpham = new MauSanPham();
				SizeSanPham sizeSanPham = new SizeSanPham();
				mausanpham.setMamau(objectChiTiet.get("mausanpham").asInt());
				sizeSanPham.setMasize(objectChiTiet.get("sizesanpham").asInt());
				chitiet.setMausanpham(mausanpham);
				chitiet.setSizesanpham(sizeSanPham);
				chitiet.setSoluong(objectChiTiet.get("soluong").asInt());
				chitiet.setSanpham(sanpham);
				danhSachChiTiet.add(chitiet);
			}
			sanpham.setMasanpham(jsonObjectSanPham.get("masanpham").asInt());
			sanpham.setChitietsanpham(danhSachChiTiet);
			sanphamService.updateSanPham(sanpham);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return"";
		
		
		
	}
}