package com.congtoan.dao;

import java.util.List;

import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.SanPham;

public interface DanhMucDAO {
	
	
	public List<DanhMucSanPham> getAll();
	public List<SanPham> getAllProduce(int maDanhMuc);
}
