package utils;

import app.Runner;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Třída pro zapsání dat o běžcích do .dat souboru (v binární podobě).
 * @author Bruno Pfohl
 */
public class BinaryWriterBase extends WriterBase {

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(dataDirectory, resultFilepath)))){
            dos.writeUTF("Nové výsledky");

            // Postupně zapíšu závodníky jednoho po druhém do souboru.
            int n = 1;
            for (Runner runner : runners) {
                // Zapíšu číslo závodníka.
                dos.writeInt(n);
                // Zapíšu jméno závodníka.
                dos.writeUTF(runner.getFirstname());
                // Zapíšu příjmení závodníka.
                dos.writeUTF(runner.getLastname());
                // Zapíšu výsledný čas závodníka.
                dos.writeLong(runner.computedRunningTime().toNanoOfDay());
                n++;
            }
        }
    }
}