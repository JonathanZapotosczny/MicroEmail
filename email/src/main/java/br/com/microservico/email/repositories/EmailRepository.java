package br.com.microservico.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.microservico.email.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {
    
}