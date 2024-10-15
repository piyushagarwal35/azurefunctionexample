package org.example.functions.converters;

import com.opencsv.bean.AbstractBeanField;
import org.example.functions.enums.ResourceType;
//import hitachi_genai.popDashBoard.enums.ResourceType;

public class ResourceTypeConverter extends AbstractBeanField<ResourceType,String>{

    @Override
    protected ResourceType convert(String value) {
        return ResourceType.fromString(value);
    }


}
