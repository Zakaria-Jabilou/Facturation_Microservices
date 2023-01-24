package ma.emsi.clientservice;

import ma.emsi.clientservice.entities.Client;
import ma.emsi.clientservice.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication implements CommandLineRunner {

    @Autowired
    ClientRepo clientRepo;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        clientRepo.save(new Client(null, "Ahmed", "ahmed@client.ma"));
        clientRepo.save(new Client(null, "Mohamed", "mohamed@client.ma"));
        clientRepo.save(new Client(null, "Mahmoud", "mahmoud@client.ma"));
    }
}
