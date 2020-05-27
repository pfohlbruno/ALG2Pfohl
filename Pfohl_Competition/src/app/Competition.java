package app;

import filehandling.BinaryWriterBase;
import filehandling.TextWriterBase;
import filehandling.WriterBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Třída reprezentující soutěž běžců.
 * @author Bruno Pfohl
 */
public class Competition {
    private ArrayList<Runner> runners = new ArrayList<>();

    public void load(String startFilepath, String finishFilepath) throws FileNotFoundException, IOException, Exception {
        if(!startFilepath.contains("start")){
            throw new Exception("Start soubor musí obsahovat start.");
        }

        // Ze souboru načítám pomocí Scanneru.
        File startFile = new File(startFilepath);
        try (Scanner inStart = new Scanner(startFile)) {
            // Dokud je co číst...
            while (inStart.hasNext()) {
                int number = inStart.nextInt(); // Přečtu číslo běžce
                String firstname = inStart.next(); // Přečtu křestní jméno běžce
                String lastname = inStart.next(); // Přečtu příjmení běžce
                String startTime = inStart.next(); // Přečtu čas, kdy vyběhnul

                // Vytvořím běžce z přečtených dat.
                Runner r = new Runner(number, firstname, lastname);

                // Nastavím čas, kdy vyběhnul.
                r.setStartTime(startTime);

                // Přidám běžce do kolekce.
                runners.add(r);
            }
        }

        // Cílové časy pro změnu načítám pomocí BufferedReaderu.
        File finishFile = new File(finishFilepath);
        BufferedReader inFinish = null;
        try {
            inFinish = new BufferedReader(new FileReader(finishFile));
            String line;
            while ((line = inFinish.readLine()) != null) { //102 10:02:00:000
                String[] parts = line.split("[ ]+");
                try { //ošetření výjimky odchycenim
                    Runner r = findRunner(Integer.parseInt(parts[0]));
                    r.setFinishTime(parts[1]);
                } catch (NoSuchElementException e) {
                    System.err.print(e.getMessage()); //neexistujici bezec se preskoci
                }
            }
        }finally{
            if(inFinish != null) inFinish.close();
        }
    }

    private Runner findRunner(int number) {
        for (Runner runner : runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }
        throw new NoSuchElementException("Bezec s cislem " + number + " nebyl na startu."); //vyhozeni výjimky
    }

    public String getResults() {
        // Setřídím běžce.
        Collections.sort(runners);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Runner runner : runners) {
            sb.append(String.format("%-2d. %s%n", n, runner));
            n++;
        }
        return sb.toString();
    }

    /**
     * Metoda, která uloží běžce do specifikovaného souboru.
     * @param resultFilepath cesta k cílovému souboru na disku
     */
    public void saveResults(String resultFilepath) throws IOException {
        // Setřídím běžce.
        Collections.sort(this.runners);
        WriterBase w = null;

        // Vytvořím instanci writeru dle toho, jestli se jedná o textový nebo binární soubor.
        if (resultFilepath.endsWith(".txt")) {
            w = new TextWriterBase();
        } else if (resultFilepath.endsWith(".dat")) {
            w = new BinaryWriterBase();
        } else {
            throw new IllegalArgumentException("Nepodporovana pripona souboru");
        }
        w.saveResults(resultFilepath, this.runners);
    }
}