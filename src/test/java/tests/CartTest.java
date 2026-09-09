package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void checkGoodsInCart() {
        List<String> goodsList = List.of(
                "Sauce Labs Bike Light",
                "Sauce Labs Fleece Jacket",
                "Test.allTheThings() T-Shirt (Red)"
        );

        SoftAssert soft = new SoftAssert();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        soft.assertTrue(productsPage.isPageTitleVisible());
        soft.assertEquals(productsPage.getPageTitle(), "Products");

        for (String goodsName : goodsList) {
            productsPage.addGoodsToCart(goodsName);
        }

        productsPage.switchToCart();

        List<String> productsInCart = cartPage.getProductsNames();

        soft.assertEquals(productsInCart.size(), 3);
        soft.assertTrue(productsInCart.contains("Sauce Labs Bike Light"));
        soft.assertTrue(productsInCart.contains("Sauce Labs Fleece Jacket"));
        soft.assertTrue(productsInCart.contains("Test.allTheThings() T-Shirt (Red)"));

        soft.assertAll();
    }
}