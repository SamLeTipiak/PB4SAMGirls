package org.proxib.dao.impl;

import org.proxib.dao.IAdviserDao;
import org.proxib.dao.IClientDao;
import org.proxib.model.Adviser;
import org.proxib.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * AdviserDaoImpl étend {@link EntityDaoImpl}, implémente {@link IAdviserDao} et s'applique donc
 * au type {@link Adviser}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
@Repository
@Transactional
public class AdviserDaoImpl extends EntityDaoImpl<Adviser> implements IAdviserDao {


}
