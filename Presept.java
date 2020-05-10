/**
 * Representerer en resept for prevensjonsmidler for unge. Gir 108kr i rabatt
 * ned til pris == 0 kr.
 */
class Presept extends Hvit {
    public Presept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
        reit = 3;
        farge = "p";
    }

    @Override
    public double prisAaBetale() {
        double pris = legemiddel.hentPris();

        if (pris - 108 > 0) {
            return pris - 108;
        }

        else {
            return 0;
        }
    }
}
