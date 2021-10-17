package com.congtoan.dao;

import java.util.List;

import com.congtoan.entity.SanPham;

public interface SanPhamDAO {
	public List<SanPham> getListProduce(int fromIndex); 
	public List<SanPham> getListProduceLimit(int fromIndex, int toIndex); 
	public SanPham getProduceDetail(int masanpham);
	public Long countProduce();
	public int themSanPham(SanPham sanpham);
	public int updateSanPham(SanPham sanpham);
	
}
