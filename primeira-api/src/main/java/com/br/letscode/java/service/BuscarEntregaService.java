package com.br.letscode.java.service;

import com.br.letscode.java.exceptions.NegocioException;
import com.br.letscode.java.models.Entrega;
import com.br.letscode.java.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscarEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new NegocioException("Entrega não encontrada! "));
    }
}
