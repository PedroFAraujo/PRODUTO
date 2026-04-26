package com.pabloepedro.produto.repository.mongo;

import com.pabloepedro.produto.repository.orm.ProdutoOrm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepoMongo extends MongoRepository<ProdutoOrm, String> {
}
