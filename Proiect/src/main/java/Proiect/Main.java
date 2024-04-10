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

        Buchet[] buchete = new Buchet[1];
        buchete[0] = buchet;

        Buchet[] buchete2 = new Buchet[1];
        buchete2[0] = buchet2;

        //??????????????????????
        //Aranjament aranjament = new Aranjament.Builder("nume").withHortensii(2).build();

        Comanda comanda = new Comanda(buchete);
        //System.out.println(comanda);

        Comanda comanda2 = new Comanda(buchete2);

        //System.out.println(contabilitate.calculeazaProfit());

        Client client = new Client("Florete", "Fabian");
        client.plaseazaComanda(comanda);
        client.plaseazaComanda(comanda2);

        System.out.println(client);

        Contabilitate contabilitate = Contabilitate.getInstance();


        System.out.println(buchet.CalculeazaPretVanzare() - buchet.CalculeazaPretProducere());
        System.out.println(buchet2.CalculeazaPretVanzare());

        System.out.println(contabilitate.calculeazaProfit());

    }
}
