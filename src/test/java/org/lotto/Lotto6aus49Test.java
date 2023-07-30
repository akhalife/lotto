package org.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Lotto6aus49Test {

    Lotto6aus49 lotto6aus49;

    @BeforeEach
    public void setUp() {
        lotto6aus49 = new Lotto6aus49();
    }

    @Test
    void erzeugeTippreihe() throws EmptyArrayException {
        // Arrange
        int[] ausschlussUnglueckszahlen = {13, 22, 41, 7, 19};

        // Act
        lotto6aus49.erzeugeTippreihe(ausschlussUnglueckszahlen);

        // Assert
        //Überprüfung mithilfe von regulären Ausdruck
        //1. `^`: Steht für den Beginn der Zeichenkette.
        //2. `[1-9]`: Bedeutet, dass die erste Ziffer eine Zahl von 1 bis 9 sein muss (ohne führende Null).
        //3. `[0-9]*`: Bedeutet, dass beliebig viele Ziffern von 0 bis 9 folgen können (einschließlich der Möglichkeit, keine weitere Ziffer zu haben).
        //4. `( [1-9][0-9]*){5}`: Ist eine Gruppe, die fünf Mal wiederholt wird (daher die `{5}` am Ende).
        //    Diese Gruppe beginnt mit einem Leerzeichen (``), gefolgt von einer Ziffer von 1 bis 9 und beliebig vielen weiteren Ziffern von 0 bis 9 (dies erlaubt Zahlen größer als 9).
        //5. `$`: Steht für das Ende der Zeichenkette.
        assertTrue(lotto6aus49.ausgabeTippreihe().matches("^[1-9][0-9]*( [1-9][0-9]*){5}$"));
    }

    @Test
    void ausgabeTippreihe() {
        int[] ausschlussUnglueckszahlen = {13, 42}; // Beispiel: Ausschluss der Zahlen 13 und 42
        assertDoesNotThrow(() -> lotto6aus49.erzeugeTippreihe(ausschlussUnglueckszahlen));
        assertDoesNotThrow(() -> lotto6aus49.ausgabeTippreihe());
    }
}