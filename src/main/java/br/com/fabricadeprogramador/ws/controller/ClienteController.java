package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Cliente;
import br.com.fabricadeprogramador.ws.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	
	//End Points
	
	@RequestMapping(method=RequestMethod.POST, value="/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		
		Cliente clienteCadastrado = clienteService.cadastrar(cliente);
		
		return clienteCadastrado;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarClientes(){
		
		Collection<Cliente> clientes=clienteService.buscar();
		
		return new ResponseEntity<>(clientes,HttpStatus.OK);	
		
	}	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/clientes/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {
		
		Cliente clienteEncontrado = clienteService.buscarCliente(id);
		
		if(clienteEncontrado==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(clienteEncontrado,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	public ResponseEntity<Cliente> excluirClientePorId(@PathVariable Integer id){
		Cliente clienteEncontrado = clienteService.buscarCliente(id);
		if(clienteEncontrado==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		clienteService.excluirCliente(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> alterarObjCliente(@RequestBody Cliente cliente){
		
		Cliente clienteAlterado = clienteService.alterarCliente(cliente);
		
		if(cliente==null ||clienteAlterado==null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(clienteAlterado,HttpStatus.OK);
	}
	
	
	
	
}
