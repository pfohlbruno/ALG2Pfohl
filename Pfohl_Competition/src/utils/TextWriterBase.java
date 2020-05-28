package utils;

import app.Runner;

import java.io.*;
import java.util.List;

/**
 * Třídá pro zapsání dat o běžcích do txt souboru.
 * @author Bruno Pfohl
 */
public class TextWriterBase extends WriterBase {
    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        File resultFile = new File(dataDirectory, resultFilepath);
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(resultFile, true))) { // append mode (přidává)
            pw.println("Nové výsledky");

            // Zapíšu závodníky jednoho po druhém do souboru.
            for (int i = 1; i <= runners.size(); i++) {
                pw.print(i + ". ");
                pw.println(runners.get(i).toString());
            }
        }
    }
}