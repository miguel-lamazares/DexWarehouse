package com.DexWarehouse.repository;

import com.DexWarehouse.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
    // O Spring Mongo já te dá save, findAll e deleteById pronto.
}