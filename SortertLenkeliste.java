/**
 * Utvider Lenkelisten slik at den automatisk sorteres basert på Nodenes
 * data-verdier
 */
class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    @Override
    public void leggTil(T x) {

        if (start == null) {
            super.leggTil(x);
        }

        else {
            Node n = start;
            int teller = 0;

            while (n != null) {
                if (n.data.compareTo(x) > 0) {
                    super.leggTil(null);
                    for (int i = stoerrelse() - 2; i >= teller; i--) {
                        super.sett(i + 1, hent(i));
                    }

                    super.sett(teller, x);
                    return;
                }

                teller++;
                n = n.neste;
            }

            super.leggTil(x);
        }
    }

    @Override
    public T fjern() {
        if (start == null) {
            throw new UgyldigListeIndeks(0);
        }

        Node n = start;
        int teller = 0;
        Node forStorste = start;

        if (start.neste == null) {
            T dataTemp = start.data;
            start = start.neste;
            return dataTemp;
        }

        while (n.neste != null) {
            if (n.neste.data.compareTo(forStorste.neste.data) > 0) {
                forStorste = n;
            }

            teller++;
            n = n.neste;
        }

        Node skalFjernes = forStorste.neste;
        forStorste.neste = skalFjernes.neste;
        return skalFjernes.data;
    }

    @Override
    public void leggTil(int pos, T x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sett(int pos, T x) {
        throw new UnsupportedOperationException();
    }
}