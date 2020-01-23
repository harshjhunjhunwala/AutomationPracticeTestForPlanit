package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BasePage {

    public static Properties properties;
    public static WebDriver driver;


    public BasePage()
    {
        try{
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/automationpractice"+ "/config/config.properties");
            properties.load(fileInputStream);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void initialization(){
        String browserName = properties.getProperty("browser");

        String pathOfDrivers = System.getProperty("user.dir")+"/src/main/resources/";

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", pathOfDrivers+"chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", pathOfDrivers+"geckodriver");
            driver = new FirefoxDriver();
        }




        driver.manage().window().maximize();
      //  driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }



}


