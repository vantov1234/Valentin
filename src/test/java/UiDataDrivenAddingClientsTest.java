import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Constants;
import utils.Locators;

@RunWith(Parameterized.class)
public class UiDataDrivenAddingClientsTest {

    public String firm_name;
    public String firm_town;
    public String firm_addr;

    @Parameters
    public static String[][] testData() {
        String[][] testData = {
                {"Ivan Ivanov", "Sofia", "Burgas"},
                {"Ivan Georgiev", "Sofia", "Varna"},
                {"Petar Petrov", "Sofia", "Sofia"},
        };
        return testData;
    }

    public UiDataDrivenAddingClientsTest(String firm_name, String firm_addr, String firm_town) {
        this.firm_name = firm_name;
        this.firm_addr = firm_addr;
        this.firm_town = firm_town;
    }

    @BeforeClass
    public static void setUp(){
        Page.startBrowser("chrome");
        Page.successfulLogin();
    }

    @Test
    public void createClients() throws InterruptedException {
        Page.mainAddNewClient();
        Page.addNewPhisicalClient();
        WebElement clientsName = Page.driver.findElement(By.name(Locators.clientsName));
        clientsName.sendKeys(this.firm_name);
        WebElement clientsAddress = Page.driver.findElement(By.name(Locators.clientsAddress));
        clientsAddress.sendKeys(this.firm_addr);
        WebElement clientsCity = Page.driver.findElement(By.name(Locators.clientsCity));
        clientsCity.sendKeys(this.firm_town);
        Page.submitNewClient();
        WebElement sm = Page.driver.findElement(By.xpath(Locators.statusMessage));
        Assert.assertEquals(Constants.successfulClientRegistrationMessage,sm.getText().trim().replace("\n", ""));
    }

    @Test
    public void deleteClients(){
        WebElement clients = Page.driver.findElement(By.linkText(Locators.clients));
        clients.click();
        WebElement client1 = Page.driver.findElement(By.linkText(firm_name));
        Assert.assertTrue(client1.getText().equals(firm_name));
        client1.click();
        WebElement deleteButton = Page.driver.findElement(By.xpath(Locators.deleteClientButton));
        deleteButton.click();
        Alert alert = Page.driver.switchTo().alert();
        alert.accept();
        WebElement sm = Page.driver.findElement(By.xpath(Locators.statusMessage));
        Assert.assertEquals(Constants.successfulClientDeleteMessage,sm.getText().trim().replace("\n", ""));

    }

    @After
    public void startFromTheBegining() {
        WebElement begin = Page.driver.findElement(By.linkText(Locators.beginButton));
        begin.click();
    }

    @AfterClass
    public static void close() throws Exception {
        Page.closeBrowser();
    }
}
