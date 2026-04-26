package com.pabloepedro.produto.controller.adapter;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.produto.controller.dto.request.ComprasRequest;
import com.pabloepedro.produto.controller.dto.response.ComprasResponse;

import java.util.UUID;

public class ComprasCtrlAdp {
    private ComprasCtrlAdp(){}

    public static Compras castRequest(ComprasRequest request){
        return new Compras(
                UUID.randomUUID().toString(),
                request.clientId(),
                request.itens(),
                request.valor()
        );
    }

    public static ComprasResponse castResponse(Compras compras){
        return new ComprasResponse(
                compras.id(),
                compras.clientId(),
                compras.itens(),
                compras.valorTotal()
        );
    }
}
