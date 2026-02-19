package com.DexWarehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "insumos")
public class Insumo {
    @Id
    private String id;
    private String nome;
    private int quantidadeAtual;
    private int tempoEntrega; // em dias
    private double valorUnitario;
    private double margemSeguranca; // percentual, tipo 0.2 para 20%
    
    // Getters e setters
}
