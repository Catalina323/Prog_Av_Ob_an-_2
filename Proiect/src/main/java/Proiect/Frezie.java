package Proiect;

public class Frezie {

    private int pret;
    private Culori culoare;

    public Frezie(int pret, Culori culoare) {
        this.pret = pret;
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Frezie{" +
                "pret=" + pret +
                ", culoare=" + culoare +
                '}';
    }


}
