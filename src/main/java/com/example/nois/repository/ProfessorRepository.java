package com.example.nois.repository;

import com.example.nois.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Object> findByEmailAndSenha(String email, String senha);
}
