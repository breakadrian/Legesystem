class Millitaer extends Hvit {
    public Millitaer(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit) {
        super(legemiddel, utskrivendeLege, pasient, reit);
        farge = "millitaer";
    }

    @Override
    public double prisAaBetale() {
        return legemiddel.hentPris() * 0;
    }
}
