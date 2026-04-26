package com.pabloepedro.produto.controller.dto.response;

import com.pabloepedro.entity.Itens;

import java.util.List;

public record ComprasResponse(
        String id,
        String clienteId,
        List<Itens> itens,
        Double valorTotal

) {
}
