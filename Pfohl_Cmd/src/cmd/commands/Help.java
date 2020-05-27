package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;

/**
 * Příkaz pro vypsání pomoci.
 * @author Bruno Pfohl
 */
public class Help extends Command {
    @Override
    public String execute(File actualDir, CmdInterface cmd) {
        String help =
                "=== HELP ===\n" +
                Cd.getDoc() +
                Dir.getDoc() +
                Mkdir.getDoc() +
                Rename.getDoc() +
                Help.getDoc() +
                Exit.getDoc();

        return help;
    }

    public static String getDoc() {
        return String.format("%-7s %s", "help", "Display help");
    }
}
