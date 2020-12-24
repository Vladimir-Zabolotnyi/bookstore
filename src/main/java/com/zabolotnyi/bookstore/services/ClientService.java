package com.zabolotnyi.bookstore.services;


import com.zabolotnyi.bookstore.model.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);

    Client updateClient(Client client);

    String removeClient(Long id);

    Client getClientById(Long id);

    List<Client> getAllClients();
}
