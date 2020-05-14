package ui;

import app.dataprovider.HotelProvider;
import app.entities.Hotel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelProvider hotelProvider = null;
        try {
            hotelProvider = new HotelProvider();
        } catch (IOException e) {
            System.out.println("Nepodařilo se načíst data ze souboru.");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Vítejte v aplikaci Travelly");

        System.out.println(
                "1) Prohlížet hotely\n" +
                "2) Prohlížet zájezdy\n" +
                "3) Vaše rezervace"
        );

        System.out.print("Vaše volba: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:

        }

        List<Hotel> hotels = hotelProvider.getAll();

        for(Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }
}
