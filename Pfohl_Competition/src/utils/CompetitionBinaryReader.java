package utils;

import app.Runner;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Třída sloužící pro načtení výsledků závodu z binárního souboru.
 */
public class CompetitionBinaryReader {
    public static void main(String[] args) {
        try {
            // Načtu výsledkovou listinu ze souboru (seznam závodníků a jejich časů).
            List<Runner> runners = getRunners("data/result.dat");

            // Vypíšu výsledky do konzole.
            for (Runner runner : runners) {
                System.out.println(runner.toString());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Runner> getRunners(String resultFilepath) throws FileNotFoundException, IOException{
        List<Runner> runners = new ArrayList<>();

        try(DataInputStream dis = new DataInputStream(new FileInputStream(resultFilepath))){
            boolean isEnd = false;
            System.out.println(dis.readUTF());
            while(!isEnd){
                try{
                    int number = dis.readInt();                                     // startovní číslo
                    String firstname = dis.readUTF();                               // křestní jméno
                    String lastname = dis.readUTF();                                // příjmení
                    LocalTime runningTime = LocalTime.ofNanoOfDay(dis.readLong());  // výsledný čas

                    Runner runner = new Runner(number, firstname, lastname);
                    runner.setExplicitRunningTime(runningTime);
                    runners.add(runner);
                }catch(EOFException e){ //zjištění konce souboru
                    isEnd = true;
                }
            }
        }

        return runners;
    }
}