// InsumoRepository.java
package com.DexWarehouse.repository;

import com.DexWarehouse.model.Insumo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InsumoRepository extends MongoRepository<Insumo, String> {
    Insumo findByNome(String nome);
}
