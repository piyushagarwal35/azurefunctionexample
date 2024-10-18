package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.ChargeCategory;
import org.example.functions.enums.ChargeFrequency;

public class ChargeCategoryConverter extends AbstractBeanField<ChargeCategory,String> {

    @Override
    protected ChargeCategory convert(String value) {
        return ChargeCategory.fromString(value);
    }

}
