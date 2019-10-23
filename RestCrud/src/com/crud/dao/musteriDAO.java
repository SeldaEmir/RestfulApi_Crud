package com.crud.dao;

import java.util.List;
import java.sql.Connection;
import com.crud.model.Musteri;

public interface musteriDAO {
	 public Connection veritabanıBaglantıKur();
	 public List <Musteri> veriOku();
	 public Musteri veriOku(int id);
	 public boolean veriEkle(Musteri musteri);
	 public boolean veriDuzenle(Musteri musteri, int id);
	 public boolean veriSil(int id);
}
