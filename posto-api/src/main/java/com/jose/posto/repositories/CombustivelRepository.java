package com.jose.posto.repositories;

import com.jose.posto.entities.Combustivel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombustivelRepository extends JpaRepository<Combustivel, Long> {
}
