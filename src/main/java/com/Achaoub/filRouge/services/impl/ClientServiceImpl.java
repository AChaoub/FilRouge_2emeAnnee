package com.Achaoub.filRouge.services.impl;




import java.util.ArrayList;


import javax.transaction.Transactional;
import com.Achaoub.filRouge.model.Client;

import com.Achaoub.filRouge.repositories.ClientRepository;
import com.Achaoub.filRouge.shared.Utils;
import com.Achaoub.filRouge.shared.dto.ClientDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.Achaoub.filRouge.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepo;

	@Autowired
	Utils util;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
//	@Autowired
//	EmailServiceImpl email;
	
//	@Autowired
//	UserRepository userRepository;

	@Override
	public ClientDto createClient(ClientDto clientDto) {
		// TODO Auto-generated method stub

		String userID = util.generateUser(10);
		// Verifier si email est existant
		Client userByEmail = clientRepo.findByEmail(clientDto.getEmailClient());

		if (userByEmail != null) {
			throw new RuntimeException("Email Deja existant");
		}

		Client clientEntity = new Client();
		BeanUtils.copyProperties(clientDto, clientEntity);

		clientEntity.setUserIDClient(userID);
		clientEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(clientDto.getPasswordClient()));
		clientEntity.setNomClient(clientDto.getNomClient());
		clientEntity.setPrenomClient(clientDto.getPrenomClient());
		clientEntity.setRoleClient(clientDto.getRoleClient());
		
//		if (clientDto.getRoleClient().equals("Locataire")) {
////			clientEntity.setRoleID(1);
//			clientEntity.setEmailVerificationStatus(true);
//		}

		Client newClient = clientRepo.save(clientEntity);

		ClientDto newClientDto = new ClientDto();
		BeanUtils.copyProperties(newClient, newClientDto);

		return newClientDto;
	}

	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client clientCourant = clientRepo.findByEmail(email);


//
		if (clientCourant == null) {
			throw new UsernameNotFoundException(email);
		}
		//return new User(userCourant.getEmail(), userCourant.getEncryptedPassword(), new ArrayList<>());
		 return User.withUsername(clientCourant.getEmailClient()).password(clientCourant.getEncryptedPassword()).roles(clientCourant.getRoleClient()).build();

	}
//	@Override
//	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//		UserEntity user = this.userRepo.findByEmail(s);
//		UserPrincipal userPrincipal = new UserPrincipal(user);
//		return userPrincipal;
//	}

	@Override
	public ClientDto getClient(String email) {

		Client clientEntity = clientRepo.findByEmail(email);

		if (clientEntity == null)
			throw new UsernameNotFoundException(email);

		ClientDto clientDto = new ClientDto();

		BeanUtils.copyProperties(clientEntity, clientDto);

		return clientDto;
	}

	@Override
	public ClientDto getClientByClientId(String idUser) {
		// TODO Auto-generated method stub
		Client clientEntity = clientRepo.findByUserId(idUser);
		if (clientEntity == null)
			throw new UsernameNotFoundException(idUser);

		ClientDto clientDto = new ClientDto();

		BeanUtils.copyProperties(clientEntity, clientDto);
		return clientDto;
	}

	@Override
	public ClientDto updateClient(String id, ClientDto clientDto) {

		Client clientEntity = clientRepo.findByUserId(id);

		if (clientEntity == null)
			throw new UsernameNotFoundException(id);

		clientEntity.setNomClient(clientDto.getNomClient());
		clientEntity.setPrenomClient(clientDto.getPrenomClient());
		clientEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(clientDto.getPasswordClient()));
		clientEntity.setRoleClient(clientDto.getRoleClient());
//		if (clientDto.getRoleClient().equals("Locataire")) {
//			clientEntity.setRoleID(0);
//		} else if (clientDto.getRole().equals("Administrateur")) {
//			clientEntity.setRoleID(1);
//			clientEntity.setEmailVerificationStatus(true);
//		}
		// userEntity.setEncryptedPassword(userDto.getEncryptedPassword());

		Client clientUpdated = clientRepo.save(clientEntity);
		ClientDto client = new ClientDto();
		BeanUtils.copyProperties(clientUpdated, client);

		return client;
	}

	@Override
	public void deleteClient(String id) {
		// TODO Auto-generated method stub
		Client client = clientRepo.findByUserId(id);
		if (client == null)
			throw new UsernameNotFoundException(id);

		clientRepo.delete(client);
	}

	@Override
	public ArrayList<Client> listClients() {
		// TODO Auto-generated method stub

		ArrayList<Client> list = (ArrayList<Client>) clientRepo.findAll();

		return list;
	}

	@Override
	public ClientDto updateEmailVerifClient(String id) {
		Client client = clientRepo.findByUserId(id);
		String motPasse = util.generateUser(10);

		if (client == null) {
			throw new UsernameNotFoundException(id);
		}

		//client.setEmailVerificationStatus(true);
		//userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode("123456"));
		client.setEncryptedPassword(bCryptPasswordEncoder.encode(motPasse));
		Client clientUpdated = clientRepo.save(client);

		
		ClientDto clientDto = new ClientDto();
		clientDto.setPasswordClient(motPasse);
		BeanUtils.copyProperties(clientUpdated, clientDto);
		
		
		return clientDto;
	}



}
