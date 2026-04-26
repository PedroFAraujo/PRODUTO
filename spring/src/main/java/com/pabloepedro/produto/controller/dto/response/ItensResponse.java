package com.pabloepedro.produto.controller.dto.response;

public record ItensResponse(
        String id,
        Double preco,
        Integer qtd
) {
}
