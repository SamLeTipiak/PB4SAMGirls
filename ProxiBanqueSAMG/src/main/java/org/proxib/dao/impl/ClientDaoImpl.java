package org.proxib.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.proxib.dao.IClientDao;
import org.proxib.dao.IEntityDao;
import org.proxib.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClientDaoImpl étend {@link EntityDaoImpl}, implémente {@link IClientDao} et s'applique donc
 * au type {@link Client}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Repository
@Transactional
public class ClientDaoImpl extends EntityDaoImpl<Client> implements IClientDao {


}
