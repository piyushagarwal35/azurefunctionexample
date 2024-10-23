package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.ChargeClass;

public class ChargeClassConverter extends AbstractBeanField<ChargeClass,String> {

    @Override
    protected ChargeClass convert(String value) {
        return ChargeClass.fromString(value);
    }
}
