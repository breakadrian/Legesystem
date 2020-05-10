class PreparatA extends Legemiddel {
    int styrke;
    String type = "narkotisk";

    public PreparatA(String navn, double pris, double virkestoff, int pStyrke) {
        super(navn, pris, virkestoff);
        styrke = pStyrke;
    }

    public int hentNarkotiskStyrke() {
        return styrke;
    }

    @Override
    public String hentType() {
        return type;
    }

    @Override
    public int hentStyrke() {
        return styrke;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" + "Navn: " + navn + "\n" + "Pris: " + pris + "\n" + "Virkestoff: " + virkestoff + "\n"
                + "Styrke: " + styrke;

    }
}
