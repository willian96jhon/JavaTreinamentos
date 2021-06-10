package com.automobilistico.automobilistico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automobilistico.automobilistico.model.Cadastro;

public interface AutomovelRepository extends JpaRepository<Cadastro,Long>{

}
