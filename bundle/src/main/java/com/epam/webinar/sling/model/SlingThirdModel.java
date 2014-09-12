package com.epam.webinar.sling.model;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;

@Model(adaptables = SlingHttpServletRequest.class)
public interface SlingThirdModel {

    // will return request.getResource().adaptTo(ValueMap.class).get("myDescription", String.class)
    @Inject
    @Via("resource")
    public String getMyDescription();

    @Inject
    public String getRequestDescription();

    // Ensure that "resource" is retrived from the bindings, not a request attribute
    @Inject
    @Source("script-bindings")
    public Resource getResource();
}
