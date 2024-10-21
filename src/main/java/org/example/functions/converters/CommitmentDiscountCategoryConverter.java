package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.CommitmentDiscountCategory;

public class CommitmentDiscountCategoryConverter extends AbstractBeanField<CommitmentDiscountCategory, String> {

    @Override
    protected CommitmentDiscountCategory convert(String value) {
        return CommitmentDiscountCategory.fromString(value);
    }
}
