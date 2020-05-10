class Blaa extends Resept {
    String farge;

    public Blaa(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);

        farge = "blaa";
    }

    @Override
    public String farge() {
        return farge;
    }

    @Override
    public double prisAaBetale() {
        return legemiddel.hentPris() * 0.25;
    }

}