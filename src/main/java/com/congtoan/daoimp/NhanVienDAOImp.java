package com.congtoan.daoimp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congtoan.dao.NhanVienDAO;
import com.congtoan.entity.NhanVien;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAOImp implements NhanVienDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean getInfo(String tendangnhap, String matkhau) {
		String sql = "from NHANVIEN where tendangnhap= '"+tendangnhap+"' AND matkhau = '"+matkhau+"' "  ;
		
		Session session = sessionFactory.getCurrentSession();
		try {
			NhanVien nhanVien = (NhanVien) session.createQuery(sql).getSingleResult();
			if(nhanVien != null) {
				
				return true;
			}
		} catch (Exception e) {
			
			return false;
		}
		
		return false;
	}
	@Transactional
	public boolean addNhanVien(NhanVien nhanvien) {
	
		Session session = sessionFactory.getCurrentSession();
		int idNhanVien = (Integer) session.save(nhanvien);
		if(idNhanVien > 0) {
			return true;
		}else {
			
			return false;
		}
	}
	
	@Transactional
	public boolean checkAccount(String email) {
		Session session = sessionFactory.getCurrentSession();
		try {
			NhanVien nhanVien = (NhanVien) session.createQuery("from NHANVIEN where email= '"+email+"' " ).getSingleResult();
			if(nhanVien !=null) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
			
	}

}
