package com.crud.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crud.dao.musteriDAO;
import com.crud.dao.impl.MusteriDAOImpl;
import com.crud.model.Musteri;

@Path("/customer")
public class MusteriRestfulService {

	// http://localhost:8080/RestCrud/rest/customer/all
	@GET
	@Path("/all")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public List<Musteri> musterileriGetir() {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		return nesne.veriOku();
		
//		List<Musteri> musteriler = new ArrayList<Musteri>();
//		Musteri musteri = null;
//		
//		for (int i = 1; i < 10; i++) {
//			
//			musteri = new Musteri(i, i*i, "musteriAdi"+i, "musteriSoyadi"+i);
//			
//			musteri = new Musteri();
//			musteri.setMusteriId(i);
//			musteri.setMusteriNo(i*i);
//			musteri.setMusteriAd("musteriAdi"+i);
//			musteri.setMusteriSoyad("musteriSoyadi"+i);
//			
//			musteriler.add(musteri);
//		}
//		return musteriler;
	}

	// http://localhost:8080/RestCrud/rest/customer/2
	@GET
	@Path("/{customerId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Musteri musteriGetirById(@PathParam("customerId") int musteriId) {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		return nesne.veriOku(musteriId);
	}

	@POST
	@Path("/add")
	@Consumes({ MediaType.APPLICATION_XML + ";charset=utf-8" })
	public Response musteriEkle(Musteri musteri) {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		boolean durum = nesne.veriEkle(musteri);
		if (durum == false)
			return Response.status(201).build();
		else
			return Response.status(204).build();
	}

	@PUT
	@Path("/edit/{customerId}")
	@Consumes({ MediaType.APPLICATION_XML + ";charset=utf-8" })
	@Produces({ MediaType.APPLICATION_XML + ";charset=utf-8" })
	public Musteri musteriDuzenle(Musteri musteri, @PathParam("customerId") int musteriId) {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		boolean durum = nesne.veriDuzenle(musteri, musteriId);
		if (durum == true)
			return musteri;
		else
			return null;
	}

	@DELETE
	@Path("/delete/{customerId}")
	public Response musteriSil(@PathParam("customerId") int musteriId) {
		MusteriDAOImpl nesne = new MusteriDAOImpl();
		boolean durum = nesne.veriSil(musteriId);
		if (durum == false)
			return Response.status(201).build();
		else
			return Response.status(204).build();
	}

}
