package com.congtoan.daoimp;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congtoan.dao.HoaDonDAO;
import com.congtoan.entity.ChiTietHoaDon;
import com.congtoan.entity.HoaDon;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAOImp implements HoaDonDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addBill(HoaDon hoadon) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(hoadon);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
}
