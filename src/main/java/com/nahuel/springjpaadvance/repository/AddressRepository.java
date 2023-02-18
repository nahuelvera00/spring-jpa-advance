package com.nahuel.springjpaadvance.repository;

import com.nahuel.springjpaadvance.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
