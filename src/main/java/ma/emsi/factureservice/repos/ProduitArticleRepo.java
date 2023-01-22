package ma.emsi.factureservice.repos;

import ma.emsi.factureservice.entities.Facture;
import ma.emsi.factureservice.entities.ProduitArticle;
import ma.emsi.factureservice.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProduitArticleRepo  extends JpaRepository<ProduitArticle, Long> {
    List<Produit> findByFactureId(Long id);

}



