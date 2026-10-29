/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.skodaaem.aem.core.models;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import com.skodaaem.aem.core.testcontext.AppAemContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link HeroModel}.
 */
@ExtendWith(AemContextExtension.class)
class HeroModelTest {

    private final AemContext context = AppAemContext.newAemContext();

    @Test
    void testGettersReturnInjectedValues() {
        Resource resource = context.create().resource("/content/hero",
                "title", "Welcome",
                "subtitle", "To Skoda",
                "ctaText", "Learn more",
                "ctaLink", "/content/page",
                "fileReference", "/content/dam/hero.jpg");

        HeroModel hero = resource.adaptTo(HeroModel.class);

        assertNotNull(hero);
        assertEquals("Welcome", hero.getTitle());
        assertEquals("To Skoda", hero.getSubtitle());
        assertEquals("Learn more", hero.getCtaText());
        assertEquals("/content/page", hero.getCtaLink());
        assertEquals("/content/dam/hero.jpg", hero.getImage());
    }

    @Test
    void testGettersReturnNullWhenPropertiesAbsent() {
        Resource resource = context.create().resource("/content/hero-empty");

        HeroModel hero = resource.adaptTo(HeroModel.class);

        assertNotNull(hero);
        assertNull(hero.getTitle());
        assertNull(hero.getSubtitle());
        assertNull(hero.getCtaText());
        assertNull(hero.getCtaLink());
        assertNull(hero.getImage());
    }

    @Test
    void testIsEmptyWhenNoTitleAndNoImage() {
        Resource resource = context.create().resource("/content/hero-no-content");

        HeroModel hero = resource.adaptTo(HeroModel.class);

        assertNotNull(hero);
        assertTrue(hero.isEmpty());
    }

    @Test
    void testIsEmptyWhenTitleAndImageAreBlank() {
        Resource resource = context.create().resource("/content/hero-blank",
                "title", "",
                "fileReference", "");

        HeroModel hero = resource.adaptTo(HeroModel.class);

        assertNotNull(hero);
        assertTrue(hero.isEmpty());
    }

    @Test
    void testIsNotEmptyWhenTitlePresent() {
        Resource resource = context.create().resource("/content/hero-title-only",
                "title", "Only a title");

        HeroModel hero = resource.adaptTo(HeroModel.class);

        assertNotNull(hero);
        assertFalse(hero.isEmpty());
    }

    @Test
    void testIsNotEmptyWhenImagePresent() {
        Resource resource = context.create().resource("/content/hero-image-only",
                "fileReference", "/content/dam/hero.jpg");

        HeroModel hero = resource.adaptTo(HeroModel.class);

        assertNotNull(hero);
        assertFalse(hero.isEmpty());
    }
}
