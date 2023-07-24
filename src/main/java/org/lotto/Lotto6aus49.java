package org.lotto;

import java.util.Arrays;

public class Lotto6aus49 extends Lottoschein implements QuickTippGenerator {
    private final int[] tippReihe = new int[6];

    @Override
    public void erzeugeTippreihe(int[] ausschlussUnglueckszahlen) throws EmptyArrayException {

        if(ausschlussUnglueckszahlen.length < 1){
            throw new EmptyArrayException("Du hast keine Unglückszahlen hinzugefügt, bitte füge welche hinzu.");
        }

        for (int i = 0; i <=5; i++){
            tippReihe[i] = zahlenGeneratorMitAussschlussVonUnglueckszahlen(1, 49, ausschlussUnglueckszahlen);
        }
    }

    @Override
    public String ausgabeTippreihe() throws EmptyArrayException {

        if (tippReihe.length < 1) {
            throw new EmptyArrayException("Du hast noch keine Tippreihe erzeugt!");
        }

        Arrays.sort(tippReihe);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tippReihe.length; i++) {
            sb.append(tippReihe[i]);

            if (i < tippReihe.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private int zahlenGeneratorMitAussschlussVonUnglueckszahlen(int min, int max, int [] exclude) throws EmptyArrayException {

        if (exclude.length < 1){
            throw new EmptyArrayException("Du hast noch keine Unglückszahlen hinzugefügt");
        }

        Arrays.sort(exclude);
        int random = min + (int) ((max - min + 1 - exclude.length) * Math.random());
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    public int[] getTippReihe() {
        return tippReihe;
    }
}

