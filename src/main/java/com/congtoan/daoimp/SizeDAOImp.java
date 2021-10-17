package com.congtoan.daoimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congtoan.dao.SizeDAO;
import com.congtoan.entity.SizeSanPham;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeDAOImp implements SizeDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SizeSanPham> getSizes() {
		
		List<SizeSanPham> sizes = new ArrayList<SizeSanPham>();
		String query = "from SIZESANPHAM";
		
		Session session =  sessionFactory.getCurrentSession();
		
		try {
			sizes = (List<SizeSanPham>) session.createQuery(query).getResultList();
			
			return sizes;
		} catch (Exception e) {
			return null;		
		}
		
		
		
	
	}

}
