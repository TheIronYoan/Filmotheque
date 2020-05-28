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
	

	public Artist findById(  int id) throws ArtistNonTrouveException {
		Artist art = dao.findById(id);
		if(art==null) {
			throw new ArtistNonTrouveException();
		}
		return art;
	}

	@Transactional
	public void saveArtist( Artist art)  {
		if(art.getId()==0) {
			dao.add(art);
		}else {
			dao.update(art);
		}
	}

	@Transactional
	public void deleteArtist( Artist artist) throws ArtistNonTrouveException {
		
		dao.delete(artist);
		
	}

	@Override
	public List<Artist> findAllArtist() {
		return dao.findAll();
	}


	@Override
	public List<Artist> findAllActors() {
		// TODO Auto-generated method stub
		return dao.findAllActors();
	}


	@Override
	public List<Artist> findAllDirectors() {
		// TODO Auto-generated method stub
		return dao.findAllDirectors();
	}

}
