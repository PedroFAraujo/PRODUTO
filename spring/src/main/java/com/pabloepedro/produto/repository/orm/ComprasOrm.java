package com.pabloepedro.produto.repository.orm;

import com.pabloepedro.entity.Itens;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "compras")
public record ComprasOrm(
        @Id
        String id,
        String clientId,
        List<Itens> itens,
        Double valorTotal
) {
}
