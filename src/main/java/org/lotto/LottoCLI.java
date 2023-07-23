package org.lotto;

import java.io.IOException;

public class LottoCLI {


    public static void main(String[] args) {
    }

    private static void auswahlLottoSpiel(String auswahlSpiel) {
        // Implementierung der Methode auswahlLottoSpiel
    }

    private static void ungluecksZahlenErstellen(int zahl) throws IOException {
        Lottoschein.erstellenUnglueckszahl(zahl);
    }

    private static void ungluecksZahlenLoeschen(int zahl) throws IOException {
        Lottoschein.loeschenUnglueckszahl(zahl);
    }

    private static void ungluecksZahlenAusgeben() throws IOException {
        Lottoschein.ausgabeUnglueckszahlen();
    }
}

