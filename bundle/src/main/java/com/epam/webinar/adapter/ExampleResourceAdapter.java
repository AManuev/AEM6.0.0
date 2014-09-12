package com.epam.webinar.adapter;

import com.epam.webinar.adapter.models.SimpleResourceModel;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.adapter.AdapterFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

@Component(metatype = true, immediate = true)
@Service
public class ExampleResourceAdapter implements AdapterFactory {

    @Property(name = "adapters")
    protected static final String[] ADAPTER_CLASSES = { SimpleResourceModel.class.getName() };

    @Property(name = "adaptables")
    protected static final String[] ADAPTABLE_CLASSES = { Resource.class.getName() };

    @Override
    public <AdapterType> AdapterType getAdapter(Object o, Class<AdapterType> adapterTypeClass) {
        //NOTE: In this option you can't access the parameters from template.
        if (o instanceof Resource) {

            SimpleResourceModel comp = new SimpleResourceModel((String) (((Resource) o).adaptTo(ValueMap.class)).get("jcr:title"));
            return (AdapterType) comp;
        }
        return null;
    }
}
