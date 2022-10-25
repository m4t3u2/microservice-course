package br.dev.simon.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.simon.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
