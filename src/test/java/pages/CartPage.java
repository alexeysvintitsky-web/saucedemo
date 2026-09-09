package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By continueShoppingButton = By.id("continue-shopping");
    private final By productName = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ArrayList<String> getProductsNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));
        List<WebElement> allProducts = driver.findElements(productName);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }
}
