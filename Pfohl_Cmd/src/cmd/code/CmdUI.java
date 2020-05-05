package cmd.code;

import cmd.app.CmdEditor;

import java.util.Scanner;

public class CmdUI {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CmdInterface cmd = new CmdEditor();

        String line;
        while(cmd.isRunning()) {
            System.out.print(cmd.getActualDir() + "$ ");
            line = sc.nextLine();
            try {
                System.out.println(cmd.parseAndExecute(line, cmd));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
