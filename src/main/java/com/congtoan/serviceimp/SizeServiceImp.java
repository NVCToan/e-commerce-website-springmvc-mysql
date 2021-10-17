package com.congtoan.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congtoan.dao.SizeDAO;
import com.congtoan.daoimp.SizeDAOImp;
import com.congtoan.entity.SizeSanPham;

@Service
public class SizeServiceImp implements SizeDAO {
	@Autowired 
	SizeDAOImp sizeDAO;
	
	public List<SizeSanPham> getSizes() {
		return sizeDAO.getSizes();
	}

}
