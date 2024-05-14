package org.sid.springsecurity;

import org.sid.springsecurity.bean.notification.NotificationReservation;
import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.appartementBean.CategoriesAppartement;
import org.sid.springsecurity.bean.appartementBean.AgenceAppartement;
import org.sid.springsecurity.bean.communBean.Client;
import org.sid.springsecurity.bean.voitureBean.AgenceLocation;
import org.sid.springsecurity.bean.voitureBean.CategorieVoiture;
import org.sid.springsecurity.security.bean.AppRole;
import org.sid.springsecurity.security.bean.AppUser;
import org.sid.springsecurity.security.service.AccountService;
import org.sid.springsecurity.service.facade.NotifiactionReservationService;
import org.sid.springsecurity.service.facade.appartementService.AppartementService;
import org.sid.springsecurity.service.facade.appartementService.CategoriesAppartementService;
import org.sid.springsecurity.service.facade.appartementService.AgenceAppartementService;
import org.sid.springsecurity.service.facade.communService.ClientService;
import org.sid.springsecurity.service.facade.voitureService.AgenceLocationService;
import org.sid.springsecurity.service.facade.voitureService.CategorieVoitureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class SafarentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafarentApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    // @Bean
    CommandLineRunner start(AccountService accountService,
                            CategoriesAppartementService categoriesAppartementService,
                            CategorieVoitureService categorieVoitureService,
                            AgenceAppartementService agenceAppartementService,
                            AgenceLocationService agenceLocationService,
                            ClientService clientService,
                            NotifiactionReservationService notifiactionReservationService,
                            AppartementService appartementService
                            ){
        return args -> {
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"MANAGER-APT"));
            accountService.addNewRole(new AppRole(null,"MANAGER-VOI"));
            accountService.addNewRole(new AppRole(null,"USER"));

            accountService.addNewUser(new AppUser(null,"admin","admin",new ArrayList<>()));


            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","MANAGER-APT");
            accountService.addRoleToUser("admin","MANAGER-VOI");
            accountService.addRoleToUser("admin","USER");


            CategoriesAppartement categoriesAppartement1=new CategoriesAppartement("villa");
            CategoriesAppartement categoriesAppartement2=new CategoriesAppartement("appartemet");
            CategoriesAppartement categoriesAppartement3=new CategoriesAppartement("petite appartemet");
            CategoriesAppartement categoriesAppartement4=new CategoriesAppartement("petite ville");

            categoriesAppartementService.save(categoriesAppartement1);
            categoriesAppartementService.save(categoriesAppartement2);
            categoriesAppartementService.save(categoriesAppartement3);
            categoriesAppartementService.save(categoriesAppartement4);


            CategorieVoiture categorieVoiture1=new CategorieVoiture("BMW");
            CategorieVoiture categorieVoiture2=new CategorieVoiture("dacia");
            CategorieVoiture categorieVoiture3=new CategorieVoiture("porsh");

            categorieVoitureService.save(categorieVoiture1);
            categorieVoitureService.save(categorieVoiture2);
            categorieVoitureService.save(categorieVoiture3);


            AgenceAppartement agenceAppartement1 = new AgenceAppartement("mohammed.p", "123", 123456789L, "ImmoGestion SA", "+1234567890", "contact@immogestion.com", "10 Rue des Appartements", 987654321, 1234567890123456789L, 987654321L);
            AgenceAppartement agenceAppartement2 = new AgenceAppartement("ismail.p", "123", 987654321L, "City Apartments Agency", "+9876543210", "info@cityapartments.com", "20 Avenue des Résidences", 1230987654, 1468013579246801357L, 123456789L);
            AgenceAppartement agenceAppartement3 = new AgenceAppartement("abdelilah.p", "123", 246810975L, "Sunset Realty Services", "+1122334455", "info@sunsetrealty.com", "30 Boulevard du Soleil", 1357924680, 2468013579246801357L, 987654321L);
            AgenceAppartement agenceAppartement4 = new AgenceAppartement("abderrahmane.p", "123", 555555555L, "Prime Properties Group", "+9999999999", "contact@primeproperties.com", "40 Place du Luxe", 444444444, 5555555555444444444L, 111111111L);

            agenceAppartementService.save(agenceAppartement1);
            agenceAppartementService.save(agenceAppartement2);
            agenceAppartementService.save(agenceAppartement3);
            agenceAppartementService.save(agenceAppartement4);



            AgenceLocation agenceLocation1 = new AgenceLocation(
                    "mohammed.a",
                    "123",
                    12345L,
                    "Agence XYZ",
                    "123 Main Street",
                    "123-456-7890",
                    987654321,
                    123456789012L,
                    987654L
            );

            AgenceLocation agenceLocation2 = new AgenceLocation(
                    "ismail.a",
                    "123",
                    12346L,
                    "Agence XYZ",
                    "123 Main Street",
                    "123-456-7890",
                    987654321,
                    123456789012L,
                    987654L
            );

            AgenceLocation agenceLocation3 = new AgenceLocation(
                    "abdelilah.a",
                    "123",
                    12347L,
                    "Agence XYZ",
                    "123 Main Street",
                    "123-456-7890",
                    987654321,
                    123456789012L,
                    987654L
            );

            AgenceLocation agenceLocation4 = new AgenceLocation(
                    "abderrahmane.a",
                    "123",
                    12348L,
                    "Agence XYZ",
                    "123 Main Street",
                    "123-456-7890",
                    987654321,
                    123456789012L,
                    987654L
            );

            agenceLocationService.save(agenceLocation1);
            agenceLocationService.save(agenceLocation2);
            agenceLocationService.save(agenceLocation3);
            agenceLocationService.save(agenceLocation4);






            Client client1 = new Client(
                    "mohammed.c",
                    "123",
                    "EE43434",
                    "John",
                    "Doe",
                    "123-456-7890",
                    "john@example.com");

            Client client2 = new Client(
                    "ismail.c",
                    "123",
                    "EE09090",
                    "John",
                    "Doe",
                    "123-456-7890",
                    "john@example.com");
            Client client3 = new Client(
                    "abdelilah.c",
                    "123",
                    "CC52525",
                    "John",
                    "Doe",
                    "123-456-7890",
                    "john@example.com");
            Client client4 = new Client(
                    "abderrahmane.c",
                    "123",
                    "CC09090",
                    "John",
                    "Doe",
                    "123-456-7890",
                    "john@example.com");

            clientService.save(client1);
            clientService.save(client2);
            clientService.save(client3);
            clientService.save(client4);


            NotificationReservation notification1 = new NotificationReservation(
                    1L,
                    "CODE001",
                    "1234567890",
                    "John Doe",
                    "ABC123",
                    "APP001",
                    "ICE123",
                    "0987654321",
                    new Date(),
                    true
            );

            // Example 2
            NotificationReservation notification2 = new NotificationReservation(
                    2L,
                    "CODE002",
                    "0987654321",
                    "Jane Smith",
                    "XYZ789",
                    "APP002",
                    "ICE456",
                    "1357902468",
                    new Date(),
                    true
            );

            // Example 3
            NotificationReservation notification3 = new NotificationReservation(
                    3L,
                    "CODE003",
                    "1357902468",
                    "Alice Johnson",
                    "DEF456",
                    "APP003",
                    "ICE789",
                    "2468013579",
                    new Date(),
                    true
            );

            // Example 4
            NotificationReservation notification4 = new NotificationReservation(
                    4L,
                    "CODE004",
                    "2468013579",
                    "Bob Williams",
                    "GHI789",
                    "APP004",
                    "ICE012",
                    "3579124680",
                    new Date(),
                    true
            );

            notifiactionReservationService.save(notification1);
            notifiactionReservationService.save(notification2);
            notifiactionReservationService.save(notification3);
            notifiactionReservationService.save(notification4);





            Appartement appartement11 = new Appartement(
                    1L,
                    "APP0011",
                    100,
                    "123 Main Street",
                    "City A",
                    "Yes",
                    4,
                    "Yes",
                    1000.0,
                    new ArrayList<>(),
                    categoriesAppartement1,
                    agenceAppartement1,
                    new HashSet<>()
            );
            Appartement appartement12 = new Appartement(
                    2L,
                    "APP0012",
                    100,
                    "123 Main Street",
                    "City A",
                    "Yes",
                    4,
                    "Yes",
                    1000.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            Appartement appartement13 = new Appartement(
                    3L,
                    "APP0013",
                    100,
                    "123 Main Street",
                    "City A",
                    "Yes",
                    4,
                    "Yes",
                    1000.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            Appartement appartement14 = new Appartement(
                    4L,
                    "APP0014",
                    100,
                    "123 Main Street",
                    "City A",
                    "Yes",
                    4,
                    "Yes",
                    1000.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );


            appartementService.save(appartement11);
            appartementService.save(appartement12);
            appartementService.save(appartement13);
            appartementService.save(appartement14);


            // Example 2
            Appartement appartement21 = new Appartement(
                    5L,
                    "APP0021",
                    120,
                    "456 Elm Street",
                    "City B",
                    "Yes",
                    6,
                    "No",
                    1200.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            Appartement appartement22 = new Appartement(
                    6L,
                    "APP0022",
                    120,
                    "456 Elm Street",
                    "City B",
                    "Yes",
                    6,
                    "No",
                    1200.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            Appartement appartement23 = new Appartement(
                    5L,
                    "APP0023",
                    120,
                    "456 Elm Street",
                    "City B",
                    "Yes",
                    6,
                    "No",
                    1200.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            Appartement appartement24 = new Appartement(
                    6L,
                    "APP0024",
                    120,
                    "456 Elm Street",
                    "City B",
                    "Yes",
                    6,
                    "No",
                    1200.0,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            appartementService.save(appartement21);
            appartementService.save(appartement22);
            appartementService.save(appartement23);
            appartementService.save(appartement24);



            // Example 3
            Appartement appartement31 = new Appartement(
                    7L,
                    "APP0031",
                    80,
                    "789 Oak Street",
                    "City C",
                    "No",
                    2,
                    "Yes",
                    800.0,
                    new ArrayList<>(),
                    categoriesAppartement3,
                    agenceAppartement3,
                    new HashSet<>()
            );
            Appartement appartement32 = new Appartement(
                    8L,
                    "APP0032",
                    80,
                    "789 Oak Street",
                    "City C",
                    "No",
                    2,
                    "Yes",
                    800.0,
                    new ArrayList<>(),
                    categoriesAppartement3,
                    agenceAppartement3,
                    new HashSet<>()
            );

            Appartement appartement33 = new Appartement(
                    9L,
                    "APP0033",
                    80,
                    "789 Oak Street",
                    "City C",
                    "No",
                    2,
                    "Yes",
                    800.0,
                    new ArrayList<>(),
                    categoriesAppartement3,
                    agenceAppartement3,
                    new HashSet<>()
            );
            Appartement appartement34 = new Appartement(
                    10L,
                    "APP0034",
                    80,
                    "789 Oak Street",
                    "City C",
                    "No",
                    2,
                    "Yes",
                    800.0,
                    new ArrayList<>(),
                    categoriesAppartement3,
                    agenceAppartement3,
                    new HashSet<>()
            );

            appartementService.save(appartement31);
            appartementService.save(appartement32);
            appartementService.save(appartement33);
            appartementService.save(appartement34);


            // Example 4
            Appartement appartement41 = new Appartement(
                    11L,
                    "APP0041",
                    150,
                    "321 Maple Street",
                    "City D",
                    "Yes",
                    8,
                    "Yes",
                    1500.0,
                    new ArrayList<>(),
                    categoriesAppartement4,
                    agenceAppartement4,
                    new HashSet<>()
            );
            Appartement appartement42 = new Appartement(
                    12L,
                    "APP0042",
                    150,
                    "321 Maple Street",
                    "City D",
                    "Yes",
                    8,
                    "Yes",
                    1500.0,
                    new ArrayList<>(),
                    categoriesAppartement4,
                    agenceAppartement4,
                    new HashSet<>()
            );
            Appartement appartement43 = new Appartement(
                    13L,
                    "APP0043",
                    150,
                    "321 Maple Street",
                    "City D",
                    "Yes",
                    8,
                    "Yes",
                    1500.0,
                    new ArrayList<>(),
                    categoriesAppartement4,
                    agenceAppartement4,
                    new HashSet<>()
            );
            Appartement appartement44 = new Appartement(
                    14L,
                    "APP0044",
                    150,
                    "321 Maple Street",
                    "City D",
                    "Yes",
                    8,
                    "Yes",
                    1500.0,
                    new ArrayList<>(),
                    categoriesAppartement4,
                    agenceAppartement4,
                    new HashSet<>()
            );


            appartementService.save(appartement41);
            appartementService.save(appartement42);
            appartementService.save(appartement43);
            appartementService.save(appartement44);
        };

    }

}
