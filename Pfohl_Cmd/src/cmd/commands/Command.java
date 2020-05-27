package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;

/**
 * Bázová třída příkazu.
 * @author Bruno Pfohl
 */
public abstract class Command {
    public static String COMMAND_PACKAGE = "cmd.commands";
    protected String[] params; // dir | -e | .java |

    /**
     * Uloží parametry příkazu.
     * @param params parametry příkazu
     */
    public void setParams(String[] params) {
        this.params = new String[params.length];
        System.arraycopy(params, 0, this.params, 0, params.length);
    }

    /**
     * Spustí příkaz.
     * @param file aktuální pracovní složka příkazové řádky
     * @param cmd instance příkazové řádky
     */
    public abstract String execute(File file, CmdInterface cmd);
}
