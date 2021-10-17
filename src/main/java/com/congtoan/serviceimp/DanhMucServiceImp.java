package com.congtoan.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congtoan.dao.DanhMucDAO;
import com.congtoan.daoimp.DanhMucDAOImp;
import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.SanPham;

@Service
public class DanhMucServiceImp implements DanhMucDAO{
	@Autowired
	DanhMucDAOImp danhMucDAO;
	
	public List<DanhMucSanPham> getAll() {
		return danhMucDAO.getAll();
	}

	public List<SanPham> getAllProduce(int maDanhMuc) {
		return danhMucDAO.getAllProduce(maDanhMuc);
	}

}
