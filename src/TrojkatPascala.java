public class TrojkatPascala {
    private String[] trojkat;

    public TrojkatPascala(int wielkosc) {
        // Zapełnianie tabeli wierszy trojkata

        trojkat = new String[wielkosc + 1];

        for (int i=0; i<=wielkosc; i++) {
            trojkat[i] = wierszTrojkata(i);
        }
    }

    public String getWiersz(int i) {
        return trojkat[i];
    }

    private String wierszTrojkata(int numer) {
        String[] tablica = new String[numer + 1];

        for (int i=0; i<=numer; i++) {
            tablica[i] = "" + dwumian(numer, i);
        }

        return String.join(" ", tablica);
    }

    private int dwumian(int gora, int dol) {
        int wynik = 1;

        for(int i=0; i<dol; i++) {
            wynik = wynik * (gora - dol + i + 1) / (i + 1);
        }

        return wynik;
    }
}
