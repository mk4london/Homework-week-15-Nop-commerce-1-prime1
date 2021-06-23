package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.BuildYourOnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite extends TestBase
{
    HomePage homePage;
    ComputerPage computerPage;
    DesktopPage desktopPage;
    BuildYourOnComputerPage buildYourOnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp()
    {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        computerPage = new ComputerPage();
        buildYourOnComputerPage = new BuildYourOnComputerPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        homePage.clickOnComputer();
        computerPage.clickOnDesktop();
        desktopPage.sortByValuePosition("6"); //Name Z To A value is 6
        desktopPage.verifyProductListSortedOrNot();
    }

    @Test(groups = {"regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.clickOnComputer();
        computerPage.clickOnDesktop();
        desktopPage.sortByValuePosition("5"); //Name A To Z value is 5
        Thread.sleep(3000);
        desktopPage.clickOnAddToCart();

        //Assert
        String expectedMessage1 = "Build your own computer";
        String actualMessage1 = getTextFromElement(By.xpath("//div[@data-productid='1']/div[1]/div[2]/div[1]/h1"));
        Assert.assertEquals("Build your own computer page is not there....", expectedMessage1, actualMessage1);

        buildYourOnComputerPage.selectProcessor("1");
        buildYourOnComputerPage.selectRam("5");
        buildYourOnComputerPage.clickOnHDD400RadioBtn();
        buildYourOnComputerPage.clickOnOSVistaPremiumRadioBtn();
        buildYourOnComputerPage.clickOnTotalCommanderCheckBox();

        Thread.sleep(8000);
        //Assert
        String expectedMessage2 = "$1,475.00";
        String actualMessage2 = getTextFromElement(By.id("price-value-1"));
        Assert.assertEquals("Wrong price match....", expectedMessage2, actualMessage2);

        buildYourOnComputerPage.clickOnAddToCartBtn();

        //Assert
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//div[@id='bar-notification']/div/p"));
        Assert.assertEquals("Not added to shopping cart....", expectedMessage3, actualMessage3);

        buildYourOnComputerPage.setClose_shopping_popup_bar();
    }
}
