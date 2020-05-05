package cmd.commands;

import cmd.app.CmdEditor;
import cmd.code.CmdInterface;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;

public abstract class Command {
    public static String COMMAND_PACKAGE = "cmd.commands";
    protected String[] params; // dir | -e | .java |

    public void setParams(String[] params) {
        this.params = new String[params.length];
        System.arraycopy(params, 0, this.params, 0, params.length);
    }

    public abstract String execute(File file, CmdInterface cmd);
}
