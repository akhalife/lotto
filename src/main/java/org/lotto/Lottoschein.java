package org.lotto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Lottoschein {

    public static void erstellenUnglueckszahl (int zahlHinzufuegen) throws IOException {

        if(zahlHinzufuegen < 1 || zahlHinzufuegen > 50){
            throw new IOException("Die eingegebene Zahl " + zahlHinzufuegen +" befindet sich nicht im gültigen Zahlenraum." +
                    "\nBitte geben Sie eine Zahl zwischen 1 und 50 ein\n");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Unglueckszahlen.txt",
                true))) {
            bufferedWriter.write(String.valueOf(zahlHinzufuegen));
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void loeschenUnglueckszahl(int zahlZuLoeschen) throws IOException, UnglueckszahlNotFoundException {
        if (zahlZuLoeschen < 1 || zahlZuLoeschen > 50) {
            throw new IOException("Die eingegebene Zahl befindet sich nicht im gültigen Zahlenraum." +
                    "\nBitte geben Sie eine Zahl zwischen 1 und 50 ein");
        }

        // Den Inhalt der Datei lesen und die Zahl entfernen
        List<String> lines = new ArrayList<>();
        boolean zahlGefunden = false;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Unglueckszahlen.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Wenn die Zeile nicht die zu löschende Zahl enthält, wird sie in die Liste hinzugefuegt
                if (!line.contains(String.valueOf(zahlZuLoeschen))) {
                    lines.add(line);
                } else {
                    zahlGefunden = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (!zahlGefunden) {
            throw new UnglueckszahlNotFoundException("Die eingegebene Unglückszahl " + zahlZuLoeschen +
                    " wurde in nicht gefunden und kann daher nicht gelöscht werden.");
        }

        // Den aktualisierten Inhalt in die Datei schreiben
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Unglueckszahlen.txt"))) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public static void ausgabeUnglueckszahlen() throws IOException{
        if (new File("Unglueckszahlen.txt").length() == 0) {
            System.err.println("Es sind noch keine Unglückszahlen vorhanden, bitte füge welche hinzu.");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("Unglueckszahlen.txt"))) {
                for (String line; (line = reader.readLine()) != null;) {
                    System.out.print(line + " ");
                }
            }
        }
    }

}

