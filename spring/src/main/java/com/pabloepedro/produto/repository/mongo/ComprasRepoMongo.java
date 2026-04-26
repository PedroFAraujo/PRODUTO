package com.pabloepedro.produto.repository.mongo;

import com.pabloepedro.produto.repository.orm.ComprasOrm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComprasRepoMongo extends MongoRepository<ComprasOrm, String> {
}
