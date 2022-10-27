public class tabellstakk<T> implements Stakk<T> {


    private T[] a;                    // en generisk tabell
    private int antall;               // antall verdier på stakken

    @SuppressWarnings("unchecked")    // konvertering: Object[] -> T[]
    public void tabellStakk(int lengde)    // valgfri tabellengde
    {
        a = (T[]) new Object[lengde];   // oppretter tabellen
        antall = 0;                     // stakken er tom
    }


    @Override
    public void leggInn(T verdi) {

    }

    @Override
    public T kikk() {
        return null;
    }

    @Override
    public T taUt() {
        return null;
    }

    @Override
    public int antall() {
        return 0;
    }

    @Override
    public boolean tom() {
        return false;
    }

    @Override
    public void nullstill() {
        for (int i=0; i<antall(); i++){
            a[i]=null;
            antall=0;
        }

    }
    public String toString(){
      if (tom()){
          return "[]";
      }
      StringBuilder s=new StringBuilder();
      s.append("[");
      for (int i=a.length-1; i>=0; i--){
          s.append(a[i]).append(", ");
      }
      s.append("]");
      return s.toString();
    }
    public static <T> void snu(Stakk<T> A){
        Stakk<T> B= new tabellstakk<>();
        Stakk<T> C=new tabellstakk<>();

        while (!A.tom()) B.leggInn(A.taUt());
        while (!B.tom()) C.leggInn(B.taUt());
        while (!C.tom()) A.leggInn(C.taUt());
    }
    public static <T> void kopier(Stakk<T> A, Stakk<T> B){
       Stakk<T> C= new tabellstakk<>();
       while (!A.tom()){C.leggInn(A.taUt());}
       while (!C.tom()){
           T t=C.taUt();
           A.leggInn(t);
           B.leggInn(t);
       }
    }
    public static <T> void snu2(Stakk<T> A){
        Stakk<T> B=new tabellstakk<>();
        int n= A.antall()-1;
        while (n>0){
            T temp= A.taUt();
            for(int j=0; j<n; j++){
                B.leggInn(A.taUt());
                A.leggInn(temp);
            }
            while (!B.tom()){
                A.leggInn(B.taUt());
                n--;
            }
        }

    }


}
