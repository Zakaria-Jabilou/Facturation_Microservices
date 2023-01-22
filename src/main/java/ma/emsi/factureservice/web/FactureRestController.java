package ma.emsi.factureservice.web;

import ma.emsi.factureservice.entities.Facture;
import ma.emsi.factureservice.entities.ProduitArticle;
import ma.emsi.factureservice.models.Produit;
import ma.emsi.factureservice.repos.FactureRepo;
import ma.emsi.factureservice.repos.ProduitArticleRepo;
import ma.emsi.factureservice.service.ClientRestClient;
import ma.emsi.factureservice.service.ProduitRestClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FactureRestController {
    FactureRepo factureRepo;
    ClientRestClient clientRestClient;
    ProduitRestClient produitRestClient;
    ProduitArticleRepo produitArticleRepo;
    public FactureRestController(FactureRepo factureRepo, ClientRestClient clientRestClient,
                                 ProduitRestClient produitRestClient, ProduitArticleRepo produitArticleRepo) {
        this.factureRepo = factureRepo;
        this.clientRestClient = clientRestClient;
        this.produitRestClient = produitRestClient;
        this.produitArticleRepo = produitArticleRepo;
    }

    @GetMapping("/factures/{id}")
    public Facture getFacture(@PathVariable Long id){
        Facture facture = factureRepo.findById(id).get();
        facture.setClient(clientRestClient.getClientById(facture.getIdClient()));
        facture.getListeProduits().forEach(produitArticle -> {
            Produit p = produitRestClient.getProduitById(produitArticle.getReference());
            produitArticle.setProduit(p);
        });
        return facture;
    }
    @GetMapping("/factures")
    public List<Facture> getAll(){
        System.out.println("liste factures");
        return factureRepo.findAll();
    }
    @GetMapping("/factures/client/{id}")
    public Facture getclientfarcutre(@PathVariable Long id){
        System.out.println("facture by client");
        return factureRepo.findFactureByIdClient(id);
    }
}
