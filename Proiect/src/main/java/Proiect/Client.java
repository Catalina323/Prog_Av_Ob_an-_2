package Proiect;

public class Client{

    private String nume;
    private String prenume;
    private Comanda[] istoricComanzi = new Comanda[5];

    private static int nrComenzi;

    public Client(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrComenzi = 0;
    }

    public void plaseazaComanda(Comanda comanda){
        nrComenzi++;
        istoricComanzi[nrComenzi % 5] = comanda;
    }


}
