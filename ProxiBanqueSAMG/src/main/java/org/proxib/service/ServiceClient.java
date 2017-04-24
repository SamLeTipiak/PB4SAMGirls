package org.proxib.service;

import java.util.List;

import org.proxib.dao.IClientDao;
import org.proxib.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>ServiceClient implémente l'interface {@link IClientService} et définit les
 * méthodes qui vont permettre d'appeler celles de la couche de persistence s'appliquant
 * aux clients de la banque.</b>
 * <p>
 * Ici sont donc définies les méthodes propres à la couche Service et relatives
 * aux actions sur le client.
 * </p>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 */
@Service("serviceClient")
public class ServiceClient implements IClientService {

	@Autowired
	IClientDao clientDao;

	@Override
	public void persist(Client client) throws Exception {
		clientDao.persist(client);
	}

	@Override
	public void merge(Client client) throws Exception {
		clientDao.merge(client);
	}

	@Override
	public void remove(Long id) throws Exception {
		clientDao.remove(id);
	}

	@Override
	public Client findById(Long id) throws Exception {
		return clientDao.findById(id);
	}

	@Override
	public List<Client> findAll() throws Exception {
		return clientDao.findAll();
	}

	@Override
	public List<Client> findByProperty(String prop, Object val) throws Exception {
		return clientDao.findByProperty(prop, val);
	}

}
