package com.anhtester.thuchanh.contracts;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.anhtester.locator.LocatorsCRM.*;

public class AddNewContracts extends BaseTest {
    String CONTRACT_NAME = "Nguyễn Văn Phúc";
    @Test
    public void AddNewContracts(){
        login();
        clickElement(menuContacts);
        Assert.assertTrue(driver.findElement(By.xpath(headerContactPage)).isDisplayed(),"Fail! Không phải page contracts");

        clickElement(buttonAddNewContact);
        Assert.assertTrue(driver.findElement(By.xpath(headerAddNewContactDialog)).isDisplayed(),"Fail! Không phải page contracts dialog.");

//        clickElement();

    }
}
