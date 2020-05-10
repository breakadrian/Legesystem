class PreparatB extends Legemiddel {
    int styrke;
    String type = "vanedannende";

    public PreparatB(String navn, double pris, double virkestoff, int pStyrke) {
        super(navn, pris, virkestoff);
        this.styrke = pStyrke;
    }

    public int hentVanedannendeStyrke() {
        return styrke;
    }

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
