package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Created by think on 2016/12/15.
 * 移动web的测试
 */

public class BaiduTest {
      private AppiumDriver  driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "R815T");//设置需要调试模拟器的名字
        capabilities.setCapability("platformVersion", "4.4.2");//设置模拟器的版本
        capabilities.setCapability("browserName", "Chrome");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    @Test
    public void testSearch() {
        driver.get("http://www.baidu.com");
        driver.findElementById("index-kw").sendKeys("java");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
