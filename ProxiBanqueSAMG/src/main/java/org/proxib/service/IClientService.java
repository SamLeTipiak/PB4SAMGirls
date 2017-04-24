package org.proxib.service;

import java.util.List;

import org.proxib.model.Client;
import org.proxib.service.impl.ServiceClient;

/**
 * Sont déclarées dans cette interface toutes les méthodes propres à la couche
 * Service et relatives aux actions clients. Elles sont définies dans la classe
 * {@link ServiceClient}.
 * 
 * @author Soulabaille Maëva - Potier Aurélie - Bouchet Samuel - Ghania
 *         Bouzemame
 * @version 1.0
 *
 */
public interface IClientService {

	void persist(Client client) throws Exception;

	void merge(Client client) throws Exception;

	void remove(Long id) throws Exception;

	Client findById(Long id) throws Exception;

	List<Client> findAll() throws Exception;


}
