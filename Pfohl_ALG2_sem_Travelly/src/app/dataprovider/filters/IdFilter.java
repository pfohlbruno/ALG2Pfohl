package app.dataprovider.filters;

import app.entities.EntityBase;
import com.opencsv.bean.CsvToBeanFilter;
import com.opencsv.bean.MappingStrategy;

public class IdFilter implements CsvToBeanFilter {
    private final MappingStrategy strategy;
    private int id;

    public IdFilter(MappingStrategy strategy, int id) {
        this.strategy = strategy;
        this.id = id;
    }

    @Override
    public boolean allowLine(String[] line) {
        try {
            EntityBase entity = (EntityBase) strategy.populateNewBean(line);
            return entity.getId() == this.id;
        }
        catch (Exception e) {
            return false;
        }
    }
}
