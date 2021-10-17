package com.congtoan.daoimp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congtoan.dao.DanhMucDAO;
import com.congtoan.entity.DanhMucSanPham;
import com.congtoan.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAOImp implements DanhMucDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<DanhMucSanPham> getAll() {
		List<DanhMucSanPham> danhMucSanPham = new ArrayList<DanhMucSanPham>();
		
		Session session = sessionFactory.getCurrentSession();
		try {
			String query = "from DANHMUCSANPHAM";
			danhMucSanPham = (List<DanhMucSanPham>) session.createQuery(query).getResultList();
			return danhMucSanPham;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Transactional
	public List<SanPham> getAllProduce(int maDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
		try {
			String query = "from SANPHAM sp where sp.danmuc.madanhmuc = " + maDanhMuc;
			danhSachSanPham = (List<SanPham>) session.createQuery(query).getResultList();
			return danhSachSanPham;
		} catch (Exception e) {
			return null;
		}
	}

}
