// EstoqueService.java
package com.DexWarehouse.service;

import com.DexWarehouse.model.Produto;
import com.DexWarehouse.model.Lote;
import com.DexWarehouse.model.Insumo;
import com.DexWarehouse.repository.ProdutoRepository;
import com.mongodb.lang.NonNull;
import com.DexWarehouse.repository.InsumoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    private final ProdutoRepository produtoRepository;
    private final InsumoRepository insumoRepository;

    public EstoqueService(ProdutoRepository produtoRepository, InsumoRepository insumoRepository) {
        this.produtoRepository = produtoRepository;
        this.insumoRepository = insumoRepository;
    }

    // Cadastro de lote → decremento automático de insumos
    public Produto cadastrarLote(@NonNull String produtoId, Lote lote) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow();
        produto.getLotes().add(lote);
        produtoRepository.save(produto);

        produto.getInsumosPorUnidade().forEach((insumoNome, qtdPorUnidade) -> {
            Insumo insumo = insumoRepository.findByNome(insumoNome);
            insumo.setQuantidadeAtual(insumo.getQuantidadeAtual() - qtdPorUnidade * lote.getQuantidade());
            insumoRepository.save(insumo);
        });

        return produto;
    }

    // Ajuste manual de insumo
    public void ajustarInsumo(String nome, int ajuste) {
        Insumo insumo = insumoRepository.findByNome(nome);
        insumo.setQuantidadeAtual(insumo.getQuantidadeAtual() + ajuste);
        insumoRepository.save(insumo);
    }
}
