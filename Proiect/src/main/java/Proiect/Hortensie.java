package Proiect;

public class Hortensie {

    private int pret;
    private Culori culoare;

    public Hortensie(int pret, Culori culoare) {
        this.pret = pret;
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Hortensie{" +
                "pret=" + pret +
                ", culoare=" + culoare +
                '}';
    }




}
