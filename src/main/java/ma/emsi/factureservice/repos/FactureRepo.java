package ma.emsi.factureservice.repos;

import ma.emsi.factureservice.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FactureRepo extends JpaRepository<Facture,Long> {
    Facture findFactureByIdClient(Long id);
}

