package com.it_academy.page_object;

import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(WebDriverFactoryStaticThreadRemote.getDriver(), 1000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void navigate(String url) {
        WebDriverFactoryStaticThreadRemote.getDriver().get(url);
    }
}
