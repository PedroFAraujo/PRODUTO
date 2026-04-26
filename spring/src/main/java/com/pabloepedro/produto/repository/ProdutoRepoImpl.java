package com.pabloepedro.produto.repository;

import com.pabloepedro.entity.Compras;
import com.pabloepedro.entity.Produto;
import com.pabloepedro.produto.repository.adapter.ComprsRepoAdp;
import com.pabloepedro.produto.repository.adapter.ProdutoRepoAdp;
import com.pabloepedro.produto.repository.mongo.ProdutoRepoMongo;
import com.pabloepedro.produto.repository.orm.ComprasOrm;
import com.pabloepedro.produto.repository.orm.ProdutoOrm;
import com.pabloepedro.repository.ProdutoRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepoImpl implements ProdutoRepo {

    private final ProdutoRepoMongo repo;

    public ProdutoRepoImpl(ProdutoRepoMongo repo){
        this.repo = repo;
    }

    @Override
    public Produto cadastro(Produto produto) {
        ProdutoOrm orm = ProdutoRepoAdp.castEntity(produto);
        ProdutoOrm ormSave = repo.save(orm);
        return ProdutoRepoAdp.castOrm(ormSave);
    }

    @Override
    public Optional<Produto> buscar(String id) {
        Optional<ProdutoOrm> orm = repo.findById(id);

        if(orm.isPresent()){
            Produto produto = ProdutoRepoAdp.castOrm(orm.get());
            return Optional.of(produto);
        }
        return Optional.empty();
    }

    @Override
    public List<Produto> listar(){
        List<ProdutoOrm> listaOrm = repo.findAll();
        return listaOrm.stream().map(ProdutoRepoAdp::castOrm).toList();
    }

    @Override public void deletar(String id){
        repo.deleteById(id);
    }
}
