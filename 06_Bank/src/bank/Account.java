package bank;

/**
 * @author Bruno Pfohl
 * Třída reprezentující bankovní účet bez možnosti přečerpání.
 * Operace
 * - přidání prostředků
 * - odebrání prostředků
 * - zjištění dostupných prostředků
 */
public class Account {

    private double balance;


    /**
     * Konstruktor pro vytvoření účtu bez počátečního vkladu.
     */
    public Account() {
        this.balance = 0;
    }

    /**
     * Konstruktor pro vytvoření účtu s počátečním vkladem.
     * @param initialDeposit počáteční vklad.
     */
    public Account(double initialDeposit) {
        this.balance = initialDeposit;
    }

    /**
     * Přidá prostředky na tento bankovní účet. Lze přidat jen kladnou částku.
     * @param amount Částka, která se má na účet přidat.
     * @throws Exception Výjimka, která nastane při pokusu o přidání záporné či nulové částky.
     */
    public void deposit(double amount) throws Exception {
        if (amount <= 0){
            throw new Exception("Deposit amount is negative or zero.");
        }

        this.balance += amount;
    }

    /**
     * Vybere z účtu prostředky ve specifikované výši. Výše vybíraných prostředků nesmí překročit dostupný počet prostředků.
     * @param amount Částka, které se má z účtu vybrat.
     * @throws Exception Výjimka, která nastane při pokusu o přidání záporné či nulové  částky.
     */
    public void withdraw(double amount) throws Exception {
        if (amount <= 0){
            throw new Exception("Withdraw amount is negative or zero.");
        }

            this.balance -= amount;
    }

    /**
     * Vrací počet aktuálně dostupných prostředků.
     * @return Celkový počet prostředků na účtu.
     */
    public double getBalance() {
        return balance;
    }
}
