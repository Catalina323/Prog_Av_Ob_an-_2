package Proiect;

import static Proiect.Dimensiuni.LARGE;

public class Main {
    public static void main(String[] args) {

        //APLICATIE FLORARIE
        //clasa buchet
        //clasa aranjament (mosteneste buchet)
        //clasa angajat
        //clasa comanda (contine buchete si aranjamente (fac cu agregare)
        //clasa client (contine o lista de comenzi)
        //clasa SERVICIU


        Buchet buchet = new Buchet.Builder("buchet de primavara").withBujori(3).withFrezii(5).withVerdeata().build();
        Buchet buchet2 = new Buchet.Builder("buchet de aniversare").withTrandafiri(5).withHortensii(2).withFrezii(3).withVerdeata().build();

        Client client = new Client("Florete", "Fabian");

        Buchet[] buchete = new Buchet[2];
        buchete[0] = buchet;
        buchete[1] = buchet2;


        Depozit depozit = Depozit.getInstance();
        Contabilitate contabilitate = Contabilitate.getInstance();


        depozit.aprovizioneazaDepozit(10,10,10,10,10,10,10,10,10);
        System.out.println("pret dupa cumpararea stocului " + contabilitate.calculeazaProfit());

        Aranjament aranjament = new Aranjament.Builder("aranjament 1", Dimensiuni.SMALL).withLalele(5).withBujori(3).withVerdeata().build();

        Aranjament[] aranjamente = new Aranjament[1];
        aranjamente[0] = aranjament;

        Comanda comanda2 = new Comanda(aranjamente);

        Comanda comanda = new Comanda(buchete);
        client.plaseazaComanda(comanda);
        client.plaseazaComanda(comanda2);

        System.out.println("pret dupa comanda: " + contabilitate.calculeazaProfit());
        System.out.println(buchet.CalculeazaPretVanzare() - buchet.CalculeazaPretProducere());
        System.out.println(buchet2.CalculeazaPretVanzare() - buchet2.CalculeazaPretProducere());
        System.out.println(aranjament.CalculeazaPretVanzare()-aranjament.CalculeazaPretProducere());

    }
}
