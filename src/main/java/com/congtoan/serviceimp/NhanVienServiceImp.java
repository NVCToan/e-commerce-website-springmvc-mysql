package com.congtoan.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congtoan.dao.NhanVienDAO;
import com.congtoan.daoimp.NhanVienDAOImp;
import com.congtoan.entity.NhanVien;
@Service
public class NhanVienServiceImp implements NhanVienDAO{
	@Autowired
	NhanVienDAOImp nhanVienDAO;
	
	
	public boolean getInfo(String tendangnhap, String matkhau) {
		boolean result =  nhanVienDAO.getInfo(tendangnhap, matkhau);
		return result;
	}


	public boolean addNhanVien(NhanVien nhanvien) {
		return nhanVienDAO.addNhanVien(nhanvien);
	}


	public boolean checkAccount(String email) {
		return nhanVienDAO.checkAccount(email);
	}
	
	
	
}
