package com.nahuel.springjpaadvance.repository;

import com.nahuel.springjpaadvance.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
