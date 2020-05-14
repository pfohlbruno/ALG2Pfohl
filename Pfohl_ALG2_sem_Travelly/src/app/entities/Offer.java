package app.entities;

import app.enums.ServiceTypeEnum;
import app.enums.TransportTypeEnum;
import com.opencsv.bean.CsvBindByName;

import java.util.Date;

/**
 * Třída reprezentující nabídku dovolené.
 * @author Bruno Pfohl
 */
public class Offer extends EntityBase
{
    @CsvBindByName
    private int hotelId;
    @CsvBindByName
    private int price;
    @CsvBindByName
    private Date from;
    @CsvBindByName
    private Date to;
    @CsvBindByName
    private TransportTypeEnum transportType;
    @CsvBindByName
    private ServiceTypeEnum serviceType;
    @CsvBindByName
    private int capacity;
    @CsvBindByName
    private int usedCapacity;

    /**
     * Prázdný konstruktor pro CSV binder.
     */
    public Offer() {

    }

    public Offer(String id, int hotelId, int price, Date from, Date to, TransportTypeEnum transportType, ServiceTypeEnum serviceType, int capacity, int usedCapacity) {
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
    public int getHotelId() {
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

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    /**
     * Vrací, kolik volných míst zbývá k zarezervování.
     */
    public int availableCapacity() {
        return usedCapacity;
    }
}
