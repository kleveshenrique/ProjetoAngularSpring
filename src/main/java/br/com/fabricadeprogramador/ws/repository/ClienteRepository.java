package br.com.fabricadeprogramador.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.ws.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
