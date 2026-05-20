package com.example.omarturki.reposority;

import com.example.omarturki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Exemple de méthode personnalisée
    User findByUsername(String username);
}
