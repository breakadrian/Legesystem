class Hvit extends Resept {
    String farge;

    public Hvit(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);

        farge = "hvit";
    }

    @Override
    public String farge() {
        return farge;
    }

    @Override
    public double prisAaBetale() {
        return legemiddel.hentPris();
    }

}