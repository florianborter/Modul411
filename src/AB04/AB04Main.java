package AB04;
public class AB04Main {
    public static void main(String[] args){
        int[] liste = new int[100000];
        int[] clonedListe = new int[100000];
        int[] clonedListe2 = new int[100000];

        for (int i = 0; i < liste.length; i++) {
            liste[i] = (int)(100*Math.random());
        }

        long startZeit = System.currentTimeMillis();
        clonedListe2 = liste.clone();
        long stopZeit = System.currentTimeMillis();

        long startZeit2 = System.currentTimeMillis();
        for (int i = 0; i < liste.length; i ++) {
            clonedListe[i] = liste[i];
        }
        long stopZeit2 = System.currentTimeMillis();

        long differenz = stopZeit - startZeit;
        long differenz2 = stopZeit2 - startZeit2;
        System.out.println("Dauer (clone): " + differenz + " ms");
        System.out.println("Dauer (elementweise Kopieren): " + differenz2 + " ms");
    }
}
