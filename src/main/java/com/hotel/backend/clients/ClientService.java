package com.hotel.backend.clients;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Client getClient(Long id){
        return clientRepository.findById(id).get();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client deleteClient(Long id) {
        Client client = clientRepository.findById(id).get();
        clientRepository.deleteById(id);
        return client; 
    }
    
}
