package com.congtoan.api;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congtoan.entity.ChiTietSanPham;
import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.JsonSanPham;
import com.congtoan.entity.MauSanPham;
import com.congtoan.entity.SanPham;
import com.congtoan.entity.SizeSanPham;
import com.congtoan.serviceimp.SanPhamServiceImp;

@Controller
@RequestMapping("api/")
public class UpdateSanPham {
		@Autowired
		SanPhamServiceImp sanPhamService;
		
		@PostMapping(path="update/", produces = "application/json;  charset=utf-8")
		@ResponseBody
		public JsonSanPham update(@RequestParam int maSanPham) {
			SanPham sanPham = sanPhamService.getProduceDetail(maSanPham);
			JsonSanPham jsonSanPham = new JsonSanPham();
			DanhMucSanPham danhMuc = new DanhMucSanPham();
			
			danhMuc.setMadanhmuc(sanPham.getDanmuc().getMadanhmuc());
			danhMuc.setTendanhmuc(sanPham.getDanmuc().getTendanhmuc());
			
			Set<ChiTietSanPham> danhSachChiTietSanPham = new HashSet<ChiTietSanPham>();
			
			for(ChiTietSanPham chiTietSanPham : sanPham.getChitietsanpham() ) {
				MauSanPham mau = new MauSanPham();
				SizeSanPham size = new SizeSanPham();
				ChiTietSanPham chitiet = new ChiTietSanPham();
				mau.setMamau(chiTietSanPham.getMausanpham().getMamau());
				mau.setTenmau(chiTietSanPham.getMausanpham().getTenmau());
				size.setMasize(chiTietSanPham.getSizesanpham().getMasize());
				size.setSize(chiTietSanPham.getSizesanpham().getSize());
				
				chitiet.setMausanpham(mau);
				chitiet.setSizesanpham(size);
				chitiet.setSoluong(chiTietSanPham.getSoluong());
				
				danhSachChiTietSanPham.add(chitiet);
				
			}
			System.out.println(danhSachChiTietSanPham);
			jsonSanPham.setTensanpham(sanPham.getTensanpham());
			jsonSanPham.setGiatien(sanPham.getGiatien());
			jsonSanPham.setDanhmuc(danhMuc);
			jsonSanPham.setMota(sanPham.getMota());
			jsonSanPham.setGianhcho(sanPham.getGianhcho());
			jsonSanPham.setChitietsanpham(danhSachChiTietSanPham);
			
			System.out.println(jsonSanPham);
			return jsonSanPham;
		}
		
}
