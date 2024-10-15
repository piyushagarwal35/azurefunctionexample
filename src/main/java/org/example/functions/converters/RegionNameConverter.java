package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.RegionName;
//import hitachi_genai.popDashBoard.enums.RegionName;

public class RegionNameConverter extends AbstractBeanField<RegionName, String> {
    @Override
    protected RegionName convert(String value) {
        return RegionName.fromString(value);
    }
}
