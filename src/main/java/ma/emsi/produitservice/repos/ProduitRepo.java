package ma.emsi.produitservice.repos;

import ma.emsi.produitservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepo extends JpaRepository<Produit, Long> {
}

