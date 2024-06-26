package Proiect;

import Proiect.DataBaseConfig.CreateTables;
import Proiect.DataBaseConfig.DatabaseConfiguration;
import Proiect.Domain.*;
import Proiect.Repository.AngajatRepository;
import Proiect.Repository.BuchetRepository;
import Proiect.Repository.ClientRepository;
import Proiect.Repository.ComandaRepository;
import Proiect.Service.Serviciu;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//        CreateTables createTables = new CreateTables();
//        createTables.createTableAngajat();
//        createTables.createTableClient();
//        createTables.createTableComanda();
//        createTables.createTableBuchet();
//        createTables.createTableAranjament();
//
//        Angajat angajat1 = new Angajat("Neacsu", "Anamaria", 21, 2500);
//        Angajat angajat2 = new Angajat("Nica", "Catalina", 20, 3500, 2024, 2);
//        Angajat angajat3 = new Angajat("State", "Madalina", 20, 2700, 2023, 5);
//        Angajat angajat4 = new Angajat("Calota", "Ana", 22, 3000, 2023, 6);
        Angajat angajat5 = new Angajat("Zugravu", "Alexandra", 21, 2400);
        AngajatRepository angajatRepository = new AngajatRepository();
//        angajatRepository.insert(angajat2);
//        angajatRepository.insert(angajat3);
//        angajatRepository.insert(angajat4);
        angajatRepository.insert(angajat5);






        //Buchet buchet = new Buchet.Builder("buchet de primavara").withBujori(3).withFrezii(5).withVerdeata().build();
        //Buchet buchet2 = new Buchet.Builder("buchet de aniversare").withTrandafiri(5).withHortensii(2).withFrezii(3).withVerdeata().build();
        Aranjament aranjament = new Aranjament.Builder("aranjament de nunta", Dimensiuni.LARGE).withHortensii(5).withFrezii(8).withTrandafiri(9).withVerdeata().build();
//
//
//        Serviciu serviciu = new Serviciu();
//        serviciu.cumpara_stoc(20);
//        serviciu.setAngajatul_zilei(1);

        //serviciu.afiseaza_stoc();

//        ComandaRepository comandaRepository = new ComandaRepository();
//        Client client = new Client("Florete", "Fabian Andrei");
//        int idClient = serviciu.ClientNou(client);
//
//        int idComanda = serviciu.comanda_aranjamente(idClient, client, aranjament);
//        //int idComanda2 = serviciu.comanda_buchete(idClient, client, buchet);
//        System.out.println(idComanda);
//
//        Optional<Comanda> comanda = comandaRepository.getById(idComanda);
//        System.out.println(comanda);
        //System.out.println(aranjament);

//        serviciu.comanda_aranjamente(client, aranjament);
//
//        serviciu.istoric_comenzi(client);
//
//
//        serviciu.afiseaza_raport_stoc();
//        serviciu.afiseaza_stoc();
//        serviciu.calculeza_bilant();

    }
}
