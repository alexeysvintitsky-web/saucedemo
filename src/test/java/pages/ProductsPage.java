package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";

    private final By pageTitle = By.cssSelector("[data-test='title']");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.cssSelector(".shopping_cart_link");   // ← ИСПРАВЛЕНО

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageTitleVisible() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addGoodsToCart(String goodName) {
        By addToCartBtn = By.xpath(ADD_TO_CART_PATTERN.formatted(goodName));
        driver.findElement(addToCartBtn).click();
    }

    public void addGoodsToCart(int goodIndex) {
        By addToCartBtn = By.xpath("//button[text()='Add to cart']");
        driver.findElements(addToCartBtn).get(goodIndex).click();
    }

    public String checkCountersValue() {
        return driver.findElement(cartBadge).getText();
    }

    public String checkCountersColor() {
        return driver.findElement(cartBadge).getCssValue("color");
    }

    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}