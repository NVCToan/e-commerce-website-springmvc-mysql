package com.congtoan.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.congtoan.entity.ChiTietHoaDon;
import com.congtoan.entity.ChiTietSanPham;
import com.congtoan.entity.HoaDon;
import com.congtoan.entity.SanPham;

@Controller
@RequestMapping("delete/")
public class XoaSanPhamAPI {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@ResponseBody
	@PostMapping()
	public String delete(@RequestParam Map<String, String>  ids) {
		
			for(String key : ids.keySet()) {
				int masanpham = Integer.parseInt(ids.get(key));
				try {
					Session session = sessionFactory.getCurrentSession();
					
					SanPham sanPham = session.get(SanPham.class, masanpham);
					Set<Integer> danhSachMaHoadon = new HashSet<Integer>();
					Set<ChiTietSanPham> chiTietSanPhams= (Set<ChiTietSanPham>) sanPham.getChitietsanpham();
					
					
					for(ChiTietSanPham chiTietSanPham : chiTietSanPhams) {
						 for(ChiTietHoaDon chiTietHoaDon : chiTietSanPham.getDanhSachChiTietHoaDon()) {
							 danhSachMaHoadon.add(chiTietHoaDon.getHoadon().getMahoadon());
						 }
						session.createQuery("delete from CHITIETHOADON where machitietsanpham= " + chiTietSanPham.getMachitietsanpham()).executeUpdate();
						 System.out.println("Chi tiet - machitietsanpham: " + chiTietSanPham.getMachitietsanpham());
						
					}
					System.out.println(danhSachMaHoadon);
					
					for(Integer mahoadon : danhSachMaHoadon) {
						try {
							List<ChiTietHoaDon> chitiet =  (List<ChiTietHoaDon> ) session.createQuery("from CHITIETHOADON where mahoadon = " + mahoadon).getResultList();
							// null nghia la ma hoa don da khong con duoc tham chieu ben bang chi tiet => Co the xoa duoc bang hoa don
							if(chitiet.size()==0) {
								session.createQuery("delete from HOADON where mahoadon = " + mahoadon).executeUpdate();
							}else {
								System.out.println("Chua xoa ben bang chi tiet");
							}
						} catch (Exception e) {
							System.out.println("Loi roi: " + e.getLocalizedMessage());
						}
					}
					session.delete(sanPham);
					System.out.println("Xoa thanh cong");
				} catch (Exception e) {
					System.out.println("Xoa khong thanh cong");
				}
				
			}
		
		
		return"ok";
	}
}
