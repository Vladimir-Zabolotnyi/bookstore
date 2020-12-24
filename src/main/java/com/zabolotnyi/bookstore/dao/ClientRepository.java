package com.zabolotnyi.bookstore.dao;

import com.zabolotnyi.bookstore.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
