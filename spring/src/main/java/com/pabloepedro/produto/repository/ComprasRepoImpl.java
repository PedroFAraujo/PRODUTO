package com.pabloepedro.produto.repository;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.produto.controller.adapter.ComprasCtrlAdp;
import com.pabloepedro.produto.repository.adapter.ComprsRepoAdp;
import com.pabloepedro.produto.repository.mongo.ComprasRepoMongo;
import com.pabloepedro.produto.repository.orm.ComprasOrm;
import com.pabloepedro.repository.ComprasRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComprasRepoImpl implements ComprasRepo {

    private final ComprasRepoMongo repo;

    public ComprasRepoImpl(ComprasRepoMongo repo){
        this.repo = repo;
    }

    @Override
    public Compras comprar(Compras compras) {
        ComprasOrm orm = ComprsRepoAdp.castEntity(compras);
        ComprasOrm ormSave = repo.save(orm);
        return ComprsRepoAdp.castOrm(ormSave);
    }

    @Override
    public Optional<Compras> buscar(String id) {
        Optional<ComprasOrm> orm = repo.findById(id);

        if(orm.isPresent()){
            Compras compras = ComprsRepoAdp.castOrm(orm.get());
            return Optional.of(compras);
        }
        return Optional.empty();
    }

    @Override
    public List<Compras> listarCompras(){
        List<ComprasOrm> listaOrm = repo.findAll();
        return listaOrm.stream().map(ComprsRepoAdp::castOrm).toList();
    }


}
