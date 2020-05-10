
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Representerer en resept med tilhorende pasient, lege og legemiddel.
 */
abstract class Resept {
    Legemiddel legemiddel;
    Lege utskrivendeLege;
    Pasient pasient;
    int reit;
    static final AtomicInteger idGenerator = new AtomicInteger(0);
    int id;
    boolean brukt;

    public Resept(Legemiddel rLegemiddel, Lege rUtskrivendeLege, Pasient rPasient, int rReit) {
        legemiddel = rLegemiddel;
        utskrivendeLege = rUtskrivendeLege;
        pasient = rPasient;
        reit = rReit;
        id = idGenerator.getAndIncrement();
        brukt = false;
        pasient.leggInnResept(this);
    }

    public Legemiddel hentLegemiddel() {
        return legemiddel;
    }

    public Lege hentLege() {
        return utskrivendeLege;
    }

    public Pasient hentPasient() {
        return pasient;
    }

    public int hentReit() {
        return reit;
    }

    public int hentId() {
        return id;
    }

    /**
     * Bruker opp en reit i resepten, og returnerer true/false ettersom resepten er
     * brukt opp.
     *
     * @return true/false ettersom reit <= 0 eller ikke.
     */
    public boolean bruk() {
        if (brukt == true) {
            return false;
        } else {
            reit -= 1;

            if (reit <= 0) {
                brukt = true;
            }

            return true;
        }
    }

    abstract public String farge();

    abstract public double prisAaBetale();

    @Override
    public String toString() {
        String s = "Legemiddel: " + this.legemiddel.hentNavn() + "\n" + "Reit: " + this.reit + "\n" + "ReseptID: "
                + this.id + "\n" + "Lege: " + utskrivendeLege.hentNavn() + "\n" + "Pasient: "
                + this.hentPasient().hentNavn();
        return s;
    }

}
