import java.util.NoSuchElementException;

public class SirkularBuffer<T> implements Kø<T> {
    private T[] a;      // en tabell
    private int fra;    // posisjonen til den første i køen
    private int til;    // posisjonen til første ledige plass

    private int antall;
    private int lengde;

    public SirkularBuffer(int lengde)
    {
        if (lengde < 1)
            throw new IllegalArgumentException("Må ha positiv lengde!");

        a = (T[])new Object[lengde];

        fra = til = 0;    // a[fra:til> er tom
        antall=0;
    }

    @Override
    public boolean leggInn(T verdi) {
        a[til] = verdi;                       // ny verdi bakerst i køen
        til++;                            // øker til med 1
        if (til == a.length) til = 0;     // hopper til 0
        if (fra == til){                   // sjekker om tabellen er full
           til=(til+1)%lengde;
        }   // dobler tabellen
        return true;
    }

    @Override
    public T kikk() {
        return null;
    }

    @Override
    public T taUt() {
        if (fra==til){
            throw new NoSuchElementException("Køen er tom");
        }
        T temp=a[0];
        a[fra]=null;
        fra++;
        if (fra==a.length) fra=0;
        return temp;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {

    }
}
