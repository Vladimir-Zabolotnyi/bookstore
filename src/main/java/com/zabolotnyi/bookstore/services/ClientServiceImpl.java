package com.zabolotnyi.bookstore.services;

import com.zabolotnyi.bookstore.dao.BookRepository;
import com.zabolotnyi.bookstore.dao.ClientRepository;
import com.zabolotnyi.bookstore.model.Book;
import com.zabolotnyi.bookstore.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        Client clientToSave = null;
        Optional<Client> clientToBeUpdated = clientRepository.findById(client.getId());
        if (clientToBeUpdated.isPresent()) {
            clientToSave = clientToBeUpdated.get();
        } else log.error("Book not found ");
        clientToSave.setName(client.getName());
        clientToSave.setSurname(client.getSurname());
        clientToSave.setEmail(client.getEmail());
        clientToSave.setDateOfBirth(client.getDateOfBirth());
        return clientRepository.save(clientToSave);
    }

    @Override
    public String removeClient(Long id) {
        clientRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }
}
