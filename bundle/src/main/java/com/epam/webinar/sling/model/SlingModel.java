package com.epam.webinar.sling.model;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Model(adaptables=Resource.class)
public class SlingModel {

    @Inject
    @Named("jcr:title")
    private String title;

    private String value;

    @PostConstruct
    public void activate() {
        value = "Injected title:  " + title;
    }

    public String getTitle() {
        return value;
    }

}
