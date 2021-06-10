package com.automobilistico.automobilistico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automobilistico.automobilistico.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
