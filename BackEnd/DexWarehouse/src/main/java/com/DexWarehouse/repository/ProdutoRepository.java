// ProdutoRepository.java
package com.DexWarehouse.repository;

import com.DexWarehouse.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {}
