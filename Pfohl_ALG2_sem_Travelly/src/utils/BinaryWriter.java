package utils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class BinaryWriter {
    private static String filePath = "data/log.dat";

    public static void write(LocalDateTime dateTime, String message) throws IOException {
        File logFile = new File(filePath);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(logFile))){
            // Zapíšu datum
            long epochDay = dateTime.toLocalDate().toEpochDay();
            dos.writeLong(epochDay);
            // Zapíšu čas
            long nanoOfDay = dateTime.toLocalTime().toNanoOfDay();
            dos.writeLong(nanoOfDay);
            // Zapíšu zprávu
            dos.writeUTF(message);
        }
    }
}