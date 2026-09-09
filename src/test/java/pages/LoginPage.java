package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public final By userNameInput = By.cssSelector("#user-name");
    public final By passwordNameInput = By.cssSelector("#password");
    public final By loginBth = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        driver.findElement(userNameInput).sendKeys(user);
        driver.findElement(passwordNameInput).sendKeys(password);
        driver.findElement(loginBth).click();
    }

    public boolean isErrorVisible() {
        return driver.findElement(By.xpath("//h3[@data-test='error']")).isDisplayed();
    }

    public String getErrorText() {
        return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
    }
}