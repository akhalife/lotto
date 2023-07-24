package org.lotto;

public interface QuickTippGenerator {
    void erzeugeTippreihe(int[] ausschlussUnglueckszahlen) throws EmptyArrayException;
    String ausgabeTippreihe() throws EmptyArrayException;
}

