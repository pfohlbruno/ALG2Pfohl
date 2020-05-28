package utils.csv.converters;

import app.enums.ServiceTypeEnum;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * Konvertor pro převod textového řetězce na hodnotu typu ServiceTypeEnum.
 * @author Bruno Pfohl
 */
public class ServiceTypeEnumConverter extends AbstractBeanField<ServiceTypeEnum, String> {
    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        try {
            return ServiceTypeEnum.valueOf(value);
        } catch (RuntimeException e) {
            throw new CsvDataTypeMismatchException(e.getMessage());
        }
    }
}