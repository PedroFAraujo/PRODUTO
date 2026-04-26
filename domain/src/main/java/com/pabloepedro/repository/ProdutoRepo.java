package com.pabloepedro.repository;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepo {
    Produto cadastro(Produto produto);
    Optional<Produto> buscar(String id);
    List<Produto> listar();
    void deletar(String id);
}
