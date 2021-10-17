package com.congtoan.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.congtoan.dao.HoaDonDAO;
import com.congtoan.daoimp.HoaDonDAOImp;
import com.congtoan.entity.HoaDon;
@Service
public class HoaDonServiceImp implements HoaDonDAO{
	@Autowired 
	HoaDonDAOImp hoaDonDAO;

	public boolean addBill(HoaDon hoadon) {
		return hoaDonDAO.addBill(hoadon);
	}
	
	
}
