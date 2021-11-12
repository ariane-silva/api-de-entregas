package com.br.letscode.java.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.letscode.java.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	Optional<Cliente>findByEmail(String email);
	
}
