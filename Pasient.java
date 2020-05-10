import java.util.concurrent.atomic.AtomicInteger;

//test - adrian 09:37
/**
 * Representerer en pasient med tilhorende liste med resepter.
 */
class Pasient {
    private String navn;
    private String fodselsnummer;
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    int id;
    private Stabel<Resept> resepter = new Stabel<Resept>();

    /**
     *
     * @param pNavn          String med pasientens navn.
     * @param pFodselsnummer String med pasientens fodselsnummer
     */

    public Pasient(String pNavn, String pFodselsnummer) {
        navn = pNavn;
        fodselsnummer = pFodselsnummer;
        id = idGenerator.getAndIncrement();
    }

    public String hentNavn(){
      return navn;
    }

    /**
     * Returnerer en Stabel med alle reseptene til pasienten.
     *
     * @return resepter Stabel som inneholder alle reseptene til pasienten.
     */
    public Stabel<Resept> hentResepter() {
        return resepter;
    }

    /**
     * Legger inn en Resept i pasientens reseptliste.
     *
     * @param res Resepten som skal legges inn.
     */
    public void leggInnResept(Resept res) {
        resepter.leggPaa(res);
    }

    public int hentId() {
        return id;
    }

    @Override
    public String toString() {
        String s = "Navn: " + this.hentNavn() + "\nFødselsnummer: " + fodselsnummer + "\nID:" + id;
        return s;
}
}
