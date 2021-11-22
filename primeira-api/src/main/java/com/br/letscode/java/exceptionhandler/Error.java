package com.br.letscode.java.exceptionhandler;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
public class Error {
    private int status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;


    @Getter
    @AllArgsConstructor
    public static class Campo {
        private String campo;
        private String mensagem;
    }
}
