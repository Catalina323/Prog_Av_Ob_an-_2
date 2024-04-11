package Proiect;

public class Contabilitate implements PreturiCumparare {

    protected double cheltuieli;
    protected double venituri;

    //SINGLETON PT CONTABILITATE
    private static Contabilitate instance;

    private Contabilitate() {
        this.cheltuieli = 0;
        this.venituri = 1000;
    }

    public static Contabilitate getInstance() {
        if (instance == null ) {
            instance = new Contabilitate();
        }
        return  instance;
    }

    public double calculeazaProfit(){
        return venituri - cheltuieli;
    }

}
