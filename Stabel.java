/**
 * Representerer en Lenkeliste, utvidet med sist inn/først ut-funksjonalitet.
 * 
 * @param <T> Dataen til Nodene.
 */

class Stabel<T> extends Lenkeliste<T> {
    /**
     * Legger til en Node på slutten av listen.
     * 
     * @param x Dataen til noden.
     */

    public void leggPaa(T x) {

        super.leggTil(this.stoerrelse(), x);

    }

    /**
     * Fjerner en Node fra slutten av listen.
     * 
     * @return Dataen til noden som fjernes.
     */

    public T taAv() {

        return super.fjern(this.stoerrelse() - 1);
    }
}