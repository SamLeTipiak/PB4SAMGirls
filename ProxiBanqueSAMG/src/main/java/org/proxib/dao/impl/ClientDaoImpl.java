package org.proxib.dao.impl;



import org.proxib.dao.ClientDao;
import org.proxib.model.Client;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ClientDaoImpl extends EntityDaoImpl<Client> implements ClientDao {

	

}