package tests;
import java.net.URL;
import java.util.List;
import java.util.function.Function;
import java.net.MalformedURLException;
import com.codeborne.selenide.WebDriverProvider;

import drivers.BrowserstackMobileDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.security.auth.login.Configuration;

public class BrowserstackAndroidTests {
    @Test
    void searchTest() throws MalformedURLException, InterruptedException {
        Configuration.browser = BrowserstackMobileDriver.class.getName();

            // Test case for the BrowserStack sample Android app.
            // If you have uploaded your app, update the test case here.
            AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(
                            MobileBy.AccessibilityId("Search Wikipedia")));
            searchElement.click();
            AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(
                            MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
            insertTextElement.sendKeys("BrowserStack");
            Thread.sleep(5000);
            List<AndroidElement> allProductsName = driver.findElementsByClassName(
                    "android.widget.TextView");
            assert(allProductsName.size() > 0);


            // Invoke driver.quit() after the test is done to indicate that the test is completed.
            driver.quit();
        }
}