package org.proxib.service;

import java.util.List;

import org.proxib.dao.IAdviserDao;
import org.proxib.model.Adviser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>ServiceAdviser implémente l'interface {@link IAdviserService} et définit les
 * méthodes qui vont permettre d'appeler celles de la couche de persistence s'appliquant
 * aux conseillers de la banque.</b>
 * <p>
 * Ici sont donc définies les méthodes propres à la couche Service et relatives
 * aux actions sur les conseillers.
 * </p>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 */
@Service("serviceAdviser")
public class ServiceAdviser implements IAdviserService {

	@Autowired
	IAdviserDao adviserDao;
	
	@Override
	public void persist(Adviser adviser) throws Exception {
		adviserDao.persist(adviser);
	}

	@Override
	public void merge(Adviser adviser) throws Exception {
		adviserDao.merge(adviser);
	}

	@Override
	public void remove(Long id) throws Exception {
		adviserDao.remove(id);
	}

	@Override
	public Adviser findById(Long id) throws Exception {
		return adviserDao.findById(id);
	}

	@Override
	public List<Adviser> findAll() throws Exception {
		return adviserDao.findAll();
	}


}
