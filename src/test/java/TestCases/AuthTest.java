package TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by user on 5/19/2017.
 */
public class AuthTest extends  BaseUiTest {

    String adminLogin = "denmorozenko+1@gmail.com";
    String adminPassword = "jKLSGBUF";
    String newUserName = "denmorozenko";
    String mail = "@gmal.com";
    String adminAreaURL = "https://personal.x-cart.com/denmorozenko1gmailcom/admin.php";
    String userLogin = "denmorozenko@gmail.com";
    String userPassword = "wx6py288";
    String productTitle = "Avengers: Fabrikations Plush [Related Products]";
    String shoppingCartItemsNumber = "Your shopping cart - 1 item";
    String emptyCart = "Item(s) deleted from your cart";
    WebDriverWait wait;

    @Test
    // with submit
    public void loginAdminFormTest(){
        System.out.println("loginAdminFormTest");

        String pageURL = new LoginPage(driver)
                .OpenXCartAdmin()
                .loginIntoSite(adminLogin, adminPassword)
                .submitForm().getPageUrl();

        assertEquals(pageURL, adminAreaURL);
    }



    @Test
    //with login button click
    public void loginWithLoginButtonClick(){
        System.out.println("loginWithLoginButtonClick");

        String pageURL = new LoginPage(driver)
                .OpenXCartAdmin()
                .loginIntoSite(adminLogin, adminPassword)
                .loginButtonSubmit().getPageUrl();

        assertEquals(pageURL, adminAreaURL);
    }

    @Test(priority = 1)
    public void createNewUserByAdmin() {
        System.out.println("createNewUserByAdmin");

        WebElement adminPage = new LoginPage(driver)
                .OpenXCartAdmin()
                .loginIntoSite(adminLogin, adminPassword)
                .submitForm()
                .createNewUser(newUserName, mail, userPassword)
                .waitForElementPresence(AdminPage.getLocator());
        assertTrue(adminPage.isDisplayed());
        assertEquals(adminPage.getText(), "The profile has been created successfully");
    }


    @Test(priority = 2)
    public void loginWithCreatedUser(){
        System.out.println("loginWithCreatedUser");
        StorePage storePage = new StorePage(driver);
        storePage.getStorePage(userLogin, userPassword);

        assertTrue(storePage.getLogoutDropDown().isDisplayed());
        //logout from users account
        storePage.logoutFromUserPage();
    }

    @Test
    public void addItemToCart(){
        System.out.println("addItemToCart");
        ProductPage itemTitle = new StorePage(driver)
                .getStorePage(userLogin, userPassword)
                .addItemsToCart();

        assertEquals(itemTitle.getItemTitle().getText(), productTitle);
        // add to cart
        itemTitle.submitOrder();
        //check if added
        assertEquals(itemTitle.getPopupProductTitle().getText(), productTitle);
        //go to cart
        Cart cart = itemTitle.goToCart();
        //check items number
        assertEquals(cart.getInsideCartItemNumber().getText(), shoppingCartItemsNumber);
        assertEquals(cart.getItemNameInCart().getText(), productTitle);
        //remove from cart
        String emptyCartText = cart.removeFromcart()
                .getEmptyCartText()
                .getText();
        assertEquals(emptyCartText, emptyCart);

    }


}
