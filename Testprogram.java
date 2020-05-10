import java.util.Scanner;

class Testprogram {

  public static void main(String[] args) {
      Legesystem nytt = new Legesystem();
      System.out.println("\nHei og velkommen til - På Randen av Haugen Legekontor -");
      nytt.lese("myeInndata.txt");

      nytt.alleValgmuligheterTilBruker();
  }
}


  /*  public static void main(String[] args) {
        System.out.println("\nHei og velkommen til - På Randen av Haugen Legekontor -");
        Legesystem nytt = new Legesystem();
        nytt.lese("inndata.txt");
        int brukersValg = 0;


        brukerSittValg(valgmuligheterTilBruker(brukersValg), nytt);
  }

        private static int valgmuligheterTilBruker(int brukersValg){
          Scanner input = new Scanner(System.in);
          System.out.println("\nDu får nå flere valg.\n"+
          "\nØnsker du å skrive ut en fullstending oversikt over:"+
          "\n Pasienter - Tast 1"+
          "\n Leger - Tast 2"+
          "\n Legemidler - Tast 3"+
          "\n Resepter - Tast 4"+
          "\n For å avslutte - Tast 9\n");
          brukersValg = input.nextInt();
          return brukersValg;
        }

        private static void brukerSittValg(int brukersValg, Legesystem nytt) {
          while (brukersValg != 9) {

            if (brukersValg == 1) {
              System.out.println("\nPasienter:");
              for (int i = 0; i < nytt.pasientListe.stoerrelse(); i++) {
                System.out.println(nytt.pasientListe.hent(i) + "\n");
              }
            }
            else if (brukersValg == 2) {
              System.out.println("\nLeger:");
              for (int i = 0; i < nytt.legeListe.stoerrelse(); i++) {
                System.out.println(nytt.legeListe.hent(i)+ "\n");
              }
            }
            else if (brukersValg == 3) {
              System.out.println("\nLegemidler:");
              for (int i = 0; i < nytt.legemiddelListe.stoerrelse(); i++) {
                System.out.println(nytt.legemiddelListe.hent(i)+ "\n");
              }
            }
            else if (brukersValg == 4) {
              System.out.println("\nResepter:");
              for (int i = 0; i < nytt.reseptListe.stoerrelse(); i++) {
                System.out.println(nytt.reseptListe.hent(i)+ "\n");
              }
            }
            else {
              System.out.println("\nVenligst velg ett av de oppgitte alternativene\n");
              }

            Scanner nyttValgFraBruker = new Scanner(System.in);
            System.out.println("\nØnsker du å skrive ut noen andre oversikter, tast 5. \nFor aa avslutte tast 9\n");
            int nyInputFraBruker = nyttValgFraBruker.nextInt();
            if (nyInputFraBruker == 5){
              brukerSittValg(valgmuligheterTilBruker(0), nytt);
            }
            else if (nyInputFraBruker == 9) {
              System.out.println("\nTakk for at du benyttet deg av - På Randen av Haugen Legekontor -\n Ha en fin dag");
              return;
      }
    }
  }
}

        System.out.println("");
        nytt.leggTilLege("Jens Jensemann");
        nytt.leggTilPasient("Adrian Randen", "14109455555");
        nytt.leggTilLegemiddel("tiss", "vanlig", 20, 45.2);
        nytt.leggTilLegemiddel("bæsj", "narkotisk", 10, 44.2, 90);
        nytt.leggTilResept(1, "Dr. House", 1, "blaa", 200);
        nytt.leggTilResept(0, "Dr. Cox", 1, "p");

#

#

         * for (int i = 0; i < nytt.legeListe.stoerrelse(); i++) {
         * System.out.println("\n Lege"); System.out.println(nytt.legeListe.hent(i)); }
         *
         * for (int i = 0; i < nytt.pasientListe.stoerrelse(); i++) {
         * System.out.println("\n Pasient");
         * System.out.println(nytt.pasientListe.hent(i)); }
         *
         * for (int i = 0; i < nytt.legemiddelListe.stoerrelse(); i++) {
         * System.out.println("\n Legemiddel");
         * System.out.println(nytt.legemiddelListe.hent(i)); }

        for (int i = 0; i < nytt.reseptListe.stoerrelse(); i++) {
            System.out.println("\n Resept");
            System.out.println(nytt.reseptListe.hent(i));
        }

        nytt.brukResept(0);

        for (String i : nytt.hentNarkotiskPasient()) {
            System.out.println(i);
        }

        nytt.skrivTilFil();
    }*/
