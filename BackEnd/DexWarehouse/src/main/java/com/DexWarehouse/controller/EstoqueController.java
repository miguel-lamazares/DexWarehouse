// EstoqueController.java
package com.DexWarehouse.controller;

import com.DexWarehouse.model.Produto;
import com.DexWarehouse.model.Lote;
import com.DexWarehouse.model.Insumo;
import com.DexWarehouse.repository.ProdutoRepository;
import com.DexWarehouse.repository.InsumoRepository;
import com.DexWarehouse.service.EstoqueService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;
    private final ProdutoRepository produtoRepository;
    private final InsumoRepository insumoRepository;

    public EstoqueController(EstoqueService estoqueService,
                             ProdutoRepository produtoRepository,
                             InsumoRepository insumoRepository) {
        this.estoqueService = estoqueService;
        this.produtoRepository = produtoRepository;
        this.insumoRepository = insumoRepository;
    }

    @PostMapping("/produtos")
    public Produto adicionarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping("/produtos")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @PostMapping("/produtos/{id}/lotes")
    public Produto adicionarLote(@PathVariable String id, @RequestBody Lote lote){
        return estoqueService.cadastrarLote(id, lote);
    }

    @GetMapping("/insumos")
    public List<Insumo> listarInsumos(){
        return insumoRepository.findAll();
    }

    @PostMapping("/insumos/ajustar")
    public void ajustarInsumo(@RequestParam String nome, @RequestParam int ajuste){
        estoqueService.ajustarInsumo(nome, ajuste);
    }
}
