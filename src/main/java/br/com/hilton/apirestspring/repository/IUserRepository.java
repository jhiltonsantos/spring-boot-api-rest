package br.com.hilton.apirestspring.repository;

import br.com.hilton.apirestspring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
