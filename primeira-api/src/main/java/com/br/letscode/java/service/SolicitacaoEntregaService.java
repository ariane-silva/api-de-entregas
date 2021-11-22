package com.br.letscode.java.service;

import com.br.letscode.java.models.Cliente;
import com.br.letscode.java.models.Entrega;
import com.br.letscode.java.models.StatusEntrega;
import com.br.letscode.java.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private CrudClienteService crudClienteService;


    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = crudClienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);

    }
}
