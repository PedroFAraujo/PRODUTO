package com.pabloepedro.produto.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "produto")
public record ProdutoOrm(
        @Id
        String id,
        String nome,
        Double value

) {

}
