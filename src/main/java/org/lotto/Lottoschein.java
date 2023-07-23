package org.lotto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Lottoschein {

    public static void erstellenUnglueckszahl (int zahlHinzufuegen) throws IOException {

        if(zahlHinzufuegen < 1 || zahlHinzufuegen > 50){
            throw new IOException("Die eingegebene Zahl befindet sich nicht im gültigen Zahlenraum." +
                    "\nBitte geben Sie eine Zahl zwischen 1 und 50 ein");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Unglueckszahlen.txt",
                true))) {
            bufferedWriter.write(String.valueOf(zahlHinzufuegen));
            bufferedWriter.newLine();

            System.out.println("Die Zahl " + zahlHinzufuegen + " wurde in der Liste hinzugefügt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loeschenUnglueckszahl(int zahlZuLoeschen) throws IOException{

        if(zahlZuLoeschen < 1 || zahlZuLoeschen > 50){
            throw new IOException("Die eingegebene Zahl befindet sich nicht im gültigen Zahlenraum." +
                    "\nBitte geben Sie eine Zahl zwischen 1 und 50 ein");
        }

        // Den Inhalt der Datei lesen und die Zahl entfernen
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Unglueckszahlen.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Wenn die Zeile nicht die zu löschende Zahl enthält, füge sie der Liste hinzu
                if (!line.contains(String.valueOf(zahlZuLoeschen))) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Die Datei mit dem aktualisierten Inhalt überschreiben
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Unglueckszahlen.txt"))) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
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

