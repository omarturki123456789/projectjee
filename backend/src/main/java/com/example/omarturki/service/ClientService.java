package com.example.omarturki.service;

import com.example.omarturki.model.Client;
import com.example.omarturki.reposority.ClientRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found: " + id));
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Client existing = getClientById(id);
        existing.setNom(client.getNom());
        existing.setEmail(client.getEmail());
        existing.setAdresse(client.getAdresse());
        return clientRepository.save(existing);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public long countAll() {
        return clientRepository.count();
    }
}
