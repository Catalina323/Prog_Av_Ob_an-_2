package Proiect;

public class Angajat {

    private String nume;
    private String prenume;
    private int varsta;
    private float salariu;

    public Angajat(String nume, String prenume, int varsta, float salariu) {
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
                '}';
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

    public float getSalariu() {
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

    public void setSalariu(float salariu) {
        this.salariu = salariu;
    }
}
