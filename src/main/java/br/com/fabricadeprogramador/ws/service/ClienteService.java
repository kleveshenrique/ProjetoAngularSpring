package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;	
	
	//Negocios
	
	public Cliente cadastrar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
	public Collection<Cliente> buscar(){
		
		
		return clienteRepository.findAll();
		
	}
	
	public Cliente buscarCliente(Integer id) {
		
		return this.clienteRepository.findById(id).orElse(null);	
    
	}
	
	public void excluirCliente(Integer id) {
		
		clienteRepository.deleteById(id);	
	}
	
	public Cliente alterarCliente(Cliente pCliente){
		return clienteRepository.save(pCliente); 
		
	}

}
