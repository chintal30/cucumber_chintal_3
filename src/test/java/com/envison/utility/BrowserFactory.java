package com.envison.utility;

import com.envison.filereader.PropertyFileReader;
import com.envison.filereader.PropertyFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static String rm = PropertyFileReader.getPropertyValue("actitime.runmode");
    static String bn = PropertyFileReader.getPropertyValue("actitime.browsername");
    static String url = PropertyFileReader.getPropertyValue("actitime.url");
//    private static WebDriver openFirefoxBrowser() {
//        System.setProperty("webdriver.geko.driver", "browser_exes/geckodriver.exe");
//        driver = new FirefoxDriver();
//        return driver;
//    }
    private static void openChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (rm.equalsIgnoreCase("headless")) {
            options.addArguments("--headless=new");
        }
        driver.set(new ChromeDriver(options));
    }

    private static void openFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (rm.equalsIgnoreCase("headless")) {
            options.addArguments("-headless");
        }
        driver.set(new FirefoxDriver(options));
    }

    private static void openEdge() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (rm.equalsIgnoreCase("headless")) {
            options.addArguments("--headless=new");
        }
        driver.set(new EdgeDriver(options));
    }


    public static WebDriver openBrowserAsPerPropertiesFileBrowser() {
        if (bn.equalsIgnoreCase("chrome")) {
            openChrome();
        } else if (bn.equalsIgnoreCase("firefox")) {
            openFirefox();
        } else {
            openEdge();
        }
        return driver.get();

    }

    public static WebDriver openBrowser(String browserInputName) {
        switch (browserInputName.toLowerCase()) {
            case "chrome":
                openChrome();
                break;
            case "firefox":
                openFirefox();
                break;
            case "edge":
                openEdge();
                break;
        }
        return driver.get();
    }

    public static WebDriver openBrowser(String browserName, String runMode) {
        rm = runMode;
        return openBrowser(browserName);
    }

    public static WebDriver openBrowser() {
        return driver.get();
    }

    public static void LaunchWebsitefromPropertyFile() {
        driver.get().get(url);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get().manage().window().maximize();
    }
    public static void LaunchWebsitewithURLinput(String inputURL) {
        driver.get().get(inputURL);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get().manage().window().maximize();
    }

    public static void closeAllWindows() {
        driver.get().quit();
    }

    public static void closeCurrentWindow() {
        driver.get().close();
    }

//    public static void main(String[] args) {
//        BrowserFactory.openBrowser("firefox", "active");
//        BrowserFactory.closeAllWindow();
//    }
}
