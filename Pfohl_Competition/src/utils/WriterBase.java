package utils;

import app.Runner;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Bázová třída pro writer.
 * @author Bruno Pfohl
 */
public abstract class WriterBase {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");

    /**
     * Uloží data u běžcích do souboru.
     * @param resultFilepath cesta k souboru
     * @param runners kolekce běžců
     */
    public abstract void saveResults(String resultFilepath, List<Runner> runners) throws IOException;
}
