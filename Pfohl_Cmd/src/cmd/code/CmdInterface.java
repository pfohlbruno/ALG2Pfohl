package cmd.code;

import java.io.File;

/**
 * @author Bruno Pfohl
 */
public interface CmdInterface {
    public Boolean isRunning();
    public String  getActualDir();
    public String parseAndExecute(String line, CmdInterface cmd);
    public void changeDirectory(File directory);
    public void exit();
}
