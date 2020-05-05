package cmd.commands;

import cmd.code.CmdInterface;

import java.io.File;
import java.util.Date;

public class Dir extends Command {
    @Override
    public String execute(File actualDir, CmdInterface cmd) {
        File[] files;
        if (this.params.length == 1) {
            files = actualDir.listFiles();
            return dirToString(files);
        }

        return "";
    }

    public static String getDoc() {
        return
                String.format("%-7s %s %n", "dir", "Display a list of files and folder") +
                String.format("%-7s %s %n", "dir [-o]", "Display an ordered list of files and folders") +
                String.format("%-7s %s %n", "dir [-e] [file extension]", "Display a list of files and folders with a specified extension") +
                String.format("%-7s %s %n", "dir [-s] [size]", "Display a list of files and folders bigger than a specified size");
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append(String.format("%s\n", file.getName()));
            }
            else {
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }

        return sb.toString();
    }
}
