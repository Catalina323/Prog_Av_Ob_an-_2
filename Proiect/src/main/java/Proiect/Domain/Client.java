package Proiect.Domain;

import java.util.Arrays;

public class Client{

    private String nume;
    private String prenume;
    private Comanda[] istoricComenzi = new Comanda[5];
    private static int nrComenzi;


    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public static int getNrComenzi() {
        return nrComenzi;
    }

    public Client(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrComenzi = 0;
    }
    public Client(String nume, String prenume, int nrComenzi) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrComenzi = nrComenzi;
    }

    public Client(String nume, String prenume, int nrComenzi, Comanda[] istoricComenzi) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrComenzi = nrComenzi;
        this.istoricComenzi = istoricComenzi;
    }

    public void plaseazaComanda(Comanda comanda){
        nrComenzi++;
        istoricComenzi[nrComenzi % 5 - 1] = comanda;
    }

    public Comanda[] getIstoricComenzi(){
        return istoricComenzi;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", istoricComenzi=" + Arrays.toString(istoricComenzi) +
                '}';
    }
}
