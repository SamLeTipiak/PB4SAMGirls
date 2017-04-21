package org.proxib.service;

import java.util.List;

import org.proxib.dao.IClientDao;
import org.proxib.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
