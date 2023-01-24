package ma.emsi.clientservice.repos;

import ma.emsi.clientservice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ClientRepo extends JpaRepository<Client, Long> {
}
