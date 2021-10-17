package com.congtoan.entity;

import java.util.Set;

public class JsonSanPham {
	private String tensanpham;
	private String giatien;
	private String mota;
	private String hinhsanpham;
	private String gianhcho;
	
	private DanhMucSanPham danhmuc;
	private Set<ChiTietSanPham> chitietsanpham;
	private Set<KhuyenMai> danhsachkhuyenmai;
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
	public DanhMucSanPham getDanhmuc() {
		return danhmuc;
	}
	public void setDanhmuc(DanhMucSanPham danmuc) {
		this.danhmuc = danmuc;
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
