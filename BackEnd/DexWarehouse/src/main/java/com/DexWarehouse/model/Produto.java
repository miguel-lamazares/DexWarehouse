// Produto.java
package com.DexWarehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.Map;

@Document(collection = "produtos")
public class Produto {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String fotoUrl;
    private List<Lote> lotes;
    private Map<String, Integer> insumosPorUnidade; // ex: {"garrafa":1, "tampa":1, "rotulo":1}

    public Produto() {}

    public Produto(String nome, String descricao, String fotoUrl, Map<String,Integer> insumosPorUnidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.fotoUrl = fotoUrl;
        this.insumosPorUnidade = insumosPorUnidade;
    }

    // Getters e setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }
    public List<Lote> getLotes() { return lotes; }
    public void setLotes(List<Lote> lotes) { this.lotes = lotes; }
    public Map<String, Integer> getInsumosPorUnidade() { return insumosPorUnidade; }
    public void setInsumosPorUnidade(Map<String, Integer> insumosPorUnidade) { this.insumosPorUnidade = insumosPorUnidade; }
}
