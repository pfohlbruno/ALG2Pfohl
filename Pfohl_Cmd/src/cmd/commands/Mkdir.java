package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;

public class Mkdir extends Command {
    @Override
    public String execute(File actualDir, CmdInterface cmd) {
        if(this.params.length == 2) {
            File dir = new File(actualDir.getAbsolutePath(), this.params[1]);

            // Pokusím se vytvořit složku v aktuálním adresáři.
            if (dir.mkdir()) {
                // Složku se podařilo vytvořit.
                return String.format("Created directory %s", dir.getAbsolutePath());
            }
            else {
                // Složka již existuje. Vypíšu chybovou hlášku.
                return "Directory cannot be created";
            }
        }

        // Nevím, jak se zachovat. Vracím nápovědu k tomuto příkazu.
        return getDoc();
    }

    public static String getDoc() {
        return String.format("%-7s %s %n", "mkdir [folder name]", "Create new folders");
    }
}
