package com.br.letscode.java.service;

import com.br.letscode.java.models.Entrega;
import com.br.letscode.java.models.StatusEntrega;
import com.br.letscode.java.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscarEntregaService buscarEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscarEntregaService.buscar(entregaId);
        entrega.finalizar();
        entrega.setStatus(StatusEntrega.FINALIZADA);
        entregaRepository.save(entrega);
    }
}
