package com.crud.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.dao.musteriDAO;
import com.crud.model.Musteri;

public class MusteriDAOImpl implements musteriDAO {


	static Connection conn = null;
	
	@Override
	public Connection veritabanıBaglantıKur() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ornekdb","root","1234");
			
			if (!conn.isClosed()) {
				System.out.println("başarılı");
				
			}else {
				System.out.println("başarısız");
			}
		} catch (Exception e) {
			System.out.println("hata: " + e);
		}
		return conn;
		
	}

	@Override
	public List<Musteri> veriOku() {
		veritabanıBaglantıKur();
		List <Musteri> musteriler = new ArrayList<Musteri>();
		Musteri musteri = null;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ornekdb.Musteri");
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
				musteri = new Musteri(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4));
				musteriler.add(musteri);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return musteriler;
	}

	@Override
	public Musteri veriOku(int id) {
		veritabanıBaglantıKur();
		Musteri musteri = null;
		String sql = "SELECT * FROM ornekdb.Musteri WHERE MusteriId = ?" ;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//1. soru işareti anlamında 1
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				
					System.out.println(resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
					musteri = new Musteri(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4));
				}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return musteri;
	}

	@Override
	public boolean veriEkle(Musteri musteri) {
		veritabanıBaglantıKur();
		boolean eklemeDurumu = false;
		String sonuc= null;
		String sql = "INSERT INTO `ornekdb`.`musteri` (`MusteriNo`, `MusteriAd`, `MusteriSoyad`) VALUES (?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, musteri.getMusteriNo());
			ps.setString(2, musteri.getMusteriAd());
			ps.setString(3, musteri.getMusteriSoyad());
			eklemeDurumu = ps.execute();
			
			if(eklemeDurumu == false) {
				sonuc = "basarılı";
			}else {
				sonuc = "başarısız";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sonuc);
		return eklemeDurumu;
	}

	@Override
	public boolean veriDuzenle(Musteri musteri, int id) {
		veritabanıBaglantıKur();
		boolean durum = false;
		try {
		String sorgu = "UPDATE `ornekdb`.`musteri`" + 
						"SET `MusteriNo` = ?, " + 
						"`MusteriAd` = ?, " + 
						"`MusteriSoyad` = ? " + 
						"WHERE `MusteriId` = ? ";
		
		PreparedStatement ps = conn.prepareStatement(sorgu);
		ps.setInt(1, musteri.getMusteriNo());
		ps.setString(2, musteri.getMusteriAd());
		ps.setString(3, musteri.getMusteriSoyad());
		ps.setInt(4, id);
		int update = ps.executeUpdate();
		
		if (update ==1) {
			System.out.println("basarılı");
			durum = true;
			
		} else {
			System.out.println("başarısız");
			durum = false;

		}
		}catch(Exception e){
			System.out.println("hata" + e);
		}
		
		return durum;
	}

	@Override
	public boolean veriSil(int id) {
		veritabanıBaglantıKur();
		boolean silmeDurumu = false;
		Musteri musteri = null;
		String sql = "DELETE FROM `ornekdb`.`musteri` WHERE MusteriId= ?" ;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//1. soru işareti anlamında 1
			ps.setInt(1, id);
			int resultSet = ps.executeUpdate();
			System.out.println("siliniyor.. " + resultSet );
			silmeDurumu= ps.execute();

		} catch (Exception e) {
			System.out.println(e);
		}
		return silmeDurumu;
	}
	
	public static void main(String[] args) {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		Musteri musteri = new Musteri();

//		musteri.setMusteriNo(900);
//		musteri.setMusteriAd("asd");
//		musteri.setMusteriSoyad("fgd");
////		nesne.veriEkle(musteri);
////		nesne.veriDuzenle(musteri, 4);
		
		
	}
	
	

}
