package com.it_academy.page_object;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class HomePage extends AbstractPage {
    private static final String NAVIGATION_LINK_PATTERN =
            "//*[contains(@class, 'b-main-navigation__text') and contains(text(), '%s')]";

    public void clickOnHomePageLink(String link) {
        waitForElementVisibleWithRemote(By.xpath(format(NAVIGATION_LINK_PATTERN, link))).click();
    }
}
