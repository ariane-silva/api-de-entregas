package com.br.letscode.java.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.br.letscode.java.models.Cliente;
import com.br.letscode.java.repository.ClienteRepository;
import com.br.letscode.java.service.CrudClienteService;

import lombok.AllArgsConstructor;
import java.util.List;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")

public class ClienteController {

	private CrudClienteService crudClienteService;
	private ClienteRepository clienteRepository;
	
	@GetMapping//("/clientes")
	public List<Cliente> listar(){
		return clienteRepository.findAll();
}
		
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return crudClienteService.salvar(cliente);
	}

	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,@Valid @RequestBody Cliente cliente){
				if(!clienteRepository.existsById(clienteId)) {
					return ResponseEntity.notFound().build();
				}
				cliente.setId(clienteId);
				cliente = crudClienteService.salvar(cliente);
				return ResponseEntity.ok(cliente);
	}
	@DeleteMapping("/{clienteId}")
	
	public ResponseEntity<Void> remover(@PathVariable Long clienteId){
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		crudClienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
}
