package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.ServiceCategory;
//import hitachi_genai.popDashBoard.enums.ServiceCategory;

public class ServiceCategoryConverter extends AbstractBeanField<ServiceCategory,String>{

    @Override
    protected ServiceCategory convert(String value) {
        return ServiceCategory.fromString(value);
    }
}
