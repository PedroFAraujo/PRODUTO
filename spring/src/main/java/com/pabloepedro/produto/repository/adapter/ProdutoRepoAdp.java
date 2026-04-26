package com.pabloepedro.produto.repository.adapter;

import com.pabloepedro.entity.Produto;
import com.pabloepedro.produto.repository.orm.ProdutoOrm;

public class ProdutoRepoAdp {
    private ProdutoRepoAdp(){}

    public static Produto castOrm(ProdutoOrm orm){
        return new Produto(
                orm.id(),
                orm.nome(),
                orm.value());
    }

    public static ProdutoOrm castEntity(Produto entity){
        return new ProdutoOrm(
                entity.id(),
                entity.nome(),
                entity.value());
    }
}
