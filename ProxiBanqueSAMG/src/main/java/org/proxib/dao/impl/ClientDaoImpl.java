package org.proxib.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.proxib.dao.IClientDao;
import org.proxib.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientDaoImpl extends EntityDaoImpl<Client> implements IClientDao {


}
