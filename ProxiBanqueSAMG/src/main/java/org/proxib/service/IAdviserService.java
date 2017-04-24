package org.proxib.service;

import java.util.List;

import org.proxib.model.Adviser;

/**
 * Sont déclarées dans cette interface toutes les méthodes propres à la couche
 * Service et relatives aux actions sur les conseillers. Elles sont définies dans la classe
 * {@link ServiceAdviser}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
public interface IAdviserService {

	void persist(Adviser adviser) throws Exception;

	void merge(Adviser adviser) throws Exception;

	void remove(Long id) throws Exception;

	Adviser findById(Long id) throws Exception;

	List<Adviser> findAll() throws Exception;
	
	

}
