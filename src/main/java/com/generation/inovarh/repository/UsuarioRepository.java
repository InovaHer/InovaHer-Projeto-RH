package com.generation.inovarh.repository;


import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.inovarh.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsuario(String usuario);

	Optional<List<Usuario>> findAllByNomeContainingIgnoreCase(String nome);

}