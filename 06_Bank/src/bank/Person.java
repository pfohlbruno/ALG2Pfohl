package bank;

/**
 * @author Bruno Pfohl
 * Třída reprezentující člověka, klienta banky.
 */
public class Person extends Client{
    public Person(String name) {
        super(name);
    }

    @Override
    public String getName() {
        // Zjistím podle koncovky jména, zda se jedná o ženu.
        boolean isFemale = this.name.substring(this.name.length() - 3).equals("ova");
        // Dle pohlaví osoby určím její oslovení a vrátím zkonstruované jméno.
        return (isFemale ? "paní " : "pan ") + this.name;
    }
}
