package filehandling;

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
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(resultFile, true)))) {
            pw.println("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                pw.print(n + ". ");
                pw.println(runner.toString());
                n++;
            }
        }
    }
}