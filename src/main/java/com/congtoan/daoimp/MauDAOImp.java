package com.congtoan.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congtoan.dao.MauDAO;
import com.congtoan.entity.MauSanPham;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauDAOImp implements MauDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<MauSanPham> getColors() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from MAUSANPHAM";
		try {
			List<MauSanPham> colors = (List<MauSanPham>)session.createQuery(query).getResultList();
			return colors;
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
