package com.skodaaem.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeroModel {

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String subtitle;

    @ValueMapValue
    private String ctaText;

    @ValueMapValue
    private String ctaLink;

    @ValueMapValue
    private String fileReference;

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getCtaText() {
        return ctaText;
    }

    public String getCtaLink() {
        return ctaLink;
    }

    public String getImage() {
        return fileReference;
    }

    public String getBackgroundStyle() {
        return (fileReference != null && !fileReference.isEmpty())
                ? "background-image:url(" + fileReference + ")"
                : "";
    }

    public boolean isEmpty() {
        return (title == null || title.isEmpty())
                && (fileReference == null || fileReference.isEmpty());
    }
}
