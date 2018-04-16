import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Locators;

@RunWith(Parameterized.class)
public class UiDDLogInTest {

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

    public UiDDLogInTest(String firm_name, String firm_addr, String firm_town) {
        this.firm_name = firm_name;
        this.firm_addr = firm_addr;
        this.firm_town = firm_town;
    }

    @Test
    public void ddTest() {
        WebElement clientsName = Page.driver.findElement(By.name(Locators.clientsName));
        clientsName.sendKeys(this.firm_name);
        WebElement clientsAddress = Page.driver.findElement(By.name(Locators.clientsAddress));
        clientsAddress.sendKeys(this.firm_addr);
        WebElement clientsCity = Page.driver.findElement(By.name(Locators.clientsCity));
        clientsCity.sendKeys(this.firm_town);
        Page.submitNewClient();
        Page.addAnotherClient();
    }

    @Before
    public void setUp() throws Exception {
        Page.startBrowser("chrome");
        Page.successfulLogin();
        Page.addNewClient();
    }

    @After
    public void close() throws Exception {
        Page.closeBrowser();
    }
}
