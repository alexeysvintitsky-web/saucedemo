package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @DataProvider
    public Object[][] loginDate() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginDate", priority = 2)
    public void lockedUserTest(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorVisible(), "Error message does not appear");
        assertEquals(loginPage.getErrorText(), errorMsg, "Error text does not match expected output");
    }

    @Test(priority = 1)
    public void correctUserTest() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        boolean pageTitleVisible = productsPage.isPageTitleVisible();
        assertTrue(pageTitleVisible);
        assertEquals(productsPage.getPageTitle(), "Products");
    }
}