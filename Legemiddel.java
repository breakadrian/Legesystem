import java.util.concurrent.atomic.AtomicInteger;

class Legemiddel {
    String navn;
    double pris;
    double virkestoff;
    static final AtomicInteger idGenerator = new AtomicInteger(0);
    int id;
    String farge;
    String type;
    int styrke;

    public Legemiddel(String navn, double pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        this.id = idGenerator.getAndIncrement();
    }

    public int hentId() {
        return id;
    }

    public String hentNavn() {
        return navn;
    }

    public double hentPris() {
        return pris;
    }

    public double hentVirkestoff() {
        return virkestoff;
    }

    public void settNyPris(double nyPris) {
        this.pris = nyPris;
    }

    public String farge() {
        return farge;
    }

    public String hentType() {
        return type;
    }

    public int hentStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" + "Navn: " + navn + "\n" + "Pris: " + pris + "\n" + "Virkestoff: " + virkestoff;

    }

}
