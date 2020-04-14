package app;

import bank.Client;
import bank.Company;
import bank.Person;

import java.util.ArrayList;

/**
 * @author Bruno Pfohl
 * Program, který "simuluje" funkci banky.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        // Vytvořím si pole klientů.
        ArrayList<Client> clients = new ArrayList<Client>();

        // Vytvořím osobu 'Pekař' a přidám ji 2 účty.
        Person man = new Person("Pekar");
        man.addAccount(1000);
        man.addAccount(500);
        clients.add(man);

        // Vytvořím osobu 'Svecova' a přidám ji účet.
        Person woman = new Person("Svecova");
        woman.addAccount(1200);
        clients.add(woman);

        // Vytvořím firmu 'Skoda' a přidám ji účet.
        Company company = new Company("Skoda");
        company.addAccount(120);
        clients.add(company);

        // Vypíšu seznam klientů (oslovení a jejich zůstatek).
        for (Client client : clients) {
            System.out.format("{%s, %.4f}%n", client.getName(), client.getTotalBalance());
        }
    }
}
