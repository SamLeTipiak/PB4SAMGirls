package org.proxib.service;

import java.util.List;

import org.proxib.dao.IAdviserDao;
import org.proxib.model.Adviser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//	@Override
//	public List<Client> findByProperty(String prop, Object val) throws Exception {
//		return adviserDao.findByProperty(prop, val);
//	}

}
