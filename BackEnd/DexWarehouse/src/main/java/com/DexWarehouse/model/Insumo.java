// Insumo.java
package com.DexWarehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "insumos")
public class Insumo {
    @Id
    private String id;
    private String nome;
    private int quantidadeAtual;
    private int tempoEntrega; // em dias, usado para alerta de compra

    public Insumo() {}

    public Insumo(String nome, int quantidadeAtual, int tempoEntrega) {
        this.nome = nome;
        this.quantidadeAtual = quantidadeAtual;
        this.tempoEntrega = tempoEntrega;
    }

    // Getters e setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getQuantidadeAtual() { return quantidadeAtual; }
    public void setQuantidadeAtual(int quantidadeAtual) { this.quantidadeAtual = quantidadeAtual; }
    public int getTempoEntrega() { return tempoEntrega; }
    public void setTempoEntrega(int tempoEntrega) { this.tempoEntrega = tempoEntrega; }
}
