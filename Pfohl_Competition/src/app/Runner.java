package app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Třída reprezentující běžce.
 * @author Bruno Pfohl
 */
public class Runner implements Comparable<Runner>{
    private int number;
    private String firstname;
    private String lastname;
    private LocalTime startTime;
    private LocalTime finishTime;
    private LocalTime explicitRunningTime;
    public static DateTimeFormatter formatterStart = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DateTimeFormatter formatterFinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    /**
     * Konstuktor pro vytvoření instance s předvyplněným číslem, křestním jménem a příjmením.
     * @param number Číslo běžce
     * @param firstname Křestní jméno běžce
     * @param lastname Příjmení běžce
     */
    public Runner(int number, String firstname, String lastname) {
        this.number = number;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    /**
     * Nastaví čas, kdy běžec vyběhl.
     * @param startTime Čas, kdy běžec vyběhl.
     */
    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, formatterStart);
    }

    /**
     * Nastaví čas, kdy běžec doběhl.
     * @param finishTime Čas, kdy běžec doběhl.
     */
    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, formatterFinish);
    }

    /**
     * Vrací číslo běžce.
     * @return číslo běžce
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Vrací křestní jméno běžce.
     * @return křestní jméno běžce
     */
    public String getFirstname() {
        return this.firstname;
    }

    /**
     * Vrací příjmení běžce.
     * @return příjmení běžce
     */
    public String getLastname() {
        return this.lastname;
    }

    /**
     * Vrací čas, kdy běžec vyběhl.
     * @return čas, kdy běžec vyběhl
     */
    public LocalTime getStartTime() {
        return this.startTime;
    }

    /**
     * Vrací čas, kdy běžec doběhl.
     * @return čas, kdy běžec doběhl.
     */
    public LocalTime getFinishTime() {
        return this.finishTime;
    }

    /**
     * Vrací zformátovaný čas, kdy běžec vyběhl.
     * @return zformátovaný čas, kdy běžec vyběhl
     */
    public String getStartTimeString(){
        return this.startTime.format(this.formatterStart);
    }

    /**
     * Vrací zformátovaný čas, kdy běžec doběhl.
     * @return zformátovaný čas, kdy běžec doběhl
     */
    public String getFinishTimeString(){
        return this.finishTime.format(this.formatterStart);
    }

    /**
     * Vrací objekt pro zformátování času, kdy běžec vyběhl.
     * @return objekt pro zformátování času, kdy běžec vyběhl
     */
    public static DateTimeFormatter getFormatterStart() {
        return formatterStart;
    }

    /**
     * Vrací objekt pro zformátování času, kdy běžec doběhl.
     * @return objekt pro zformátování času, kdy běžec doběhl
     */
    public static DateTimeFormatter getFormatterFinish() {
        return formatterFinish;
    }

    /**
     * Vrací celkový čas běhu (vypočítaný).
     * @return celkový čas běhu jako LocalTime
     */
    public LocalTime computedRunningTime(){
        return this.explicitRunningTime != null ? this.explicitRunningTime : LocalTime.ofNanoOfDay(this.finishTime.toNanoOfDay() - this.startTime.toNanoOfDay());
    }

    /**
     * Vrací celkový čas běhu (explicitní).
     */
    public LocalTime getExplicitRunningTime() {
        return this.explicitRunningTime;
    }

    /**
     * Nastaví explicitně celkový čas běhu.
     */
    public void setExplicitRunningTime(LocalTime explicitRunningTime) {
        this.explicitRunningTime = explicitRunningTime;
    }

    @Override
    public String toString() {
        return String.format("%-4d%-10s%-10s%-15s%-15s%-15s", this.number, this.firstname, this.lastname, getStartTimeString(),
                getFinishTimeString(),  computedRunningTime().format(formatterFinish));
    }

    @Override
    public int compareTo(Runner r) {
        return this.computedRunningTime().compareTo(r.computedRunningTime());
    }


    /**
     * Main metoda určená pro testování třídy.
     */
    public static void main(String[] args) {
        Runner r = new Runner(101, "Lukáš", "Pipkin");
        r.setStartTime("07:00:00");
        r.setFinishTime("08:20:04:002");
        System.out.println(r);
    }
}