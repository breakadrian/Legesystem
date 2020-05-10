import java.io.FileNotFoundException; //importerer for å håndtere fil-unntakene, og for å kunne bruke "throws"
import java.io.File; //importert for å bruke filen
import java.util.Scanner; //for å kunne lese filen
import java.io.PrintWriter;
import java.lang.System;

/**
 * Representerer et legesystem.
 */
class Legesystem {
  int brukersValg = 0;
  int brukersNyeValg = 0;

  SortertLenkeliste<Lege> legeListe = new SortertLenkeliste<Lege>();
  Lenkeliste<Pasient> pasientListe = new Lenkeliste<Pasient>();
  Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
  Lenkeliste<Resept> reseptListe = new Lenkeliste<Resept>();

  int utskrevneVanedannende = 0;
  int utskrevneNarkotiske = 0;

  /**
   * Legger til en lege i legesystemet.
   *
   * @param navn String med navnet paa legen.
   */
  public void leggTilLege(String navn) {
    Lege nyLege = new Lege(navn);
    legeListe.leggTil(nyLege);
  }

  /**
   * Legger til en spesialist i legesystemet.
   *
   * @param navn       string med navnet paa legen.
   * @param kontrillID int med id-nummeret til spesialisten.
   */

  public void leggTilLege(String navn, int kontrollID) {
    Spesialist nyLege = new Spesialist(navn, kontrollID);
    legeListe.leggTil(nyLege);
  }

  /**
   * Legger til en pasient i legesystemet.
   *
   * @param navn           string med navnet paa pasienten.
   * @param foedselsnummer string med fodselsnummeret til pasienten.
   */
  public void leggTilPasient(String navn, String foedselsnummer) {
    Pasient nyPasient = new Pasient(navn, foedselsnummer);
    pasientListe.leggTil(nyPasient);
  }

  /**
   * Lager legemiddel av type Preparat C og legger det i legemiddellisten.
   *
   * @param navn       string med navnet til legemiddelet
   * @param type       string med typen legemiddel (vanlig/vanedannende/narkotisk)
   * @param pris       double med prisen
   * @param virkestoff double med virkestoffet
   */
  public void leggTilLegemiddel(String navn, String type, double pris, double virkestoff) {
    if (type.equals("vanlig")) {
      PreparatC nyttPreparatC = new PreparatC(navn, pris, virkestoff);
      legemiddelListe.leggTil(nyttPreparatC);
    } else {
      System.out.println("Typen du oppga er ikke registrert i systemet. Vennligst prøv igjen");
    }
  }

  /**
   * Lager legemiddel av type Preparat A eller B og legger det i legemiddellisten.
   *
   * @param navn       string med navnet til legemiddelet
   * @param type       string med typen legemiddel (vanlig/vanedannende/narkotisk)
   * @param pris       double med prisen
   * @param virkestoff double med virkestoffet
   */
  public void leggTilLegemiddel(String navn, String type, double pris, double virkestoff, int pStyrke) {
    if (type.equals("narkotisk")) {
      PreparatA nyttPreparatA = new PreparatA(navn, pris, virkestoff, pStyrke);
      legemiddelListe.leggTil(nyttPreparatA);
    } else if (type.equals("vanedannende")) {
      PreparatB nyttPreparatB = new PreparatB(navn, pris, virkestoff, pStyrke);
      legemiddelListe.leggTil(nyttPreparatB);
    } else {
      System.out.println("Typen du oppga er ikke registrert i systemet. Vennligst prøv igjen");
    }
  }

  /**
   * Tar en legemiddelID som input og returnerer det tilhørende
   * legemiddel-objektet, hvis det finnes i legemiddellisten.
   *
   * @param legemiddelID int med IDen til legemiddelet som skal hentes ut
   * @return legemiddel-objektet / null hvis det ikke finnes i listen
   */
  public Legemiddel sjekkLegemiddelIListe(int legemiddelID) {
    Legemiddel legemiddelSkalLeggesTil = null;
    for (Legemiddel i : legemiddelListe) {
      if (i.hentId() == legemiddelID) {
        legemiddelSkalLeggesTil = i;
        return legemiddelSkalLeggesTil;
      }
    }
    return null;
  }

