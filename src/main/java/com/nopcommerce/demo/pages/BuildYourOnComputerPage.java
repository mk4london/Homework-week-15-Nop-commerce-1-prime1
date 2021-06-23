package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BuildYourOnComputerPage extends Utility
{
    private static final Logger log = LogManager.getLogger(BuildYourOnComputerPage.class.getName());

    @FindBy(xpath = "//h1[contains(text(),'Build your own computer')]")
    WebElement verifyTextBuildOwnComputer;

    @FindBy(id = "product_attribute_1")
    WebElement processor;

    @FindBy(id = "product_attribute_2")
    WebElement ram;

    @FindBy(id = "product_attribute_3_7")
    WebElement radio_hdd_400;

    @FindBy(id = "product_attribute_4_9")
    WebElement radio_os_vista_premium;

    @FindBy(id = "product_attribute_5_12")
    WebElement total_commander_checkbox;

    @FindBy(id = "add-to-cart-button-1")
    WebElement cart_btn;

    @FindBy(xpath = "//span[@class='close']")
    WebElement close_shopping_popup_bar;

    public void selectProcessor(String value)
    {
        Reporter.log("Select Processor " + processor.toString() + "<br>");
        selectByValueFromDropDown(processor,value);
        log.info("Select Processor...." + processor.toString());
    }

    public void selectRam(String value)
    {
        Reporter.log("Select RAM " + ram.toString() + "<br>");
        selectByValueFromDropDown(ram,value);
        log.info("Select RAM...." + ram.toString());
    }

    public void clickOnHDD400RadioBtn()
    {
        Reporter.log("Select HDD 400 " + radio_hdd_400.toString() + "<br>");
        clickOnElement(radio_hdd_400);
        log.info("Select HDD 400...." + radio_hdd_400.toString());
    }

    public void clickOnOSVistaPremiumRadioBtn()
    {
        Reporter.log("Select os vista premium " + radio_os_vista_premium.toString() + "<br>");
        clickOnElement(radio_os_vista_premium);
        log.info("Select os vista premium " + radio_os_vista_premium.toString());
    }

    public void clickOnTotalCommanderCheckBox() throws InterruptedException {
        Reporter.log("Select total commander check box " + total_commander_checkbox.toString() + "<br>");
        clickOnElement(total_commander_checkbox);
        Thread.sleep(5000);
        log.info("Select total commander check box " + total_commander_checkbox.toString());
    }

    public void clickOnAddToCartBtn()
    {
        Reporter.log("Clicking on Add to cart " + cart_btn.toString() + "<br>");
        clickOnElement(cart_btn);
        log.info("Clicking on Add to cart" + cart_btn.toString());
    }

    public void setClose_shopping_popup_bar()
    {
        Reporter.log("Clicking on pop up " + close_shopping_popup_bar.toString() + "<br>");
        clickOnElement(close_shopping_popup_bar);
        log.info("Clicking on pop up");
    }
}
