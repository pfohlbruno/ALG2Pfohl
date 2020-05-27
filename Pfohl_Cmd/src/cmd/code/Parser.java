package cmd.code;

import cmd.commands.Command;

/**
 * Třída sloužící pro parsování příkazů.
 * @author Bruno Pfohl
 */
public class Parser {
    /**
     * Naparsuje text na příkaz. Vrací instanci objektu příkazu.
     * @param line Text, který se má naparsovat.
     * @return Příkaz v podobě objektu typu Command.
     */
    public static Command parse(String line) {
        String[] p = line.split(" +"); // p[0] dir; p[1] -e; p[2] .java
        char first = Character.toUpperCase(p[0].charAt(0));
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1);

        // Pokusím se naparsovat text a vrátit příkaz.
        try {
            Class c =  Class.forName(name);
            Command command = (Command) c.newInstance();
            command.setParams(p);
            return command;
        }
        catch (Exception e) {
            throw new RuntimeException("Nepodařilo se příkaz naparsovat.");
        }
    }
}
