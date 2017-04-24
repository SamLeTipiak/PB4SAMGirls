package org.proxib.dao;

import java.util.List;

/**
 * <p>
 * Sont déclarées dans cette interface générique toutes les méthodes permettant
 * la communication avec la base de données (persistence des données en base
 * ainsi que la récupération de celles ci).
 * </p>
 * <p>
 * Elles sont définies dans la classe {@link EntityDaoImpl}.
 * </p>
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 * @param <E>
 */
public interface IEntityDao<E> {

	void persist(E e) throws Exception;

	void merge(E e) throws Exception;

	void remove(Object id) throws Exception;

	E findById(Object id) throws Exception;

	List<E> findAll() throws Exception;

	List<E> findByProperty(String prop, Object val) throws Exception;


}
