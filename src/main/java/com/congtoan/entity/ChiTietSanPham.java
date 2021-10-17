package com.congtoan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "CHITIETSANPHAM")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int machitietsanpham;
	private	int soluong;
	private	String ngaynhap;
	@OneToOne()
	@JoinColumn(name = "masanpham")
	private	SanPham sanpham;
	@OneToOne()
	@JoinColumn(name="masize")
	SizeSanPham sizesanpham;
	
	@OneToOne()
	@JoinColumn(name="mamau")
	MauSanPham mausanpham;
	
	@OneToMany()
	@JoinColumn(name="machitietsanpham")
	Set<ChiTietHoaDon> danhSachChiTietHoaDon;
	
	public int getMachitietsanpham() {
		return machitietsanpham;
	}
	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
//	public SanPham getSanpham() {
//		return sanpham;
//	}
//	public void setSanpham(SanPham sanpham) {
//		this.sanpham = sanpham;
//	}
	
	public SizeSanPham getSizesanpham() {
		return sizesanpham;
	}
	
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public Set<ChiTietHoaDon> getDanhSachChiTietHoaDon() {
		return danhSachChiTietHoaDon;
	}
	public void setDanhSachChiTietHoaDon(Set<ChiTietHoaDon> danhSachChiTietHoaDon) {
		this.danhSachChiTietHoaDon = danhSachChiTietHoaDon;
	}
	public void setSizesanpham(SizeSanPham sizesanpham) {
		this.sizesanpham = sizesanpham;
	}
	public MauSanPham getMausanpham() {
		return mausanpham;
	}
	public void setMausanpham(MauSanPham mausanpham) {
		this.mausanpham = mausanpham;
	}

	
	
}
