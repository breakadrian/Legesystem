class Spesialist extends Lege implements Godkjenningsfritak {
    int kontrollID;

    public Spesialist(String navn, int kontrollID) {
        super(navn);
        this.kontrollID = kontrollID;
    }

    @Override
    public int hentKontrollID() {
        return this.kontrollID;
    }

    @Override
    public String toString() {
        String s = "Navn: " + this.hentNavn() + "\n" + "KontrolID: " + hentKontrollID();
        return s;
    }
}
