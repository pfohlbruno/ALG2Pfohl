package filehandling;

import app.Runner;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Třída pro zapsání dat o běžcích do .dat souboru.
 * @author Bruno Pfohl
 */
public class BinaryWriterBase extends WriterBase {

    @Override
    public void saveResults(String resultFilepath, List<Runner> runners) throws IOException {
        File resultFile = new File(dataDirectory, resultFilepath);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(resultFile))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Runner runner : runners) {
                dos.writeInt(n);
                dos.writeUTF(runner.getFirstname());
                int nChars = runner.getLastname().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(runner.getLastname().charAt(i));
                }
                dos.writeLong(runner.runningTime().toNanoOfDay());
                n++;
            }
        }
    }
}