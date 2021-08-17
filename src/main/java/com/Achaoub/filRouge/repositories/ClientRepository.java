package com.Achaoub.filRouge.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Achaoub.filRouge.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

	Client findByEmail(String email);
	Client findByUserId(String userId);
}
