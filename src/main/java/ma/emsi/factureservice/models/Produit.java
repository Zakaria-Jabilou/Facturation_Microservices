package ma.emsi.factureservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Produit {
    private Long id;
    private String nom;
    private Double prix;
}

