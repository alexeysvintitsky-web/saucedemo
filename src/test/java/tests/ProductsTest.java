package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProductsTest extends BaseTest {

    List<String> goodsList = List.of(
            "Sauce Labs Bike Light",
            "Sauce Labs Fleece Jacket",
            "Test.allTheThings() T-Shirt (Red)"
    );

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageTitleVisible());
        assertEquals(productsPage.getPageTitle(), "Products");

        for (String goodName : goodsList) {
            productsPage.addGoodsToCart(goodName);
        }

        assertEquals(productsPage.checkCountersValue(), "3");
        assertEquals(productsPage.checkCountersColor(), "rgba(255, 255, 255, 1)");
    }
}