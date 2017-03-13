package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Created by lihuanzhen on 2016/12/12.
 */

public class NoteTest {
    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "R815T");//设置需要调试模拟器的名字
        capabilities.setCapability("platformVersion", "4.4.2");//设置模拟器的版本

        capabilities.setCapability("appPackage", "com.example.android.notepad");
        capabilities.setCapability("appActivity", ".NotesList");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void addNote() {
        WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));

        el.click();
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByXPath(".//*[@text='Save']").click();


    }

    @Test
    public void longClick() throws InterruptedException {
        TouchAction operate = new TouchAction(driver);
        TouchAction perform = operate.longPress
                (driver.findElementByName("1212")).perform();
//        operate.press(e1).moveTo(e2).press(e3).moveTo(e4).perform();
        Thread.sleep(5000);
    }

    //????????
    @Test
    public void moveToPoint() {
        driver.closeApp();
//        AndroidElement notes = (AndroidElement) driver.findElementByName("Notes");
        MobileElement notes = (MobileElement) driver.findElementByName("Notes");
        TouchAction operate = new TouchAction(driver);
        operate.press(notes).perform();
        operate.moveTo(driver.findElementByName("卸载")).release().perform();
          MobileElement ok=(MobileElement)driver.findElementByName("确定");
//        AndroidElement ok = (AndroidElement) driver.findElementByName("确定");
        ok.click();

    }

}
