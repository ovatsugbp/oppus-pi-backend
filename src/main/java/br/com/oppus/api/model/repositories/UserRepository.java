package br.com.oppus.api.model.repositories;

import br.com.oppus.api.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
