package Proiect;

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

        System.out.println(buchet);
        System.out.println(buchet.CalculeazaPretProducere());
        System.out.println(buchet.CalculeazaPretVanzare());


        Buchet[] buchete = new Buchet[2];
        buchete[0] = buchet;

        Contabilitate contabilitate = Contabilitate.getInstance();
        System.out.println(contabilitate.calculeazaProfit());

        //Comanda comanda = new Comanda(buchet);

        //Client client = new Client("Florete", "Fabian");
        //client.plaseazaComanda(comanda);

        //System.out.println(client);



    }
}
