package org.lotto;

import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

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
            System.out.println("Willkommen im L O T T O L A N D. Wo der Spaß nie endet.");
            System.out.println(" ");
            System.out.println("======= Menü =======");
            System.out.println("Option 1: Unglückszahlen erstellen");
            System.out.println("Option 2: Unglückszahl löschen");
            System.out.println("Option 3: Unglückszahlen ausgeben");
            System.out.println("Option 4: Tippreihe für Lotto 6aus49 erzeugen");
            System.out.println("Option 5: Tippreihe für Eurojackpot erzeugen");
            System.out.println("Option 6: Tippreihe für 6aus49 ausgeben");
            System.out.println("Option 7: Tippreihe für Eurojackpot ausgeben");
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
                    System.out.println("Gib eine Zahl zwischen 1 und 50 ein:");

                    String dateiName = "Unglueckszahlen.txt";
                    int anzahlUnglueckszahlen;

                    try {
                        anzahlUnglueckszahlen = checkZeilenAnzahl(dateiName);
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                        break;
                    }

                    int[] ungluecksZahlen = lottoCLI.lesenNummernVonKommandozeile(anzahlUnglueckszahlen);

                    for (int j : ungluecksZahlen) {
                        try {
                            lottoCLI.ungluecksZahlenErstellen(j);
                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }
                    }

                    System.out.println(" ");
                    break;

                case 2:
                    System.out.println(" ");
                    System.out.println("=====================================================");
                    System.out.println("Du hast Option 2 ausgewählt: Unglückszahl löschen");
                    System.out.println("=====================================================");
                    System.out.println(" ");

                    System.out.println("Hast du dir die vorhandenen Unglückszahlen angeschaut?");
                    System.out.println(" ");
                    System.out.println("Gib 1 für Ja ein");
                    System.out.println("Gib 2 für Nein ein");
                    System.out.println(" ");

                    int auswahl = scanner.nextInt();

                    if(auswahl == 2){
                        System.out.println(" ");
                        System.out.println("Lass dir die vorhandenen Unglückszahlen erstmal mit der Option 3 ausgeben und dann suche die " +
                                "entsprechende zu löschende Zahl aus");
                        break;
                    }

                    System.out.println("Wähle deine zu löschende Zahl aus den vorhandenen Unglückszahlen:");

                    int zuLoeschendeUnglueckszahl = scanner.nextInt();

                    try {
                        lottoCLI.ungluecksZahlenLoeschen(zuLoeschendeUnglueckszahl);
                    } catch (IOException | UnglueckszahlNotFoundException e){
                        System.err.println(e.getMessage());
                    }

                    System.out.println(" ");

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
                        System.err.println(e.getMessage());
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
                        System.err.println(e.getMessage());
                    }

                    System.out.println(" ");

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
                        System.err.println(e.getMessage());
                    }

                    System.out.println(" ");

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
                        System.err.println(e.getMessage());
                    }

                    System.out.println(" ");

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
                        System.err.println(e.getMessage());
                    }

                    System.out.println(" ");

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

    private void ungluecksZahlenLoeschen(int ungluecksZahl) throws IOException, UnglueckszahlNotFoundException {
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

    public int[] lesenNummernVonKommandozeile(int anzahlUnglueckszahlen) {
        int[] numbers = new int[anzahlUnglueckszahlen];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib " + anzahlUnglueckszahlen + " Unglückszahlen ein:");

        for (int i = 0; i < anzahlUnglueckszahlen; i++) {
            while (true) {
                try {
                    System.out.print("Zahl " + (i + 1) + ": ");
                    numbers[i] = scanner.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println(" ");
                    System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
                    scanner.nextLine();
                }
            }
        }

        return numbers;
    }

    private static int checkZeilenAnzahl(String dateiName) throws IOException {
        int anzahlZeilen = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dateiName))) {
            while (bufferedReader.readLine() != null) {
                anzahlZeilen++;
                if (anzahlZeilen > 5) {
                    throw new IOException("Es befinden sich mehr als 6 Unglückszahlen. Lösche eine Unglückszahl um eine " +
                            "neue hinzuzufügen.");
                }
            }
        }
        return 6 - anzahlZeilen;
    }

}



