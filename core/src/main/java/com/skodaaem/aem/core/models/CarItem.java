package com.skodaaem.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarItem {

    @ValueMapValue
    private String name;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String link;

    @ValueMapValue
    private String ctaLabel;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return fileReference;
    }

    public String getLink() {
        return link;
    }

    public String getCtaLabel() {
        return ctaLabel;
    }
}
