package com.nahuel.springjpaadvance.repository;

import com.nahuel.springjpaadvance.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
