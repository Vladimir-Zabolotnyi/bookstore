package com.zabolotnyi.bookstore.rest;


import com.zabolotnyi.bookstore.model.Client;
import com.zabolotnyi.bookstore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public @ResponseBody
    List<Client> getAuthor() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public @ResponseBody Client getClientById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteClient(@PathVariable("id") Long id) {
        clientService.removeClient(id);
        return "Deleted";
    }

    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }


    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public @ResponseBody Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }


}
