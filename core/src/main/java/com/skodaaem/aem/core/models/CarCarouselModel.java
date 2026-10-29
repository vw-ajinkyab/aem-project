package com.skodaaem.aem.core.models;

import java.util.Collections;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarCarouselModel {

    @ValueMapValue
    private String sectionTitle;

    @ChildResource
    private List<CarItem> cars;

    public String getSectionTitle() {
        return sectionTitle;
    }

    public List<CarItem> getCars() {
        return cars == null ? Collections.emptyList() : cars;
    }

    public boolean isEmpty() {
        return getCars().isEmpty();
    }
}
