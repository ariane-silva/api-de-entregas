package com.br.letscode.java.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.letscode.java.exceptions.NegocioException;
import com.br.letscode.java.models.Cliente;
import com.br.letscode.java.models.Entrega;
import com.br.letscode.java.models.StatusEntrega;
import com.br.letscode.java.repository.ClienteRepository;
import com.br.letscode.java.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

	private EntregaRepository entregaRepository;
	//private ClienteRepository clienteRepository;
	private CrudClienteService crudClienteService;
	
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
	/*	Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado."));*/
		
		Cliente cliente = crudClienteService.buscar(entrega.getCliente().getId());
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime .now());
		return entregaRepository.save(entrega);
		
	}
}
