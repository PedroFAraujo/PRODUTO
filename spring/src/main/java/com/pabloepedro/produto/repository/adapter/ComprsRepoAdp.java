package com.pabloepedro.produto.repository.adapter;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.entity.Produto;
import com.pabloepedro.produto.repository.orm.ComprasOrm;
import com.pabloepedro.produto.repository.orm.ProdutoOrm;

public class ComprsRepoAdp {
    private ComprsRepoAdp(){}

    public static Compras castOrm(ComprasOrm orm){
        return new Compras(
                orm.id(),
                orm.clientId(),
                orm.itens(),
                orm.valorTotal());
    }

    public static ComprasOrm castEntity(Compras entity){
        return new ComprasOrm(
                entity.id(),
                entity.clientId(),
                entity.itens(),
                entity.valorTotal());
    }
}
