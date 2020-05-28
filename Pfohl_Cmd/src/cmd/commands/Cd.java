package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;

/**
 * Třída příkazu cd (change directory).
 * @author Bruno Pfohl
 */
public class Cd extends Command {
    @Override
    public String execute(File actualDir, CmdInterface cmd) {
        if (this.params.length == 2) {
            String folderName = this.params[1];

            if (folderName.equals("..")) {
                cmd.changeDirectory(actualDir.getParentFile());
                return "";
            }
            else {
                File changedDir = new File(actualDir.getAbsolutePath(), folderName);

                if (changedDir.isDirectory()) {
                    cmd.changeDirectory(changedDir);
                    return "";
                }
                else {
                    return "Directory not found.";
                }
            }
        }

        return getDoc();
    }

    public static String getDoc() {
        return
                String.format("%-7s %s %n", "cd [folder name]", "Change directory - move to a specific folder") +
                String.format("%-7s %s %n", "cd ..", "Change directory - move to the folder one level higher");
    }
}
