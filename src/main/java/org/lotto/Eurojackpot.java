package org.lotto;

import java.util.Arrays;

public class Eurojackpot extends Lottoschein implements QuickTippGenerator {
    private final int[] fuenfAusFuenfzigTippreihe = new int[6];
    private final int[] zweiAusZehnTippreihe = new int[2];

    @Override
    public void erzeugeTippreihe(int[] ausschlussUnglueckszahlen) throws EmptyArrayException {

        if(ausschlussUnglueckszahlen.length < 1){
            throw new EmptyArrayException("Du hast keine Unglückszahlen hinzugefügt, bitte füge welche hinzu.");
        }

        for (int i = 0; i <= 5; i++){
            fuenfAusFuenfzigTippreihe[i] = zahlenGeneratorMitAussschlussVonUnglueckszahlen(1, 50,
                    ausschlussUnglueckszahlen);
        }

        zweiAusZehnTippreihe[0] = zahlenGeneratorMitAussschlussVonUnglueckszahlen(1, 10,
                ausschlussUnglueckszahlen);
        zweiAusZehnTippreihe[1] = zahlenGeneratorMitAussschlussVonUnglueckszahlen(1, 10,
                ausschlussUnglueckszahlen);
    }

    @Override
    public String ausgabeTippreihe() throws EmptyArrayException {

        if (fuenfAusFuenfzigTippreihe[0] == 0) {
            throw new EmptyArrayException("Du hast noch keine Tippreihe erzeugt!");
        }

        Arrays.sort(fuenfAusFuenfzigTippreihe);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fuenfAusFuenfzigTippreihe.length; i++) {
            sb.append(fuenfAusFuenfzigTippreihe[i]);

            if (i < fuenfAusFuenfzigTippreihe.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public String ausgabeZweiAusZehn() throws EmptyArrayException {

        if (zweiAusZehnTippreihe[0] == 0) {
            throw new EmptyArrayException("Du hast noch keine Tippreihe erzeugt!");
        }

        Arrays.sort(zweiAusZehnTippreihe); // Sortiere das Int-Array in aufsteigender Reihenfolge
        return zweiAusZehnTippreihe[0] + " " + zweiAusZehnTippreihe[1];
    }


    int zahlenGeneratorMitAussschlussVonUnglueckszahlen(int min, int max, int[] exclude) throws EmptyArrayException {

        if (exclude.length < 1){
            throw new EmptyArrayException("Du hast noch keine Unglückszahlen hinzugefügt");
        }

        Arrays.sort(exclude);
        int random = min + (int) ((max - min + 1 - exclude.length) * Math.random());
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
        }
        return random;
    }
}

