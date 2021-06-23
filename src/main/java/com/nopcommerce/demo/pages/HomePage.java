package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;


public class HomePage extends Utility
{
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/child::li")
    WebElement topMenu;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/child::li[1]")
    WebElement computer;

    public void selectMenu(String menu)
    {
        Reporter.log("clicking on computer link" + topMenu.toString() + "<br>");
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='header-menu']/ul[1]/li/a"));
        for (WebElement element : elementList) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

    public void mouseHoverOnTopMenu() {
        Reporter.log("MouseHover on " + topMenu.toString() + "<br>");
        mouseHoverToElement(topMenu);
        log.info("Clicking on Top Menu...." + topMenu.toString());
    }

    public void clickOnComputer()
    {
        Reporter.log("clicking on computer link" + computer.toString() + "<br>");
        clickOnElement(computer);
        log.info("Clicking on Computer Menu...." + computer.toString());
    }
}
