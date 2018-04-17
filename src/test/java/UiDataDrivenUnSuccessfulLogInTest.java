import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Locators;

@RunWith(Parameterized.class)
public class UiDataDrivenUnSuccessfulLogInTest {
    String mail;
    String password;

    @Parameterized.Parameters
    public static String[][] testLogInData() {
        String[][] testLogInData = {
                {"valentinantov@yahoo.com", "valio1"},
                {"valentinantov@yahoo.com", ""},
                {"valentinantov yahoo.com", "valio123"},
                {"valentinantov@yahoo.co", "valio123"},
                {"", "valio123"}
        };
        return testLogInData;
    }

    public UiDataDrivenUnSuccessfulLogInTest(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    @Test
    public void Test() {
        WebElement email = Page.driver.findElement(By.id(Locators.getMailLogInLocator));
        email.sendKeys(this.mail);
        Assert.assertTrue(email.isDisplayed());

        WebElement password = Page.driver.findElement(By.id(Locators.getPasswordLogInLocator));
        password.sendKeys(this.password);
        Assert.assertTrue(password.isDisplayed());

        WebElement submitButton = Page.driver.findElement(By.id(Locators.logInButton));
        submitButton.click();

        WebElement errorMessage = Page.driver.findElement(By.id(Locators.errorLogInMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Before
    public void setUp() throws Exception {
        Page.startBrowser("chrome");
    }

    @After
    public void close() throws Exception {
        Page.closeBrowser();
    }
}


