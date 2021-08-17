package com.Achaoub.filRouge.services;



import java.util.ArrayList;
import com.Achaoub.filRouge.model.Client;
import com.Achaoub.filRouge.shared.dto.ClientDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClientService  extends UserDetailsService{

	public ClientDto createClient(ClientDto userDto);

	ClientDto getClient(String email);

	ClientDto getClientByClientId(String idUser);

	ClientDto updateClient(String id, ClientDto userDto);
	ClientDto updateEmailVerifClient(String id);

	void deleteClient(String id);

	ArrayList<Client> listClients();
}
