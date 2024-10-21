package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.CommitmentDiscountStatus;

public class CommitmentDiscountStatusConverter extends AbstractBeanField<CommitmentDiscountStatus, String> {

    @Override
    protected CommitmentDiscountStatus convert(String value) {
        return CommitmentDiscountStatus.fromString(value);
    }
}
