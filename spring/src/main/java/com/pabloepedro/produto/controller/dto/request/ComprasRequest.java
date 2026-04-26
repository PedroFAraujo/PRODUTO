package com.pabloepedro.produto.controller.dto.request;

import com.pabloepedro.entity.Itens;

import java.util.List;

public record ComprasRequest(
        String clientId,
        List<Itens> itens,
        Double valor
) {
}
