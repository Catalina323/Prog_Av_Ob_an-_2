package Proiect.Domain;

public class Angajat implements Comparable<Angajat>{

    private String nume;
    private String prenume;
    private int varsta;
    private int salariu;
    private Data data_angajare;



    public Angajat(String nume, String prenume, int varsta, int salariu, int an, int luna) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.salariu = salariu;
        this.data_angajare = new Data(luna, an);
    }

    //constructor fara data
    public Angajat(String nume, String prenume, int varsta, int salariu) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", salariu=" + salariu +
                ", data_angajare=" + data_angajare +
                '}';
    }

    public Data getData_angajare() {
        return data_angajare;
    }

    public void setData_angajare(Data data_angajare) {
        this.data_angajare = data_angajare;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    @Override
    public int compareTo(Angajat o) {
        return this.salariu - o.salariu;
    }
}
