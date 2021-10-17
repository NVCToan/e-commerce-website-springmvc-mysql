package com.congtoan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="SANPHAM")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int masanpham;
	private String tensanpham;
	private String giatien;
	private String mota;
	private String hinhsanpham;
	private String gianhcho;
	
	@OneToOne()
	@JoinColumn(name="madanhmuc")
	private DanhMucSanPham danmuc;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "masanpham")
	private Set<ChiTietSanPham> chitietsanpham;
	
	@ManyToMany()
	@JoinTable(name = "CHITIETKHUYENMAI",
	joinColumns = {@JoinColumn(name = "masanpham", referencedColumnName = "masanpham")},
	inverseJoinColumns = {@JoinColumn(name = "makhuyenmai", referencedColumnName = "makhuyenmai")})
	private Set<KhuyenMai> danhsachkhuyenmai;
	
	
	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	public String getGianhcho() {
		return gianhcho;
	}

	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}

	public DanhMucSanPham getDanmuc() {
		return danmuc;
	}

	public void setDanmuc(DanhMucSanPham danmuc) {
		this.danmuc = danmuc;
	}

	public Set<ChiTietSanPham> getChitietsanpham() {
		return chitietsanpham;
	}

	public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}

	public Set<KhuyenMai> getDanhsachkhuyenmai() {
		return danhsachkhuyenmai;
	}

	public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}
	
	
}
