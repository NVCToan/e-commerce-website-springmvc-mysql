package com.congtoan.dao;

import com.congtoan.entity.NhanVien;

public interface NhanVienDAO {
	public boolean getInfo(String tendangnhap, String matkhau);
	public boolean addNhanVien(NhanVien nhanVien);
	public boolean checkAccount(String email);
}
