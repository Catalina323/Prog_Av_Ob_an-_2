package Proiect;

import Proiect.Domain.Aranjament;
import Proiect.Domain.Buchet;
import Proiect.Domain.Client;
import Proiect.Domain.Dimensiuni;
import Proiect.Service.Serviciu;

public class Main {
    public static void main(String[] args) {


        Buchet buchet = new Buchet.Builder("buchet de primavara").withBujori(3).withFrezii(5).withVerdeata().build();
        Buchet buchet2 = new Buchet.Builder("buchet de aniversare").withTrandafiri(5).withHortensii(2).withFrezii(3).withVerdeata().build();
        Aranjament aranjament = new Aranjament.Builder("aranjament de nunta", Dimensiuni.LARGE).withHortensii(5).withFrezii(8).withTrandafiri(9).withVerdeata().build();


        Client client = new Client("Florete", "Fabian");

        Serviciu serviciu = new Serviciu();

        serviciu.cumpara_stoc(14);
        serviciu.setAngajatul_zilei(1);

        serviciu.comanda_aranjamente(client, aranjament);
        serviciu.comanda_buchete(client, buchet, buchet2);

        serviciu.istoric_comenzi(client);


        serviciu.afiseaza_raport_stoc();
        serviciu.afiseaza_stoc();
        serviciu.calculeza_bilant();

    }
}
