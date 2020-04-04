package bank;

import java.util.ArrayList;

/**
 * @author Bruno Pfohl
 * Třída reprezentující klienta banky.
 * Operace
 * - přidání bankovního účtu
 * - zjištění celkového počtu prostředků
 * - získání názvu klienta
 */
public abstract class Client {
    protected String name;
    private ArrayList<Account> accounts;

    /**
     * Konstruktor pro vytvoření klienta s daným názvem.
     * @param name Název klienta.
     */
    public Client(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Přidá klientovi nový bankovní účet se specifikovaným počátečním vkladem.
     * @param initialDeposit Počáteční částka, která se má na účet vložit.
     * @throws Exception
     */
    public void addAccount(double initialDeposit) throws Exception {
        if (initialDeposit <= 0) {
            throw new Exception("Initial deposit is negative or zero.");
        }

        this.accounts.add(new Account(initialDeposit));
    }

    /**
     * Vrací celkový počet prostředků napříč všemi účty, kterými klient disponuje.
     * @return Celkový počet dostupných prostředků.
     */
    public double getTotalBalance() {
        double total = 0;

        for (Account account : this.accounts) {
            total += account.getBalance();
        }

        return total;
    }

    /**
     * Vrací název klienta.
     * @return Název klienta.
     */
    public abstract String getName();
}
