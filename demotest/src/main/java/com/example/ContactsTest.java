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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ContactsTest {
    private AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {

        // 确定被测程序
//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "/src/main/java/apps");//app的目录
//        File app = new File(appDir, "ContactManager.apk");//app的名字,对应app的目录下的文件
        //确定设备
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("noReset", true); //不需要再次安装
        capabilities.setCapability("deviceName","R815T");//设置需要调试模拟器的名字
        capabilities.setCapability("platformVersion", "4.4.2");//设置模拟器的版本
//        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void addContact(){
        WebElement el = driver.findElement(By.xpath("//*[@text='Add Contact']"));

        el.click();
        List<AndroidElement> e2 =driver.findElements(By.className("android.widget.EditText"));

        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("Some11 Name");
        textFieldsList.get(2).sendKeys("Some11@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByXPath("//*[@text='Save']").click();

        AndroidElement e10 = driver.findElement(By.id("com.sankuai.meituan:id/title"));
        //等同于
        AndroidElement e11=driver.findElementById("com.sankuai.meituan:id/title");
   }

    public void test2(){
        TouchAction ta = new TouchAction(driver);
        AndroidElement e11=driver.findElementById("com.sankuai.meituan:id/title");
        ta.press(e11);
    }


}
