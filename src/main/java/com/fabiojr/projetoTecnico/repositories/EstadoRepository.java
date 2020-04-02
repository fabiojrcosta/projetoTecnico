package com.fabiojr.projetoTecnico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabiojr.projetoTecnico.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}