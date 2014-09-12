package com.epam.webinar.sling.model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.epam.webinar.HelloService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

/**
 * The type Sling extended model.
 */
@Model(adaptables=Resource.class)
public class SlingExtendedModel {

    /**
     * Inject OSGi service.
     */
    @Inject
    private HelloService helloService;

    /**
     * Options for property injection.
     */
    @Inject
    @Named("jcr:title")
    private String title;

    @Inject @Optional
    private String description;

    @Inject @Default(values="No title")
    private String defaultTitle;

    @Inject @Default(values = {"1","2","3","4"})
    private String[] array;

    private String value;

    /**
     * Activate void.
     */
    @PostConstruct
    public void activate() {
        value = "Injected title:  " + title;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return value;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets default title.
     *
     * @return the default title
     */
    public String getDefaultTitle() {
        return defaultTitle;
    }

    /**
     * Get array of String.
     *
     * @return the String [ ]
     */
    public String[] getArray() {
        return array;
    }


    /**
     * Gets repository name from OSGi service.
     *
     * @return the repository name
     */
    public String getRepositoryName() {
        return helloService.getRepositoryName();
    }
}
