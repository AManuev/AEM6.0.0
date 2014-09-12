package com.epam.webinar.adapter;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.adapter.AdapterFactory;

import com.day.cq.wcm.api.Page;
import com.epam.webinar.adapter.models.SimpleRequestModel;

@Component(metatype = true, immediate = true)
@Service
public class ExampleRequestAdapter implements AdapterFactory {

    @Property(name = "adapters")
    protected static final String[] ADAPTER_CLASSES = { SimpleRequestModel.class.getName() };

    @Property(name = "adaptables")
    protected static final String[] ADAPTABLE_CLASSES = { SlingHttpServletRequest.class.getName() };

    @Override
    public <AdapterType> AdapterType getAdapter(Object o, Class<AdapterType> adapterTypeClass) {

        if (o instanceof SlingHttpServletRequest) {
            SlingHttpServletRequest request = (SlingHttpServletRequest) o;
            // NOTE: you have access attributes from template
            String title = (String) request.getAttribute("title");
            Page page = (Page) request.getAttribute("page");
            return (AdapterType) new SimpleRequestModel(title, page);
        }
        return null;
    }
}
