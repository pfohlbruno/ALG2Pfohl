package bank;

/**
 * @author Bruno Pfohl
 * Třída reprezentující firmu, klienta banky.
 */
public class Company extends Client {
    public Company(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return "firma " + this.name;
    }
}
