package app.entities;

import app.enums.ServiceTypeEnum;
import app.enums.TransportTypeEnum;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;
import utils.csv.converters.ServiceTypeEnumConverter;
import utils.csv.converters.TransportTypeEnumConverter;

import java.util.Date;

/**
 * Třída reprezentující nabídku dovolené.
 * @author Bruno Pfohl
 */
public class Offer extends EntityBase
{
    @CsvBindByName
    private String hotelId;

    @CsvBindByName
    private int price;

    @CsvBindByName
    @CsvDate(value = "dd-MM-yyyy")
    private Date from;

    @CsvBindByName
    @CsvDate(value = "dd-MM-yyyy")
    private Date to;

    @CsvCustomBindByName(column = "transportType", converter = TransportTypeEnumConverter.class)
    private TransportTypeEnum transportType;

    @CsvCustomBindByName(column = "serviceType", converter = ServiceTypeEnumConverter.class)
    private ServiceTypeEnum serviceType;

    @CsvBindByName
    private int capacity;

    @CsvBindByName
    private int usedCapacity;

    // Název hotelu. Není uchováván v CSV souboru.
    private String hotelName;

    /**
     * Prázdný konstruktor pro CSV binder.
     */
    public Offer() {

    }

    public Offer(String id, String hotelId, int price, Date from, Date to, TransportTypeEnum transportType, ServiceTypeEnum serviceType, int capacity, int usedCapacity) {
        super(id);
        this.hotelId = hotelId;
        this.price = price;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.serviceType = serviceType;
        this.capacity = capacity;
        this.usedCapacity = usedCapacity;
    }

    /**
     * Vrací unikátní identifikátor hotelu.
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     * Vrací cenu zájezdu (jako celé číslo).
     */
    public int getPrice() {
        return price;
    }

    /**
     * Vrací datum začátku zájezdu.
     */
    public Date getFrom() {
        return from;
    }

    /**
     * Vrací datum konce zájezdu.
     */
    public Date getTo() {
        return to;
    }

    /**
     * Vrací typ dopravy (autem, letadlem, vlastní doprava, ...)
     */
    public TransportTypeEnum getTransportType() {
        return transportType;
    }

    /**
     * Vrací typ zájezdu (polopenze, plná penze, all inclusive, ...).
     */
    public ServiceTypeEnum getServiceType() {
        return serviceType;
    }

    /**
     * Vrací max. kapacitu zájezdu (kolik lidí se může zúčastnit).
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Vrací aktuálně využitou kapacitu zájezdu (kolik lidí ho má momentálně rezervováno).
     */
    public int getUsedCapacity() {
        return usedCapacity;
    }


    public void useCapacity(int count) throws Exception{
        // Zkontroluji, jestli je dostatek míst.
        if (count > getAvailableCapacity()) {
            throw new Exception(String.format(
                    "Došlo k pokusu o využití více volných míst nabídky (Offer:%s), která jich však nemá dostatek.",
                    this.id
            ));
        }

        // Provedu snížení dostupných míst.
        this.usedCapacity += count;
    }

    public void freeCapacity(int count) throws Exception{
        // Zkontroluji, jestli je možno uvolnit požadovaný počet míst.
        if (count > this.usedCapacity) {
            throw new Exception(String.format(
                    "Došlo k pokusu o uvolnění míst u nabídky (Offer:%s). Počet aktuálně zabraných míst je ale nižší.",
                    this.id
            ));
        }

        // Provedu navýšení dostupných míst.
        this.usedCapacity -= count;
    }

    /**
     * Vrací, kolik volných míst zbývá k zarezervování.
     */
    public int getAvailableCapacity() {
        return this.capacity - this.usedCapacity;
    }
}