  /**
   * Tar et navn som input og returnerer det tilhørende lege-objektet, hvis det
   * finnes i legelisten.
   *
   * @param legeNavn string med navnet til legen som skal hentes ut
   * @return lege-objektet / null hvis det ikke finnes i listen
   */
  public Lege sjekkLegeIListe(String legeNavn) {
    Lege legeSkalLeggesTil = null;
    for (Lege i : legeListe) {
      if (i.hentNavn().equals(legeNavn)) {
        legeSkalLeggesTil = i;
        return legeSkalLeggesTil;
      }
    }
    return null;
  }

  /**
   * Tar et navn som input og returnerer det tilhørende pasient-objektet, hvis det
   * finnes i pasientlisten.
   *
   * @param pasientID int med IDen til pasienten som skal hentes ut
   * @return pasient-objektet / null hvis det ikke finnes i listen
   */
  public Pasient sjekkPasientIListe(int pasientID) {
    Pasient pasientSkalLeggesTil = null;
    for (Pasient i : pasientListe) {
      if (i.hentId() == pasientID) {
        pasientSkalLeggesTil = i;
        return pasientSkalLeggesTil;
      }
    }
    return null;
  }

  /**
   * Tar et legemiddel som input og øker telleren for utskrevende vanedannende,
   * hvis legemiddelet er av type B / vanedannende.
   *
   * @param legemiddel
   */
  public void tellVanedannende(Legemiddel legemiddel) {
    if (legemiddel instanceof PreparatB) {
      utskrevneVanedannende++;
    }
  }

  /**
   * Tar et legemiddel som input og øker telleren for utskrevende narkotiske, hvis
   * legemiddelet er av type A / narkotisk.
   *
   * @param legemiddel
   */
  public void tellNarkotisk(Legemiddel legemiddel) {
    if (legemiddel instanceof PreparatA) {
      utskrevneNarkotiske++;
    }
  }

  /**
  * lager statistikk ved å lese av alle leger i legelisten, lager en ny reseptliste
  * vi fyller med reseptene til hver enkelt lege, og leser av alle reseptene, og sjekker
  * om de er instanser av preparat A (narkotisk) - hvis ja øker en teller,
  * og til slutt skrives det hele ut
  */
  public void hentLegeStatistikk() {
    for (Lege i : legeListe) {
      Lenkeliste<Resept> nyReseptListe = i.hentReseptListe();
      int teller = 0;

      for (Resept j : nyReseptListe) {
        if (j.hentLegemiddel() instanceof PreparatA) {
          teller++;
        }
      }

      if (teller > 0) {
        System.out.println(i.hentNavn() + " - Antall utskrevne: " + teller);
      }
    }
  }

  /**
  * mye likt som i statistikkmetoden over, bare at vi leser av pasienter og deres
  * reseptlister.
  */
  public void hentPasientStatistikk() {
    for (Pasient i : pasientListe) {
      Lenkeliste<Resept> nyReseptListe = i.hentResepter();
      int teller = 0;

      for (Resept j : nyReseptListe) {
        if (j.hentLegemiddel() instanceof PreparatA && j.hentReit() > 0) {
          teller++;
        }
      }

      if (teller > 0) {
        System.out.println(i.hentNavn() + " - Antall gyldige: " + teller);
      }
    }
  }

