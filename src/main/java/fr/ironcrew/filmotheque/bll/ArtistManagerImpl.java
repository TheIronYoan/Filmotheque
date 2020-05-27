package fr.ironcrew.filmotheque.bll;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.ironcrew.filmotheque.bo.Artist;
import fr.ironcrew.filmotheque.dal.ArtistDAO;

@Service
public class ArtistManagerImpl implements ArtistManager{

	@Autowired
	private ArtistDAO dao;
	
	
	public ArtistManagerImpl() {

	}
	
	

	public Artist findById(  long id) throws ArtistNonTrouveException {
		Artist art = dao.findById(id);
		if(art==null) {
			throw new ArtistNonTrouveException();
		}
		return art;
	}

	@Transactional
	public void enregistrerArtist( Artist art)  {
		if(art.getId()==0) {
			dao.add(art);
		}else {
			dao.update(art);
		}
	}

	@Transactional
	public void supprimerArtist( Artist id) throws ArtistNonTrouveException {
		
		dao.delete(id);
		
	}



	@Override
	public List<Artist> findAllArtist() {
		return dao.findAll();
	}



}
