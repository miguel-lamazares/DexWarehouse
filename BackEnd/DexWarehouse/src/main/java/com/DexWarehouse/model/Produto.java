package com.DexWarehouse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;

class Lote {
    private String idLote;
    private int quantidade;
    private LocalDate dataValidade;
    private String sabor; // ou característica
}

@Document(collection = "produtos")
public class Produto {
    @Id
    private String id;
    private String nome;
    private String descricao;
    private String fotoUrl; // link para a imagem
    private List<Lote> lotes; // lista de lotes associados
    private List<String> caracteristicas; // ex: sabores
    private Map<String, Integer> insumosPorUnidade; // ex: {"tampa":1, "garrafa":1, "rotulo":1}
}




