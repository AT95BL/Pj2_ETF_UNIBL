
import java.util.ArrayList;
import java.util.HashMap;

public class Election {
    /*
     *  Pazi, ove promjenjive ispod su skladišta za rezultate!!:
     *  -ideja je da Univerzitet mapira kandidate koji su prošli fakultetske izbore,
     *   pošto u državi imamo VIŠE univerziteta, ideja je da svaki univerzitet mapira svoje pobjednike na nivou fakulteta,
     *   iz tog razloga ovdje koristimo HashMap<Univerzitet, ArrayList<Student>>!!
     *  -ideja je da se kandidati, tj. pobjednici koji su prošli univerzitetske izbore čuvaju u ArrayList i kao takvi idu na državne izbore,
     *  -ideja je da se onda i državni pobjednici čuvaju u ArrayList
     */
    public static HashMap<Univerzitet, ArrayList<Student>> kandidatikojiSuProsliFakultetske = new HashMap<>(); // ideja je da univerzitet mapira svoje pobjednike na nivou fakulteta
    public static ArrayList<Student> kandidatiKojiSuProsliUniverzitetske = new ArrayList<>();
    public static ArrayList<Student> pobjedniciNaDrzavnim = new ArrayList<>();

    public static boolean odrzani = false;

    public static void startElection(Drzava d) {
        odrzani = true;

        // Prvo treba da odredimo kandidate koji su prošli fakultetske izbore ..svaki univerzitet će mapirati svoje pobjednike!!
        // Sljedećom for-petljom vršimo selekciju univerziteta:
        for (var univerzitet : d.univerziteti) {
            /*
                Kako bi bio siguran u to da je glasanje u nekoj izbornoj jedinici završeno,
                moraću iterirati kroz izborne jedinice i za svaku od njih pozivati .join()!!!
                Da bi to mogao realizovati, Nemanjina ideja je da se ElectionThread za svaku jedinicu panaosob
                pohrani u ArrayList<ElectionStudent> ..
            */                
            ArrayList<ElectionThread> izbornaMjesta = new ArrayList<>();            //  fakultetskeJedinice <=> izbornaMjesta
            for (var fakultet : univerzitet.fakulteti) {                            //  redom fakultet1, fakultet2, ...,fakultetN
                ElectionThread thread = new ElectionThread(fakultet.studenti);      //  za svaku izbornuJedinicu(fakultet) kreiraj izbornu nit..
                izbornaMjesta.add(thread);                                          //  sačuvaj istu u ArrayList da bi mogao
                thread.start();                                                     //  nit prelazi u Ready stanje!!
            }
            for (var el : izbornaMjesta) {
                try {
                    el.join();                                                      //  za svaku izbornu jedinicu pozvati .join()
                } catch (InterruptedException e) {
                    System.out.println("PREKID");
                }
            }
            System.out.println("Zavrsena prva faza izbora na univerzitetu: " + univerzitet.imeUniverziteta);
            ArrayList<Student> kandidatiFakulteta = new ArrayList<>();
            for (var el : izbornaMjesta)                                            //  Imaj na umu to da je zbog .join() gore odrađen posao
                kandidatiFakulteta.addAll(el.rezultatiIzbora);                      //  pa za svaku izbornu jedinicu imaš po HashSet!!! .addAll()
            kandidatikojiSuProsliFakultetske.put(univerzitet, kandidatiFakulteta);  // na kraju dobijaš to da svaki univerzitet mapira listu svojih kandidata pobjednika tj. sve kandidate koji su prošli fakultetske
        }
        /*  
         *  1) Selektuješ univerzitet, dakle država u sebi sadrži univerzitete i ti for-petljom iteriraš kroz iste..
         *  2) Pošto imaš namjeru da iteriraš kroz svaku izbornu jedinicu kako bi redom one pozivale .join() treba ti skladište
         *     za objekte klase ElectionThread. Najprirodniji izbor je upravo ArrayList<>..
         *  3) Selektuješ redom fakultet po fakultet na nivou univerziteta..
         *  4) Za svaki fakultet(Izbornu jedinicu) imaš zaseban ElectionThread
         *  5) Aktiviraj unos u skladište..
         *  6) Izbori se trebaju održati, redom za jedinicu po jedinicu tako da izbornu nit prebaci u READY stanje ....start()
         *  7) Iteracija kroz izbornaMjesta i za svaku izbornu jedinicu da se pozove .join()
         * 
         *  8) Iteracija kroz izborna mjesta, iz svakog mjesta izvuci pobjednike i strpaj ih u ArrayList
         *  9) kandidatiKojiSuProsliFakultetske je HashMap-a!!!
         *     univerzitet je ključ, a kandidatiFakulteta su value!!
         */

        ArrayList<ElectionThread> izbornaMjesta = new ArrayList<>();                
        for (var univerzitet : kandidatikojiSuProsliFakultetske.entrySet()) {       //  .entrySet() će ti vratiti sve kljuceve ..
            ElectionThread thread = new ElectionThread(univerzitet.getValue());     //  .getvalue() za taj kljuc ti vraća mapiranu-vrijednost 
            izbornaMjesta.add(thread);
            thread.start();
        }
        for (var el : izbornaMjesta) {
            try {
                el.join();
            } catch (InterruptedException e) {
                System.out.println("PREKID");
            }
        }
        System.out.println("Zavrsena druga faza!!");
        for (var th : izbornaMjesta)
            kandidatiKojiSuProsliUniverzitetske.addAll(th.rezultatiIzbora);
        /*
         *  1) PRIPREMI SKLADIŠTE ZA NITI!!
         *  2) u for-petlji redom selektuješ univerzitet-ključ iz HashMap tako što pozoveš metodu .entrySet()
         *     ZNAČI "var univerzitet" -njemu ćeš dodjeliti selektovanu vrijednost tako što iskoristiš .entrySet() metodu!!
         *  3) za selektovani ključ napraviš ElectionThread objekat te kao argument konstruktora iskoristiš "univerzitet(tj. ključ).getValue()"
         *  4) ISTA PRIČA SA SKLADIŠTENJEM NITI!!!
         *  5) Iteriraj kroz izborne jedinice i od svake spremi rezultat u poseban ArrayList!!
         */

        ElectionThread th = new ElectionThread(kandidatiKojiSuProsliUniverzitetske);
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            System.out.println("PREKID");
        }
        pobjedniciNaDrzavnim.addAll(th.rezultatiIzbora);
    }
}

