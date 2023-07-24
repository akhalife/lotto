package org.lotto;

import java.io.IOException;
import java.util.Scanner;

public class LottoCLI {

    private final Lotto6aus49 lotto6aus49 = new Lotto6aus49();
    private final Eurojackpot eurojackpot = new Eurojackpot();

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        LottoCLI lottoCLI = new LottoCLI();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" ");
            System.out.println("Willkommen im Lottoland. Wo der Spaß nie endet.");
            System.out.println(" ");
            System.out.println("======= Menü =======");
            System.out.println("1. Option: Unglückszahlen erstellen");
            System.out.println("2. Option: Unglückszahl löschen");
            System.out.println("3. Option: Unglückszahlen ausgeben");
            System.out.println("4. Option: Tippreihe für Lotto 6aus49 erzeugen");
            System.out.println("5. Option: Tippreihe für Eurojackpot erzeugen");
            System.out.println("6. Option: Tippreige für 6aus49 ausgeben");
            System.out.println("7. Option: Tippreihe für Eurojackpot ausgeben");
            System.out.println("8. Exit");
            System.out.print("Wähle eine Option (1-7): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 1 ausgewählt: Unglückszahlen erstellen");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    int[] ungluecksZahlen = lottoCLI.lesenNummernVonKommandozeile(6);

                    for (int i = 0; i <= ungluecksZahlen.length; i++){
                        try {
                            lottoCLI.ungluecksZahlenErstellen(ungluecksZahlen[i]);
                        } catch (IOException e){
                            e.getStackTrace();
                        }
                    }
                    break;

                case 2:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 2 ausgewählt: Unglückszahl löschen");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    Scanner eingabeUser = new Scanner(System.in);
                    int zuLoeschendeUnglueckszahl = eingabeUser.nextInt();

                    try {
                        lottoCLI.ungluecksZahlenLoeschen(zuLoeschendeUnglueckszahl);
                    } catch (IOException e){
                        e.getStackTrace();
                    }
                    break;

                case 3:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 3 ausgewählt: Unglückszahlen ausgeben");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    try {
                        lottoCLI.ungluecksZahlenAusgeben();
                    } catch (IOException e){
                        e.getStackTrace();
                    }
                    break;

                case 4:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 4 ausgewählt: Tippreihe für Lotto 6aus49 erzeugen");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    try {
                        lottoCLI.tippReihe6aus49Erzeugen();
                    } catch (EmptyArrayException e) {
                        e.getStackTrace();
                    }
                    break;

                case 5:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 5 ausgewählt: Tippreihe für Eurojackpot erzeugen");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    try {
                        lottoCLI.tippReiheEurojackpotErzeugen();
                    } catch (EmptyArrayException e) {
                        e.getStackTrace();
                    }
                    break;

                case 6:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 6 ausgewählt: Tippreige für 6aus49 ausgeben");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    try {
                        lottoCLI.tippReihe6aus49Ausgeben();
                    } catch (EmptyArrayException e) {
                        e.getStackTrace();
                    }
                    break;

                case 7:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 7 ausgewählt: Tippreihe für Eurojackpot ausgeben");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    try {
                        lottoCLI.tippReiheEurojackpotAusgeben();
                    } catch (EmptyArrayException e) {
                        e.getStackTrace();
                    }
                    break;

                case 8:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Programm wird beendet.");
                    System.out.println("=====================================================");
                    scanner.close();
                    return;

                default:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Ungültige Auswahl. Bitte wähle eine Option von 1 bis 7.");
                    System.out.println("=====================================================");
                    break;
            }
        }
    }

    private void ungluecksZahlenErstellen(int ungluecksZahl) throws IOException {
        Lottoschein.erstellenUnglueckszahl(ungluecksZahl);
        System.out.println("Unglückszahl: " + ungluecksZahl + " wurde gespeichert.");
    }

    private void ungluecksZahlenLoeschen(int ungluecksZahl) throws IOException {
        Lottoschein.loeschenUnglueckszahl(ungluecksZahl);
        System.out.println("Unglückszahl: " + ungluecksZahl + " wurde gelöscht.");
    }

    private void ungluecksZahlenAusgeben() throws IOException {
        System.out.println("Die Unglückszahlen lauten: ");
        Lottoschein.ausgabeUnglueckszahlen();
    }

    private void tippReihe6aus49Erzeugen() throws EmptyArrayException {
        lotto6aus49.erzeugeTippreihe(lotto6aus49.getTippReihe());
        System.out.println("Tippreihe für Lotto 6aus49 wurde erzeugt");
    }

    private void tippReiheEurojackpotErzeugen() throws EmptyArrayException {
        eurojackpot.erzeugeTippreihe(lotto6aus49.getTippReihe());
        System.out.println("Tippreihe für Eurojackpot wurde erzeugt");
    }

    private void tippReihe6aus49Ausgeben() throws EmptyArrayException {
        System.out.println("Die Tippreihe für Lotto 6aus49 lautet: ");
        System.out.println(lotto6aus49.ausgabeTippreihe());
    }

    private void tippReiheEurojackpotAusgeben() throws EmptyArrayException {
        System.out.println("Ausgabe für Eurojackpot");

        System.out.println("Die Tippreihe für 5aus50 lauten:");
        System.out.println(eurojackpot.ausgabeTippreihe());

        System.out.println("Die Tippreihe für 2von10 lauten:");
        System.out.println(eurojackpot.ausgabeZweiAusZehn());
    }


    public int[] lesenNummernVonKommandozeile(int numberOfNumbers) {
        int[] numbers = new int[numberOfNumbers];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib " + numberOfNumbers + " Unglückszahlen ein:");

        for (int i = 0; i < numberOfNumbers; i++) {
            while (true) {
                try {
                    System.out.print("Zahl " + (i + 1) + ": ");
                    numbers[i] = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
                    scanner.nextLine();
                }
            }
        }

        scanner.close();
        return numbers;
    }

    public Lotto6aus49 getLotto6aus49() {
        return lotto6aus49;
    }

    public Eurojackpot getEurojackpot() {
        return eurojackpot;
    }
}

