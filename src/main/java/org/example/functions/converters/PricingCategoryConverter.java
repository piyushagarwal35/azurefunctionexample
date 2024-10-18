package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.PricingCategory;

public class PricingCategoryConverter extends AbstractBeanField<PricingCategory,String> {

    @Override
    protected PricingCategory convert(String value) {
        return PricingCategory.fromString(value);
    }
}