  /**
   * Lager en resept av type blaa, hvit eller millitaer og legger den i
   * reseptlisten.
   *
   * @param legemiddelID
   * @param legeNavn
   * @param pasientID
   * @param type
   * @param reit
   */
  public void leggTilResept(int legemiddelID, String legeNavn, int pasientID, String type, int reit) {
    Lege legeSkalLeggesTil = sjekkLegeIListe(legeNavn);
    Pasient pasientSkalLeggesTil = sjekkPasientIListe(pasientID);
    Legemiddel legemiddelSkalLeggesTil = sjekkLegemiddelIListe(legemiddelID);

    if (legeSkalLeggesTil == null) {
      System.out.println("Resept: Klarer ikke finne legen: " + legeNavn);
      return;
    }
    if (pasientSkalLeggesTil == null) {
      System.out.println("Resept: Klarer ikke finne pasient med ID: " + pasientID);
      return;
    }
    if (legemiddelSkalLeggesTil == null) {
      System.out.println("Resept: Klarer ikke finne legemiddelet med ID: " + legemiddelID);
      return;
    }

    tellNarkotisk(legemiddelSkalLeggesTil);
    tellVanedannende(legemiddelSkalLeggesTil);

    if (type.equals("blaa")) {
      Blaa nyResept = null;
      try {
        nyResept = legeSkalLeggesTil.skrivBlaaResept(legemiddelSkalLeggesTil, pasientSkalLeggesTil, reit);
        reseptListe.leggTil(nyResept);
      } catch (UlovligUtskrift u) {
        System.out.println(u);
      }
    } else if (type.equals("hvit")) {
      Hvit nyResept = null;
      try {
        nyResept = legeSkalLeggesTil.skrivHvitResept(legemiddelSkalLeggesTil, pasientSkalLeggesTil, reit);
        reseptListe.leggTil(nyResept);
      } catch (UlovligUtskrift u) {
        System.out.println(u);
      }
    } else if (type.equals("millitaer")) {
      Millitaer nyResept = null;
      try {
        nyResept = legeSkalLeggesTil.skrivMillitaerResept(legemiddelSkalLeggesTil, pasientSkalLeggesTil, reit);
        reseptListe.leggTil(nyResept);
      } catch (UlovligUtskrift u) {
        System.out.println(u);
      }
    } else {
      System.out.println("Resept: Du har oppgitt feil type");
      return;
    }
  }

  /**
   * Lager en resept av type p og legger den i reseptlisten.
   *
   * @param legemiddelID
   * @param legeNavn
   * @param pasientID
   * @param type
   */
  public void leggTilResept(int legemiddelID, String legeNavn, int pasientID, String type) {
    Lege legeSkalLeggesTil = sjekkLegeIListe(legeNavn);
    Pasient pasientSkalLeggesTil = sjekkPasientIListe(pasientID);
    Legemiddel legemiddelSkalLeggesTil = sjekkLegemiddelIListe(legemiddelID);

    if (legeSkalLeggesTil == null) {
      System.out.println("Resept: Klarer ikke finne legen: " + legeNavn);
      return;
    }
    if (pasientSkalLeggesTil == null) {
      System.out.println("Resept: Klarer ikke finne pasient med ID: " + pasientID);
      return;
    }
    if (legemiddelSkalLeggesTil == null) {
      System.out.println("Resept: Klarer ikke finne legemiddelet med ID: " + legemiddelID);
      return;
    }

    tellNarkotisk(legemiddelSkalLeggesTil);
    tellVanedannende(legemiddelSkalLeggesTil);


    if (type.equals("p")) {
      Presept nyResept = null;
      try {
        nyResept = legeSkalLeggesTil.skrivPresept(legemiddelSkalLeggesTil, pasientSkalLeggesTil);
        reseptListe.leggTil(nyResept);
      } catch (UlovligUtskrift u) {
        System.out.println(u);
      }
    } else {
      System.out.println("Resept: Du har oppgitt feil type");
      return;
    }
  }

