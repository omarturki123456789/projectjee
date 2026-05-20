package com.example.omarturki.reposority;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.omarturki.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
