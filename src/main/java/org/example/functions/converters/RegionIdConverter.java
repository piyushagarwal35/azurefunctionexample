package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.RegionId;

public class RegionIdConverter  extends AbstractBeanField<RegionId,String> {
    @Override
    protected RegionId convert(String value) {
        return RegionId.fromString(value);
    }
}
