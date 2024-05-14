package org.sid.springsecurity;

import org.sid.springsecurity.bean.communBean.*;
import org.sid.springsecurity.bean.notification.NotificationReservation;
import org.sid.springsecurity.bean.appartementBean.Appartement;
import org.sid.springsecurity.bean.appartementBean.CategoriesAppartement;
import org.sid.springsecurity.bean.appartementBean.AgenceAppartement;
import org.sid.springsecurity.bean.voitureBean.AgenceLocation;
import org.sid.springsecurity.bean.voitureBean.CategorieVoiture;
import org.sid.springsecurity.bean.voitureBean.Voiture;
import org.sid.springsecurity.security.bean.AppRole;
import org.sid.springsecurity.security.bean.AppUser;
import org.sid.springsecurity.security.service.AccountService;
import org.sid.springsecurity.service.facade.NotifiactionReservationService;
import org.sid.springsecurity.service.facade.appartementService.AppartementService;
import org.sid.springsecurity.service.facade.appartementService.CategoriesAppartementService;
import org.sid.springsecurity.service.facade.appartementService.AgenceAppartementService;
import org.sid.springsecurity.service.facade.communService.*;
import org.sid.springsecurity.service.facade.voitureService.AgenceLocationService;
import org.sid.springsecurity.service.facade.voitureService.CategorieVoitureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

     @Bean
    CommandLineRunner start(AccountService accountService,
                            CategoriesAppartementService categoriesAppartementService,
                            CategorieVoitureService categorieVoitureService,
                            AgenceAppartementService agenceAppartementService,
                            AgenceLocationService agenceLocationService,
                            ClientService clientService,
                            NotifiactionReservationService notifiactionReservationService,
                            AppartementService appartementService,
                            ReservationService reserVationService,
                            LocationService locationService,
                            PaiementService paiementService,
                            FactureService factureService,
                            ContratService contratService
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




            //appartementBean

            CategoriesAppartement categoriesAppartement1=new CategoriesAppartement("villa");
            CategoriesAppartement categoriesAppartement2=new CategoriesAppartement("appartemet");
            CategoriesAppartement categoriesAppartement3=new CategoriesAppartement("petite appartemet");
            CategoriesAppartement categoriesAppartement4=new CategoriesAppartement("petite ville");

            categoriesAppartementService.save(categoriesAppartement1);
            categoriesAppartementService.save(categoriesAppartement2);
            categoriesAppartementService.save(categoriesAppartement3);
            categoriesAppartementService.save(categoriesAppartement4);


            AgenceAppartement agenceAppartement1 = new AgenceAppartement("mohammed.p", "123", 123456789L, "ImmoGestion SA", "+1234567890", "contact@immogestion.com", "10 Rue des Appartements", 987654321, 1234567890123456789L, 987654321L);
            AgenceAppartement agenceAppartement2 = new AgenceAppartement("ismail.p", "123", 987654321L, "City Apartments Agency", "+9876543210", "info@cityapartments.com", "20 Avenue des Résidences", 1230987654, 1468013579246801357L, 123456789L);
            AgenceAppartement agenceAppartement3 = new AgenceAppartement("abdelilah.p", "123", 246810975L, "Sunset Realty Services", "+1122334455", "info@sunsetrealty.com", "30 Boulevard du Soleil", 1357924680, 2468013579246801357L, 987654321L);
            AgenceAppartement agenceAppartement4 = new AgenceAppartement("abderrahmane.p", "123", 555555555L, "Prime Properties Group", "+9999999999", "contact@primeproperties.com", "40 Place du Luxe", 444444444, 5555555555444444444L, 111111111L);

            agenceAppartementService.save(agenceAppartement1);
            agenceAppartementService.save(agenceAppartement2);
            agenceAppartementService.save(agenceAppartement3);
            agenceAppartementService.save(agenceAppartement4);




            Appartement appartement1 = new Appartement(
                    "APT001",
                    100,
                    "123 Rue de Paris",
                    "Marrakech",
                    "Oui",
                    4,
                    "Oui",
                    1200.00,
                    new ArrayList<>(),
                    categoriesAppartement1,
                    agenceAppartement1,
                    new HashSet<>()
            );
            Appartement appartement2 = new Appartement(
                    "APT0012",
                    100,
                    "123 Rue de Paris",
                    "Fes",
                    "Oui",
                    4,
                    "Oui",
                    1200.00,
                    new ArrayList<>(),
                    categoriesAppartement2,
                    agenceAppartement2,
                    new HashSet<>()
            );
            Appartement appartement3 = new Appartement(
                    "APT00123",
                    100,
                    "123 Rue de Paris",
                    "Zagora",
                    "Oui",
                    4,
                    "Oui",
                    1200.00,
                    new ArrayList<>(),
                    categoriesAppartement3,
                    agenceAppartement3,
                    new HashSet<>()
            );
            Appartement appartement4 = new Appartement(
                    "APT00124",
                    100,
                    "123 Rue de Paris",
                    "Asafai",
                    "Oui",
                    4,
                    "Oui",
                    1200.00,
                    new ArrayList<>(),
                    categoriesAppartement4,
                    agenceAppartement4,
                    new HashSet<>()
            );

            appartementService.save(appartement1);
            appartementService.save(appartement2);
            appartementService.save(appartement3);
            appartementService.save(appartement4);


            Appartement appartement11 = new Appartement(
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



//**********************************************************************************************
            //communBean
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


            Reservation reservation1 = new Reservation(
                    "REF001",
                    LocalDate.of(2024, 5, 20),
                    LocalTime.of(10, 0),
                    LocalDate.of(2024, 5, 25),
                    LocalTime.of(12, 0),
                    "Adresse de prise 1",
                    "Adresse de retour 1",
                    "Description de la réservation 1",
                    null,
                    client1,
                    null,
                    appartement1
            );


            Reservation reservation2 = new Reservation(
                    "REF002",
                    LocalDate.of(2024, 6, 10),
                    LocalTime.of(9, 30),
                    LocalDate.of(2024, 6, 15),
                    LocalTime.of(11, 30),
                    "Adresse de prise 2",
                    "Adresse de retour 2",
                    "Description de la réservation 2",
                    null,
                    client2,
                    null,
                    appartement2
            );

            Reservation reservation3 = new Reservation(
                    "REF003",
                    LocalDate.of(2024, 7, 1),
                    LocalTime.of(14, 0),
                    LocalDate.of(2024, 7, 6),
                    LocalTime.of(16, 0),
                    "Adresse de prise 3",
                    "Adresse de retour 3",
                    "Description de la réservation 3",
                    null,
                    client3,
                    null,
                    appartement3
            );

            Reservation reservation4 = new Reservation(
                    "REF004",
                    LocalDate.of(2024, 8, 5),
                    LocalTime.of(8, 0),
                    LocalDate.of(2024, 8, 10),
                    LocalTime.of(10, 0),
                    "Adresse de prise 4",
                    "Adresse de retour 4",
                    "Description de la réservation 4",
                    null,
                    client4,
                    null,
                    appartement4
            );


            reserVationService.save(reservation1);
            reserVationService.save(reservation2);
            reserVationService.save(reservation3);
            reserVationService.save(reservation4);


            Location location1 = new Location(
                    "LOC001",
                    LocalDateTime.of(2024, 5, 20, 8, 0),
                    LocalDateTime.of(2024, 5, 25, 10, 0),
                    null,
                    null,
                    reservation1
            );
            Location location2 = new Location(
                    "LOC002",
                    LocalDateTime.of(2024, 6, 10, 9, 0),
                    LocalDateTime.of(2024, 6, 15, 11, 0),
                    null,
                    null,
                    reservation2
            );

            Location location3 = new Location(
                    "LOC003",
                    LocalDateTime.of(2024, 7, 1, 14, 0),
                    LocalDateTime.of(2024, 7, 6, 16, 0),
                    null,
                    null,
                    reservation3
            );

            Location location4 = new Location(
                    "LOC004",
                    LocalDateTime.of(2024, 8, 5, 8, 0),
                    LocalDateTime.of(2024, 8, 10, 10, 0),
                    null,
                    null,
                    reservation4
            );

            locationService.save(location1);
            locationService.save(location2);
            locationService.save(location3);
            locationService.save(location4);



            LocalDateTime datePaiement1 = LocalDateTime.of(2024, 5, 10, 14, 30);
            Long ribClient1 = 123456789012L;

            Paiement paiement1 = new Paiement("PAY001", datePaiement1, ribClient1, null, agenceAppartement1, null);
            Paiement paiement2 = new Paiement("PAY002", datePaiement1, ribClient1, null, agenceAppartement1, null);
            Paiement paiement3 = new Paiement("PAY003", datePaiement1, ribClient1, null, agenceAppartement1, null);
            Paiement paiement4 = new Paiement("PAY004", datePaiement1, ribClient1, null, agenceAppartement1, null);

            paiementService.save(paiement1);
            paiementService.save(paiement2);
            paiementService.save(paiement3);
            paiementService.save(paiement4);

            LocalDateTime dateFacture1 = LocalDateTime.of(2024, 5, 10, 15, 0);
            double montantTotal1 = 1500.00;
            Facture facture1 = new Facture("FAC001", dateFacture1, montantTotal1, location1, paiement1);
            Facture facture2 = new Facture("FAC002", dateFacture1, montantTotal1, location2, paiement2);
            Facture facture3 = new Facture("FAC003", dateFacture1, montantTotal1, location3, paiement3);
            Facture facture4 = new Facture("FAC004", dateFacture1, montantTotal1, location4, paiement4);

            factureService.save(facture1);
            factureService.save(facture2);
            factureService.save(facture3);
            factureService.save(facture4);



            float prixHT2 = 2000.00f;
            float tva2 = 20.00f;
            String modelePaiement2 = "Virement bancaire";
            int dureeRetard2 = 10;
            LocalDateTime dateSignature2 = LocalDateTime.of(2024, 5, 15, 11, 0);
            float rest2 = 800.00f;
            Contrat contrat1 = new Contrat(10021, prixHT2, tva2, modelePaiement2, dureeRetard2, dateSignature2, rest2, location1);
            Contrat contrat2 = new Contrat(10022, prixHT2, tva2, modelePaiement2, dureeRetard2, dateSignature2, rest2, location2);
            Contrat contrat3 = new Contrat(10023, prixHT2, tva2, modelePaiement2, dureeRetard2, dateSignature2, rest2, location3);
            Contrat contrat4 = new Contrat(10024, prixHT2, tva2, modelePaiement2, dureeRetard2, dateSignature2, rest2, location4);

            contratService.save(contrat1);
            contratService.save(contrat2);
            contratService.save(contrat3);
            contratService.save(contrat4);


            //voitureBean
            CategorieVoiture categorieVoiture1=new CategorieVoiture("BMW");
            CategorieVoiture categorieVoiture2=new CategorieVoiture("dacia");
            CategorieVoiture categorieVoiture3=new CategorieVoiture("porsh");

            categorieVoitureService.save(categorieVoiture1);
            categorieVoitureService.save(categorieVoiture2);
            categorieVoitureService.save(categorieVoiture3);


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
        };








     }

}
