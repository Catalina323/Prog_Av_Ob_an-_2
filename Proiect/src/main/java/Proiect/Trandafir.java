package Proiect;

public class Trandafir {

    private int pret;
    private Culori culoare;

    public Trandafir(int pret, Culori culoare) {
        this.pret = pret;
        this.culoare = culoare;
    }


    @Override
    public String toString() {
        return "Trandafir{" +
                "pret=" + pret +
                ", culoare=" + culoare +
                '}';
    }

}
