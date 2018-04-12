import UI.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    @Before
    public void setUp() throws Exception {
        Page.startBrowser("chrome");
    }

    @After
    public void close() throws Exception {
        Page.closeBrowser();
    }

    @Test
    public void logIn() {

        Page.successfulLogin();
    }

    @Test
    public void addnewPhisicalClient() {
        Page.successfulLogin();
        Page.addNewClient();
        Client ivan = new Client("Ivan Ivanov", "Sofia", "Sofia", "No", "No");
        Page.createNewClient(ivan);
        Page.submitNewClient();
    }



}
