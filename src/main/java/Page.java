import UI.Client;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.Constants;
import utils.Locators;

import java.util.concurrent.TimeUnit;

public class Page {

    public static WebDriver driver;

    static void startBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(Constants.chromeBrowserKey, Constants.chromeBrowserPath);
            driver = new ChromeDriver();
            configureBrowser(browser);

        }
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(Constants.firefoxBrowserKey, Constants.firefoxBrowserPath);
            driver = new FirefoxDriver();
            configureBrowser(browser);

        }
        if (browser.equalsIgnoreCase("explorer")) {
            System.setProperty(Constants.explorerBrowserKey, Constants.explorerBrowserPath);
            driver = new InternetExplorerDriver();
            configureBrowser(browser);

        }
    }

    private static void configureBrowser(String browser) {
        driver.get(Constants.logInUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();
    }

    static void closeBrowser() {
        driver.close();
    }

    static void successfulLogin() {

        WebElement email = Page.driver.findElement(By.id(Locators.getMailLogInLocator));
        email.sendKeys(Constants.logInEmailData);
        Assert.assertTrue(email.isDisplayed());

        WebElement password = Page.driver.findElement(By.id(Locators.getPasswordLogInLocator));
        password.sendKeys(Constants.logInPasswordData);
        Assert.assertTrue(password.isDisplayed());

        WebElement submitButton = Page.driver.findElement(By.id(Locators.logInButton));
        submitButton.click();

        WebElement succLogIn = Page.driver.findElement(By.cssSelector(Locators.mailLogInLocator));
        Assert.assertTrue(succLogIn.isDisplayed());
    }

    public static void addNewClient() {


        WebElement addNewPhClient = Page.driver.findElement(By.xpath(Locators.addNewClientLocator));
        addNewPhClient.click();
        WebElement phisicalClientButton = Page.driver.findElement(By.id(Locators.phisicalClientButton));
        phisicalClientButton.click();
    }

    public static void createNewClient(Client client) {

        WebElement clientsName = Page.driver.findElement(By.name(Locators.clientsName));
        clientsName.sendKeys(client.getFirm_name());
        WebElement clientsAddress = Page.driver.findElement(By.name(Locators.clientsAddress));
        clientsAddress.sendKeys(client.getFirm_addr());
        WebElement clientsCity = Page.driver.findElement(By.name(Locators.clientsCity));
        clientsCity.sendKeys(client.getFirm_town());
    }


    public static void submitNewClient() {

        WebElement submitButton = Page.driver.findElement(By.name(Locators.submitButton));
        submitButton.click();
        WebElement successRegLocator = Page.driver.findElement(By.id(Locators.successRegLocator));
        Assert.assertTrue(successRegLocator.getText().contains(Locators.successMessage));
        Assert.assertTrue(successRegLocator.isDisplayed());

    }

    public static void addAnotherClient() {
        WebElement addAnotherClient = Page.driver.findElement(By.linkText(Locators.addAnotherClient));
        addAnotherClient.click();
    }
}