package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.PricingUnit;
//import hitachi_genai.popDashBoard.enums.PricingUnit;

public class PricingUnitConverter extends AbstractBeanField<PricingUnit, String> {
    @Override
    protected PricingUnit convert(String value) {
        return PricingUnit.fromString(value);
    }
}
