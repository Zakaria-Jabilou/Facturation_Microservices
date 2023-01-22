package ma.emsi.factureservice;

import ma.emsi.factureservice.entities.Facture;
import ma.emsi.factureservice.entities.ProduitArticle;
import ma.emsi.factureservice.models.Client;
import ma.emsi.factureservice.models.Produit;
import ma.emsi.factureservice.repos.FactureRepo;
import ma.emsi.factureservice.repos.ProduitArticleRepo;
import ma.emsi.factureservice.service.ClientRestClient;
import ma.emsi.factureservice.service.ProduitRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.PagedModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class FactureServiceApplication implements CommandLineRunner {
    ClientRestClient clientRestClient;
    ProduitRestClient produitRestClient;
    FactureRepo factureRepo;
    ProduitArticleRepo produitArticleRepo;

    public FactureServiceApplication(ClientRestClient clientRestClient, ProduitRestClient produitRestClient,
                                     FactureRepo factureRepo, ProduitArticleRepo produitArticleRepo) {
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
        this.factureRepo = factureRepo;
        this.produitArticleRepo = produitArticleRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(FactureServiceApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Client client = clientRestClient.getClientById(1L);
        Facture f = factureRepo.save(new Facture(null, new Date(), null,
                                        client.getId(), client));
        List<Produit> produits = new ArrayList<>();
        PagedModel<Produit> listeProduitsDB = produitRestClient.pageProduit(0,3);
        listeProduitsDB.forEach(p -> {
            ProduitArticle produitArticle = new ProduitArticle();
            produitArticle.setReference(p.getId());
            produitArticle.setProduit(p);
            produitArticle.setNom(p.getNom());
            produitArticle.setQuantite(1 + new Random().nextInt(10));
            produitArticle.setFacture(f);
            produitArticle.setPrix(produitArticle.getQuantite() * p.getPrix());
            produitArticleRepo.save(produitArticle);
        });
    }
}


