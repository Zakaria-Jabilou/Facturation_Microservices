package ma.emsi.produitservice;

import ma.emsi.produitservice.entities.Produit;
import ma.emsi.produitservice.repos.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication


public class ProduitServiceApplication implements CommandLineRunner {
    @Autowired
    ProduitRepo produitRepo;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Produit.class);
        produitRepo.save(new Produit(null,"MacBook Pro M1", 12000.0));
        produitRepo.save(new Produit(null,"MacBook Air M1", 11500.0));
        produitRepo.save(new Produit(null,"MacBook Pro M1 Max", 18000.0));
    }
}
