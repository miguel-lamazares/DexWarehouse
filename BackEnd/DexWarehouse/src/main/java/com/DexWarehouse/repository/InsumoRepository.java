package com.DexWarehouse.repository;

import com.DexWarehouse.model.Insumo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends MongoRepository<Insumo, String> {
}