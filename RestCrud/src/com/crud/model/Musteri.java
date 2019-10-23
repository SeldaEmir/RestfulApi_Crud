package com.crud.model;

import javax.xml.bind.annotation.*;


@XmlRootElement(name="musteri")
public class Musteri {

	int MusteriId;
	int MusteriNo;
	String MusteriAd;
	String MusteriSoyad;
	
	@XmlElement
	public int getMusteriId() {
		return MusteriId;
	}
	public void setMusteriId(int musteriId) {
		MusteriId = musteriId;
	}
	
	@XmlElement
	public int getMusteriNo() {
		return MusteriNo;
	}
	public void setMusteriNo(int musteriNo) {
		MusteriNo = musteriNo;
	}
	
	@XmlElement
	public String getMusteriAd() {
		return MusteriAd;
	}
	public void setMusteriAd(String musteriAd) {
		MusteriAd = musteriAd;
	}
	
	@XmlElement
	public String getMusteriSoyad() {
		return MusteriSoyad;
	}
	
	public void setMusteriSoyad(String musteriSoyad) {
		MusteriSoyad = musteriSoyad;
	}

	public Musteri(int musteriId, int musteriNo, String musteriAd, String musteriSoyad) {
		super();
		MusteriId = musteriId;
		MusteriNo = musteriNo;
		MusteriAd = musteriAd;
		MusteriSoyad = musteriSoyad;
	}
	
	public Musteri() {
		super();
	}
	
	@Override
	public String toString() {
		return "Musteri [MusteriId=" + MusteriId + ", MusteriNo=" + MusteriNo + ", MusteriAd=" + MusteriAd
				+ ", MusteriSoyad=" + MusteriSoyad + "]";
	}
	
}
