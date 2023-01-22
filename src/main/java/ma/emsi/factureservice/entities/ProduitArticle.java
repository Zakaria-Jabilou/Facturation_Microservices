package ma.emsi.factureservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.factureservice.models.Produit;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ProduitArticle {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long reference;
    private int quantite;
    private double prix;
    private String nom;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Facture facture;
    @Transient
    private Produit produit;
}