  /**
   * Leser inn pasienter, legemidler, leger og resepter fra en fil.
   *
   * @param fil navnet på tekstfilen som skal leses inn
   */
  public void lese(String fil) {
    Scanner nyFil = null;

    try {
      nyFil = new Scanner(new File(fil));
    } catch (FileNotFoundException u) {
      System.out.println("Fil: finnes ikke");
    }

    int teller = 0;
    while (nyFil.hasNextLine()) {

      String linje = nyFil.nextLine().intern().trim();
      String[] linje_tegn = linje.split("");
      String[] linje_kommadelt = linje.split(",");

      // Legger til pasienter
      if (teller == 1 && linje_tegn[0].intern() != "#") {

        leggTilPasient(linje_kommadelt[0], linje_kommadelt[1]);
      }

      // Legger til legmiddler
      if (teller == 2 && linje_tegn[0].intern() != "#") {

        if (linje_kommadelt.length == 5) {
          try {
            leggTilLegemiddel(linje_kommadelt[0], linje_kommadelt[1], Double.parseDouble(linje_kommadelt[2]),
                Double.parseDouble(linje_kommadelt[3]), Integer.parseInt(linje_kommadelt[4]));
          } catch (NumberFormatException n) {
            System.out.println("Legemiddel: Du har feil verdi - " + n.getMessage());
          }
        }

        else if (linje_kommadelt.length == 4) {
          try {
            leggTilLegemiddel(linje_kommadelt[0], linje_kommadelt[1], Double.parseDouble(linje_kommadelt[2]),
                Double.parseDouble(linje_kommadelt[3]));
          } catch (NumberFormatException n) {
            System.out.println("Legemiddel: Du har feil verdi - " + n.getMessage());
          }
        }

        else {
          System.out.println("Legemiddel: " + linje_kommadelt[0] + " har feil antall parametere");
        }
      }

      // Legger til leger
      if (teller == 3 && linje_tegn[0].intern() != "#") {

        if (linje_kommadelt[1].intern() == "0") {
          leggTilLege(linje_kommadelt[0]);
        }

        else {
          // Spesialist
          try {
            leggTilLege(linje_kommadelt[0], Integer.parseInt(linje_kommadelt[1]));
          } catch (NumberFormatException n) {
            System.out.println("Spesialist: Du har feil verdi - " + n.getMessage());
          }
        }
      }

      // Legger til resepter
      if (teller == 4 && linje_tegn[0].intern() != "#") {
        if (linje_kommadelt[3].intern() == "hvit" || linje_kommadelt[3].intern() == "blaa"
            || linje_kommadelt[3].intern() == "millitaer") {
          try {
            leggTilResept(Integer.parseInt(linje_kommadelt[0]), linje_kommadelt[1],
                Integer.parseInt(linje_kommadelt[2]), linje_kommadelt[3], Integer.parseInt(linje_kommadelt[4]));
          } catch (NumberFormatException n) {
            System.out.println("Resept: Du har feil verdi - " + n.getMessage());
          }
        }
        if (linje_kommadelt[3].intern() == "p") {
          try {
            leggTilResept(Integer.parseInt(linje_kommadelt[0]), linje_kommadelt[1],
                Integer.parseInt(linje_kommadelt[2]), "p");
          } catch (NumberFormatException n) {
            System.out.println("Resept: Du har feil verdi - " + n.getMessage());
          }
        }
      }

      if (linje_tegn[0].equals("#")) {
        teller++;
      }
    }
  }

  /**
  * her bruker vi resepter ved å lese av reseptID som blir oppgitt, for så å
  * kalle på resepten det gjelder, og benytte oss av bruk()-metoden til reseptklassen
  */
  public void brukResept(int reseptId) {
    for (Resept i : reseptListe) {
      if (i.hentId() == reseptId) {
        i.bruk();
        return;
      }
    }
    System.out.println("ReseptID finnes ikke");
  }

  public int hentUtskrevendeVanedannende() {
    return utskrevneVanedannende;
  }

  public int hentUtskrevendeNarkotiske() {
    return utskrevneNarkotiske;
  }

  /**
  * her skriver vi til fil ved hjelp av PrintWriter-klassen, og skriver inn pasienter,
  * legemidler, leger og resepter fra listene vi har lagret dem i tidligere i koden
  */
  public void skrivTilFil() {
    PrintWriter pw = null;

    try {
      pw = new PrintWriter("utdata.txt");
    } catch (Exception e) {
      System.out.println("Kan ikke lage filen utdata.txt");
    }

    pw.println("# Pasienter (navn, fnr)");
    for (Pasient i : pasientListe) {
      pw.println(i.hentNavn() + "," + i.hentId());
    }

    pw.println("# Legemidler (navn,type,pris,virkestoff,[styrke])");
    for (Legemiddel i : legemiddelListe) {
      if (i.hentType() == "narkotisk" || i.hentType() == "vanedannende") {
        pw.println(
            i.hentNavn() + "," + i.hentType() + "," + i.hentPris() + "," + i.hentVirkestoff() + "," + i.hentStyrke());
      }

      else {
        pw.println(i.hentNavn() + "," + i.hentType() + "," + i.hentPris() + "," + i.hentVirkestoff());
      }

    }

    pw.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)");
    for (Lege i : legeListe) {
      pw.println(i.hentNavn() + "," + i.hentKontrollID());
    }

