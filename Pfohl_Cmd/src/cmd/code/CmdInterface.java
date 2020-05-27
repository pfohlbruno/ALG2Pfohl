package cmd.code;

import java.io.File;

/**
 * @author Bruno Pfohl
 */
public interface CmdInterface {
    /**
     * Vrací, jestli příkazová řádka běží.
     */
    public Boolean isRunning();

    /**
     * Vrací složku, ve které se aktuálně příkazová řádka nachází.
     */
    public String  getActualDir();

    /**
     * Naparsuje příkaz a spustí ho.
     * @param line uživatelem zadaný text
     * @param cmd instance příkazové řádky
     */
    public String parseAndExecute(String line, CmdInterface cmd);

    /**
     * Změní aktuální pracovní složku příkazového řádku.
     * @param directory Složka, do které má příkazový řádek přejít.
     */
    public void changeDirectory(File directory);

    /**
     * Ukončí příkazový řádek.
     */
    public void exit();
}
