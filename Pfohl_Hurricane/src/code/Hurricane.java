package code;

public class Hurricane {
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;

    public Hurricane(int year, String month, int pressure, int speed, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = speed;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeedInKmH () {
        // Desetinná místa usekávám.
        return (int)(this.speed * 1.852f);
    }

    public int getCategory () {
        int category = -1;
        double speed = getSpeedInKmH();

        if (speed >= 252) {
            category = 5;
        }
        else if (speed >= 209) {
            category = 4;
        }
        else if (speed >= 178) {
            category = 3;
        }
        else if (speed >= 154) {
            category = 2;
        }
        else if (speed >= 74) {
            category = 1;
        }

        return category;
    }
}
