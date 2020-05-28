package app;

import utils.BinaryWriterBase;
import utils.TextWriterBase;
import utils.WriterBase;

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

    /**
     * Načte seznam závodníků ze souboru do kolekce.
     * @param startFilepath Cesta k souboru startu
     * @param finishFilepath Cesta k souboru cíle
     */
    public void load(String startFilepath, String finishFilepath) throws FileNotFoundException, IOException, Exception {
        // Název start souboru musí obsahovat "start", jinak program vyhodí výjimku
        if(!startFilepath.contains("start")){
            throw new Exception("Start soubor musí obsahovat start.");
        }

        // Ze souboru načítám pomocí Scanneru.
        try (Scanner inStart = new Scanner(new File(startFilepath))) {
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

        // Soubor cíle pro změnu načítám pomocí BufferedReaderu.
        BufferedReader inFinish = null;
        try {
            // Vytvořím si BufferedReader pro čtení ze souboru.
            inFinish = new BufferedReader(new FileReader(new File(finishFilepath)));
            String line;
            // Postupně načítám řádky, dokud je co načítat.
            while ((line = inFinish.readLine()) != null) {
                // Od každé řádky očekávám, že bude vypadat takto "cislo cas" (100 09:11:01:024)

                // Rozdělím pomocí libovolně dlouhých mezer.
                String[] parts = line.split("[ ]+");

                // Pokusím se v kolekci běžců nalézt bežce a nastavit mu konečný čas.
                try {
                    Runner r = findRunner(Integer.parseInt(parts[0]));
                    r.setFinishTime(parts[1]);
                } catch (NoSuchElementException e) {
                    System.err.print(e.getMessage()); // Neexistujici běžec se přeskočí (do err výstupu se vypíše chyba).
                }
            }
        }finally{
            // Po načtení "uzavřu" soubor.
            if(inFinish != null) inFinish.close();
        }
    }

    /**
     * Vrací závodníka s daným startovním číslem.
     * @param number startovní číslo závodníka
     * @return Závodník
     */
    private Runner findRunner(int number) {
        for (Runner runner : this.runners) {
            if (runner.getNumber() == number) {
                return runner;
            }
        }

        // Pokud běžeč není v seznamu běžců na startu, vyhodím výjimku.
        throw new NoSuchElementException("Běžeč s číslem " + number + " nebyl na startu.");
    }

    /**
     * Vrací zformátovaný výstup této třídy (seznam běžců s jejich časy seřazený dle celkového času).
     * @return
     */
    public String getResults() {
        // Setřídím běžce.
        Collections.sort(this.runners);
        StringBuilder sb = new StringBuilder("");
        int n = 1;
        for (Runner runner : this.runners) {
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
        // Před uložením běžce setřídím.
        Collections.sort(this.runners);

        // Vytvořím instanci writeru dle toho, jestli se jedná o textový nebo binární soubor.
        WriterBase w = null;
        if (resultFilepath.endsWith(".txt")) {
            w = new TextWriterBase();
        } else if (resultFilepath.endsWith(".dat")) {
            w = new BinaryWriterBase();
        } else {
            throw new IllegalArgumentException("Typ výstupního není podporován.");
        }

        // Uložím výsledky soutěže do souboru (zapíšu).
        w.saveResults(resultFilepath, this.runners);
    }
}