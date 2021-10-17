package com.congtoan.serviceimp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congtoan.dao.MauDAO;
import com.congtoan.daoimp.MauDAOImp;
import com.congtoan.entity.MauSanPham;
@Service
public class MauServiceImp implements MauDAO{
	@Autowired
	MauDAOImp mauDAO;
	public List<MauSanPham> getColors() {
		return mauDAO.getColors();
	}

}
