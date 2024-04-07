package Proiect;

public class Aranjament extends Buchet{

    private String nume;
    private Dimensiuni dimensiune;

    private int pret;

    public Aranjament(String nume, Dimensiuni dimensiune, int pret) {
        this.nume = nume;
        this.dimensiune = dimensiune;
        this.pret = pret;
    }
}
