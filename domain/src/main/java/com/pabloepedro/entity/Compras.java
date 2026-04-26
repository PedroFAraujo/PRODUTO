package com.pabloepedro.entity;

import java.util.List;

public record Compras(
        String id,
        String clientId,
        List<Itens> itens,
        Double valorTotal
) {
}
