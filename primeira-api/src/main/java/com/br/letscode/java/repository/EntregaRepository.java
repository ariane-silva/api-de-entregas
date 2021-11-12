package com.br.letscode.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.letscode.java.models.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
