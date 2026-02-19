// Lote.java
package com.DexWarehouse.model;

import java.time.LocalDate;

public class Lote {
    private String idLote;
    private int quantidade;
    private LocalDate dataValidade;
    private String sabor;

    public Lote() {}

    public Lote(int quantidade, LocalDate dataValidade, String sabor) {
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        this.sabor = sabor;
    }

    // Getters e setters
    public String getIdLote() { return idLote; }
    public void setIdLote(String idLote) { this.idLote = idLote; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public LocalDate getDataValidade() { return dataValidade; }
    public void setDataValidade(LocalDate dataValidade) { this.dataValidade = dataValidade; }
    public String getSabor() { return sabor; }
    public void setSabor(String sabor) { this.sabor = sabor; }
}
