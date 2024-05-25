package Proiect.Domain;

import java.util.Arrays;

public class Client{

    private String nume;
    private String prenume;
    private Comanda[] istoricComenzi = new Comanda[5];

    private static int nrComenzi;

    public Client(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrComenzi = 0;
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
