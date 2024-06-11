package de.htwberlin.webtechsose24.repository;

import de.htwberlin.webtechsose24.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
