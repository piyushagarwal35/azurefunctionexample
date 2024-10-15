package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.ConsumedUnit;
//import hitachi_genai.popDashBoard.enums.ConsumedUnit;

public class ConsumedUnitConverter extends AbstractBeanField<ConsumedUnit,String> {
    @Override
    protected ConsumedUnit convert(String value) {
        return ConsumedUnit.fromString(value);
    }
}
