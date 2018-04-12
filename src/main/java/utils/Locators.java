package utils;

public class Locators {

    // log in
    public static final String getMailLogInLocator = "loginusername";
    public static final String getPasswordLogInLocator = "loginpassword";
    public static final String logInButton = "loginsubmit";

    // assure log in
    public static final String mailLogInLocator = "div.userpanel-header";

    // navigate to add new phisical client
    public static final String addNewClientLocator = "//div[@id='startmenu']/a[2]/b";
    public static final String phisicalClientButton = "type_person";

    // phisical client's mandatory fields
    public static final String clientsName = "person_name";
    public static final String clientsAddress = "person_address";
    public static final String clientsCity = "person_city";

    // submit
    public static final String submitButton = "do_submit";

    // assert succesfull registration
    public static final String successRegLocator = "okmsg";
    public static final String successMessage = "Клиентът е добавен успешно.";

}
