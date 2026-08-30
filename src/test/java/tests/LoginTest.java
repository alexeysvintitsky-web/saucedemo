package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void lockedUserTest() {
        loginPage.open();
        loginPage.login ("locked_out_user","secret_sauce");

        assertTrue(loginPage.isErrorVisible(), "Error message does not appear");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.", "Error text does not match expected output");
    }
    @Test
    public void correctUserTest() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        boolean pageTitleVisible = productsPage.isPageTitleVisible();
        assertTrue(pageTitleVisible);
        assertEquals(productsPage.getPageTitle(), "Products");
    }
    @Test
    public void noUsernameTest() {
        loginPage.open();
        loginPage.login ("","secret_sauce");

        assertTrue(loginPage.isErrorVisible(), "Error message does not appear");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Error text does not match expected output");
    }
    @Test
    public void noPasswordUserTest() {
        loginPage.open();
        loginPage.login ("locked_out_user","");

        assertTrue(loginPage.isErrorVisible(),"Error message does not appear");
        assertEquals(loginPage.getErrorText(),"Epic sadface: Password is required", "Error text does not match expected output");
    }
    @Test
    public void standardUserTest() {
        loginPage.open();
        loginPage.login("Standard_user","secret_sauce");

        assertTrue(loginPage.isErrorVisible(),"Error message does not appear");
        assertEquals(loginPage.getErrorText(),"Epic sadface: Username and password do not match any user in this service", "Error text does not match expected output");
    }
}