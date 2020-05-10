/**
 * Representerer en lege som kan skrive ut resepter
 */
class Lege implements Comparable<Lege> {
    String navn;
    Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();
    int kontrollID = 0;

    Lege(String lNavn) {
        navn = lNavn;
    }

    /**
     * Returnerer navnet til legen.
     *
     * @return Navnet til legen.
     */
    public String hentNavn() {
        return navn;
    }

    /**
     * Returnerer en resept med tilhorende pasient, legemiddel og reit.
     *
     * @param legemiddel Type legemiddel.
     * @param pasient    Pasienten som skal bruke resepten.
     * @param reit       Antall ganger resepten kan brukes.
     * @return Resepten.
     * @throws UlovligUtskrift
     */

    public Lenkeliste<Resept> hentReseptListe() {
        return utskrevedeResepter;
    }

    public Presept skrivPresept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        int reit = 3;
        Presept resept = new Presept(legemiddel, this, pasient, reit);
        if ((resept.hentLegemiddel() instanceof PreparatA) && (hentKontrollID() == 0)) {
            throw new UlovligUtskrift(this, resept.hentLegemiddel());
        }
        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public Hvit skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        Hvit resept = new Hvit(legemiddel, this, pasient, reit);
        if ((resept.hentLegemiddel() instanceof PreparatA) && (hentKontrollID() == 0)) {
            throw new UlovligUtskrift(this, resept.hentLegemiddel());
        }
        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public Millitaer skrivMillitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        Millitaer resept = new Millitaer(legemiddel, this, pasient, reit);
        if ((resept.hentLegemiddel() instanceof PreparatA) && (hentKontrollID() == 0)) {
            throw new UlovligUtskrift(this, resept.hentLegemiddel());
        }

        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public Blaa skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        Blaa resept = new Blaa(legemiddel, this, pasient, reit);
        if ((resept.hentLegemiddel() instanceof PreparatA) && (hentKontrollID() == 0)) {
            throw new UlovligUtskrift(this, resept.hentLegemiddel());
        }
        utskrevedeResepter.leggTil(resept);
        return resept;
    }

    public int hentKontrollID() {
        return this.kontrollID;
    }

    @Override
    public int compareTo(Lege lege) {
        return this.navn.compareTo(lege.navn);
    }

    @Override
    public String toString() {
        String s = "Navn: " + this.hentNavn();
        return s;
    }

}
