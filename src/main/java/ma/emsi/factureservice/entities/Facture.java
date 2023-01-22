package ma.emsi.factureservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.factureservice.models.Client;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateFature;
    @OneToMany(mappedBy = "facture")
    private Collection<ProduitArticle> listeProduits;
    private Long idClient;
    @Transient
    private Client client;
}

