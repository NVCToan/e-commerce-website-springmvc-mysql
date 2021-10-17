package com.congtoan.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congtoan.dao.SanPhamDAO;
import com.congtoan.daoimp.SanPhamDAOImp;
import com.congtoan.entity.SanPham;

@Service
public class SanPhamServiceImp implements SanPhamDAO{
	@Autowired
	SanPhamDAOImp sanPhamDAO;
	
	public List<SanPham> getListProduce(int fromIndex) {
		return sanPhamDAO.getListProduce(fromIndex);
	}

	public SanPham getProduceDetail(int masanpham) {
		return sanPhamDAO.getProduceDetail(masanpham);
	}

	public List<SanPham> getListProduceLimit(int fromIndex, int toIndex) {
		return sanPhamDAO.getListProduceLimit(fromIndex, toIndex);
		
	}

	public Long countProduce() {
		return sanPhamDAO.countProduce();
	}

	public int themSanPham(SanPham sanpham) {
		
		return sanPhamDAO.themSanPham(sanpham);
	}

	public int updateSanPham(SanPham sanpham) {
		return sanPhamDAO.updateSanPham(sanpham);
	}

}
