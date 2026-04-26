package com.pabloepedro.produto.controller.adapter;

import com.pabloepedro.entity.Produto;
import com.pabloepedro.produto.controller.dto.request.ProdutoRequest;
import com.pabloepedro.produto.controller.dto.response.ProdutoResponse;

import java.util.UUID;

public class ProdutoCtrlAdp {
    private ProdutoCtrlAdp(){}

    public static Produto castRequest(ProdutoRequest request){
        return new Produto(
                UUID.randomUUID().toString(),
                request.nome(),
                request.value());
    }

    public static ProdutoResponse castResponse(Produto produto){
        return new ProdutoResponse(
                produto.id(),
                produto.nome(),
                produto.value());
    }
}
