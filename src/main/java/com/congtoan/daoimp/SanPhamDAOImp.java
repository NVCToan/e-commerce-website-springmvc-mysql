package com.congtoan.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.congtoan.dao.SanPhamDAO;
import com.congtoan.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAOImp implements SanPhamDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> getListProduce(int fromIndex) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "from SANPHAM";
			List<SanPham> danhSachSanPham = (List<SanPham>) session.createQuery(sql).getResultList();
			return danhSachSanPham;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
		
	}
	
	@Transactional
	public SanPham getProduceDetail(int masanpham) {
		String query = "from SANPHAM where masanpham =" +masanpham;
		Session session = sessionFactory.getCurrentSession();

		try {
			SanPham sanpham = (SanPham) session.createQuery(query).getSingleResult();
			return sanpham;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Transactional
	public List<SanPham> getListProduceLimit(int fromIndex, int toIndex) {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "from SANPHAM";
			List<SanPham> danhSachSanPham = (List<SanPham>) session.createQuery(sql).setFirstResult(fromIndex).setMaxResults(5).getResultList();
			return danhSachSanPham;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return null;
		}
	}
	@Transactional
	public Long countProduce() {
		Session session = sessionFactory.getCurrentSession();
		try {
			String sql = "select count(*) from SANPHAM ";
			Long count = (Long) session.createQuery(sql).uniqueResult();
			return count;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Transactional
	public int themSanPham(SanPham sanpham) {
		Session session = sessionFactory.getCurrentSession();
		try {
			int count = (Integer) session.save(sanpham);
			return count;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0 ;
		}
	}
	@Transactional
	public int updateSanPham(SanPham sanpham) {
		Session session = sessionFactory.getCurrentSession();
		try {
			 session.update(sanpham);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0 ;
		}
		
	}

}
