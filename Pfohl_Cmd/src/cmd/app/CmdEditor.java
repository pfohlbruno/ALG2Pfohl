package cmd.app;

import cmd.code.CmdInterface;
import cmd.commands.Command;
import cmd.code.Parser;

import java.io.File;

/**
 * Třída reprezentující vlastní implementaci příkazové řádky.
 * @author Bruno Pfohl
 */
public class CmdEditor implements CmdInterface {
    private boolean isRunning;
    private File actualDir;
    private Command command;

    public CmdEditor() {
        this.isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
    }

    @Override
    public Boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }

    @Override
    public void exit() {
        this.isRunning = false;
    }

    @Override
    public String parseAndExecute(String line, CmdInterface cmd) {
        // parse
        command = Parser.parse(line);
        // execute
        return command.execute(this.actualDir, cmd);
    }

    @Override
    public void changeDirectory(File directory) {
        this.actualDir = directory;
    }
}
