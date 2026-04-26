package com.pabloepedro.repository;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ComprasRepo {
    Compras comprar(Compras compra);
    List<Compras> listarCompras();
    Optional<Compras> buscar(String id);
}
