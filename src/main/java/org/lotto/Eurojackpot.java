package org.lotto;

public class Eurojackpot extends Lottoschein implements QuickTippGenerator {
    private int[] FünfAusFünfzigTippreihe = new int[5];
    private int[] zweiAusZehnTippreihe = new int[2];

    // Implementierung der Methoden aus QuickTippGenerator
    @Override
    public int[] erzeugeTippreihe() {
        // Implementierung der Methode erzeugeTippreihe
        return null;
    }

    @Override
    public String ausgabeTippreihe() {
        // Implementierung der Methode ausgabeTippreihe
        return null;
    }

    public int[] erzeugeZweiAusZehn() {
        // Implementierung der Methode erzeugeZweiAusZehn
        return null;
    }

    public void ausgabeZweiAusZehn() {
        // Implementierung der Methode ausgabeZweiAusZehn
    }
}

