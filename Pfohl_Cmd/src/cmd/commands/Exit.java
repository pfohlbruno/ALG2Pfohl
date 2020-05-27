package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;

/**
 * Příkaz pro ukončení příkazové řádky.
 * @author Bruno Pfohl
 */
public class Exit extends Command {
    @Override
    public String execute(File actualDir, CmdInterface cmd) {
        cmd.exit();
        return "Exited cmd.";
    }

    public static String getDoc() {
        return String.format("%-7s %s %n", "exit", "Finish program cmd");
    }
}
