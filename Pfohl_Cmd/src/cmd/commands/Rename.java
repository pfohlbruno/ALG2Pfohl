package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;

public class Rename extends Command {
    @Override
    public String execute(File actualDir, CmdInterface cmd) {
        if(this.params.length == 3) {
            File source = new File(actualDir.getAbsolutePath(), this.params[1]);
            File dest = new File(actualDir.getAbsolutePath(), this.params[2]);

            // Zkontroluji, jestli původní soubor existuje.
            if (source.exists()) {
                // Pokusím se přejmenovat soubor/složku.
                if (source.renameTo(dest)) {
                    return String.format("%s has been renamed to %s.", source.getAbsolutePath(), dest.getAbsolutePath());
                }
                else {
                    // Pokud již existuje soubor či složka se zvoleným názvem, vrátím chybovou hlášku.
                    return String.format("Folder or file at destination %s already exists. Please choose a different output name.", dest.getAbsolutePath());
                }
            } else {
                // Pokud původní soubor neexistuje, vrátím chybu.
                return String.format("File or folder %s doesnt exist.", source.getAbsolutePath());
            }
        }

        // Nevím, jak se zachovat. Vrátím dokumentaci tohoto příkazu.
        return getDoc();
    }

    public static String getDoc() {
        return String.format("%-7s %s %n", "rename [nameFrom] [nameTo]", "Rename folder or file");
    }
}