    pw.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])");
    for (Resept i : reseptListe) {
      if (i instanceof Presept) {
        pw.println(i.hentLegemiddel().hentId() + "," + i.hentLege().hentNavn() + "," + i.hentPasient().hentId() + ","
            + i.farge());
      }

      else {
        pw.println(i.hentLegemiddel().hentId() + "," + i.hentLege().hentNavn() + "," + i.hentPasient().hentId() + ","
            + i.farge() + "," + i.hentReit());
      }
    }

    pw.close();
  }

  /**
  * I metoden under bygges grensesnittet der brukeren kan velge fra en hovedmeny
  * mellom alle funksjonene til programmet. Hvert valg tar brukeren videre til
  */
  public void alleValgmuligheterTilBruker() {
    Scanner brukersInput = new Scanner(System.in);
    System.out.println("\nHei og velkommen! Du kan velge de følgende alternativene i dette legesystemet:"
        + "\nTast 1 for fullstendig oversikt" + "\nTast 2 for å legge til nye elementer"
        + "\nTast 3 for å bruke en av reseptene til pasientene" + "\nTast 4 for å skrive ut ulike former for statistikk"
        + "\nTast 5 for å skrive ny data til fil\n" + "\nTast 9 for å avslutte");

    brukersNyeValg = brukersInput.nextInt();
    if (brukersNyeValg == 1) {
      fullstendigOversikt();
    } else if (brukersNyeValg == 2) {
      oppretteNyeElementer();

    } else if (brukersNyeValg == 3) {
      System.out.println("Vennligst oppgi ID til pasient som du skal bruke resepten til:   ");
      int valgtePasientAaBrukeReseptTil = brukersInput.nextInt();
      brukResept(valgtePasientAaBrukeReseptTil);
      System.out.println("\n\tBruk av resept registrert - Vi tar deg nå tilbake til startsiden.");
      alleValgmuligheterTilBruker();
    }

    else if (brukersNyeValg == 4) {
      brukerSkriverUtStatistikk();
    }

    else if (brukersNyeValg == 5) {
      skrivTilFil();
      System.out.println("\nData skrevet til fil utdata.txt. \n\nDu vil nå bli sendt tilbake til startsiden... ....\n");
      alleValgmuligheterTilBruker();
      // lesAvFilBrukerHarSkrevet();
    }

    else if (brukersNyeValg == 9) {
      System.out.println("\n\tTakk for at du benyttet deg av ''På Randen av Haugen Legekontor''\n\tHa en fin dag");
      System.exit(0);
    }
  }

  public void lesAvFilBrukerHarSkrevet() {
    skrivTilFil();

  }

  /**
  * ved hjelp av metodene over skriver vi ut statistikken som brukeren ønsker
  */
  public void brukerSkriverUtStatistikk() {
    Scanner valgteStatistikk = new Scanner(System.in);
    System.out.println("\nHvilken statistikk ønsker du å få skrevet ut?"
        + "\n Totalt antall utskrevne legemidler som er vanedannende - Tast 1"
        + "\n Totalt antall utskrevne legemidler som er narkotiske - Tast 2"
        + "\n Liste over alle leger som har skrevet ut narkotiske legemidler - Tast 3"
        + "\n Liste over alle pasienter med gyldige resepter på narkotiske legemidler - Tast 4"
        + "\n\n\tØnsker du å gå tilbake til start - Tast 6" + "\n\tØnsker du å avslutte - Tast 9");
    int brukersValg = valgteStatistikk.nextInt();
    if (brukersValg == 1) {
      System.out.println("\nTotalt antall utskrevne legemidler som er vanedannende: " + hentUtskrevendeVanedannende());
    } else if (brukersValg == 2) {
      System.out.println("\nTotalt antall utskrevne legemidler som er narkotiske: " + hentUtskrevendeNarkotiske());
    } else if (brukersValg == 3) {
      System.out.println("\nLeger som har skrevet ut narkotiske legemidler, og antallet av dem:");
      hentLegeStatistikk();
    } else if (brukersValg == 4) {
      System.out.println("\nPasienter med gyldige resepter på narkotiske legemidler, og antallet av dem:");
      hentPasientStatistikk();
    }

    System.out.println("\nTrykk 6 for å gå tilbake til start, eller 9 for å avslutte");
    int brukersAndreValg = valgteStatistikk.nextInt();
    if (brukersAndreValg == 6) {
      alleValgmuligheterTilBruker();
    } else if (brukersAndreValg == 9) {
      System.out.println("\n\tTakk for at du benyttet deg av ''På Randen av Haugen Legekontor''\n\tHa en fin dag");
      System.exit(0);
    }
  }

  /**
  * gir brukeren valget om å opprette nye elementer, og kaller på metoden
  * brukerSittValgteElementAaOpprette() for å opprette det ønskede elementet
  */
  public void oppretteNyeElementer() {
    Scanner opprett = new Scanner(System.in);
    System.out.println("Hvilket type element ønsker du å legge til i systemet?" + "\n Pasient - Tast 1"
        + "\n Lege - Tast 2" + "\n Legemiddel - Tast 3" + "\n Resept - Tast 4" + "\n For å avslutte - Tast 9");
    int brukerOppretter = opprett.nextInt();
    brukerSittValgteElementAaOpprette(brukerOppretter, this);
  }

  public void brukerSittValgteElementAaOpprette(int opprett, Legesystem nytt) {
    Scanner opprettElement = new Scanner(System.in);
    while (opprett != 9) {
      if (opprett == 1) {
        System.out.print("Oppgi pasientens navn:\t");
        String opprettPasientNavn = opprettElement.nextLine();
        System.out.print("Oppgi pasientens fødselsnummer:\t");
        String opprettPasientFoedselsnummer = opprettElement.next();
        leggTilPasient(opprettPasientNavn, opprettPasientFoedselsnummer);
      }

      else if (opprett == 2) {
        System.out.print("Oppgi legens navn:\t");
        String opprettLegeNavn = opprettElement.nextLine();
        System.out.print("Oppgi ID-nummeret til legen. Om legen ikke har et ID-nummer, skriv -1:\t");
        int opprettSpesialistID = opprettElement.nextInt();
        if (opprettSpesialistID >= 0) {
          leggTilLege(opprettLegeNavn, opprettSpesialistID);
        } else {
          leggTilLege(opprettLegeNavn);
        }
      }

      else if (opprett == 3) {
        System.out.print("Oppgi legemiddelets navn:\t");
        String opprettLegemiddelNavn = opprettElement.next();
        System.out.print("Oppgi legemiddelets type:\t");
        String opprettLegemiddelType = opprettElement.next();
        System.out.print("Oppgi legemiddelets pris:\t");
        Double opprettLegemiddelPris = opprettElement.nextDouble();
        System.out.print("Oppgi legemiddelets virkestoff:\t");
        Double opprettLegemiddelVirkestoff = opprettElement.nextDouble();
        System.out.print("Oppgi legemiddelets styrke," + "\nhvis legemiddelet ikke har en registrert styrke, tast -1:\t");
        int opprettLegemiddelStyrke = opprettElement.nextInt();
        if (opprettLegemiddelStyrke >= 0) {
          leggTilLegemiddel(opprettLegemiddelNavn, opprettLegemiddelType, opprettLegemiddelPris,
              opprettLegemiddelVirkestoff, opprettLegemiddelStyrke);
        } else {
          if (opprettLegemiddelType.equals("narkotisk") || opprettLegemiddelType.equals("vanedannende")){
            System.out.println("Typen legemiddel samsvarer ikke med oppgitt styrke");
            alleValgmuligheterTilBruker();
          }
          leggTilLegemiddel(opprettLegemiddelNavn, opprettLegemiddelType, opprettLegemiddelPris,
              opprettLegemiddelVirkestoff);
        }
      } else if (opprett == 4) {
        System.out.print("Oppgi ID til legemiddelet du ønsker å skrive ut resept for:\t");
        int opprettReseptLegemiddel = Integer.parseInt(opprettElement.nextLine());
        System.out.print("Oppgi legen som skal skrive ut resepten:\t");
        String opprettReseptUtsrivendeLege = opprettElement.nextLine();
        System.out.print("Oppgi ID til pasienten som resepten skal skrives ut til:\t");
        int opprettReseptForPasient = opprettElement.nextInt();
        System.out.print("Oppgi type resept som skal skrives ut:\t");
        String opprettReseptType = opprettElement.next();
        if (opprettReseptType.equals("p")){
          leggTilResept(opprettReseptLegemiddel, opprettReseptUtsrivendeLege, opprettReseptForPasient,
              opprettReseptType);
        }
        else {
          System.out.print("Oppgi antall reit: \t");
          int opprettReseptMedReit = opprettElement.nextInt();
          leggTilResept(opprettReseptLegemiddel, opprettReseptUtsrivendeLege, opprettReseptForPasient,
              opprettReseptType, opprettReseptMedReit);
        }
      }
      break;
    }
    alleValgmuligheterTilBruker();
  }
  /**
  * bruker velger hva han/hun vil skrive ut oversikten over
  */
  public void fullstendigOversikt() {
    Scanner input = new Scanner(System.in);
    System.out.println(
        "\nDu får nå flere valg.\n" + "\nØnsker du å skrive ut en fullstending oversikt over:" + "\n Pasienter - Tast 1"
            + "\n Leger - Tast 2" + "\n Legemidler - Tast 3" + "\n Resepter - Tast 4" + "\n For å avslutte - Tast 9\n");
    brukersValg = input.nextInt();
    brukerSittValg(brukersValg, this);
  }
  /*
  * printer ut hele oversikten over leger, pasienter, legemidler og resepter
  */
  public void brukerSittValg(int brukersInput, Legesystem nytt) {
    while (brukersInput != 9) {
      if (brukersInput == 1) {
        System.out.println("\nPasienter:");
        for (int i = 0; i < nytt.pasientListe.stoerrelse(); i++) {
          System.out.println(nytt.pasientListe.hent(i) + "\n");
        }
      } else if (brukersInput == 2) {
        System.out.println("\nLeger:");
        for (int i = 0; i < nytt.legeListe.stoerrelse(); i++) {
          System.out.println(nytt.legeListe.hent(i) + "\n");
        }
      } else if (brukersInput == 3) {
        System.out.println("\nLegemidler:");
        for (int i = 0; i < nytt.legemiddelListe.stoerrelse(); i++) {
          System.out.println(nytt.legemiddelListe.hent(i) + "\n");
        }
      } else if (brukersInput == 4) {
        System.out.println("\nResepter:");
        for (int i = 0; i < nytt.reseptListe.stoerrelse(); i++) {
          System.out.println(nytt.reseptListe.hent(i) + "\n");
        }
      } else {
        System.out.println("\nVenligst velg ett av de oppgitte alternativene\n");
      }
      break;
    }
    if (brukersInput == 9) {
      System.out.println("\nTakk for at du benyttet deg av - På Randen av Haugen Legekontor -\n Ha en fin dag");
      System.exit(0);
    }
    kjoerIgjenSystemet();
  }

  /**
  * Med denne metoden kan vi enkelt gi brukeren muligheten til å hente ut flere
  * oversikter, gå tilbake til start eller avslutte programmet
  */
  private void kjoerIgjenSystemet() {
    Scanner nyttValgFraBruker = new Scanner(System.in);
    System.out.println(
        "\nØnsker du å skrive ut noen andre oversikter, tast 5. \nFor å gå tilbake til start, tast 6 \nFor aa avslutte tast 9\n");
    int nyInputFraBruker = nyttValgFraBruker.nextInt();
    if (nyInputFraBruker == 5) {
      fullstendigOversikt();
    } else if (nyInputFraBruker == 6) {
      alleValgmuligheterTilBruker();
    } else if (nyInputFraBruker == 9) {
      System.out.println("\nTakk for at du benyttet deg av - På Randen av Haugen Legekontor -\n Ha en fin dag");
      System.exit(0);
    }
  }
}
