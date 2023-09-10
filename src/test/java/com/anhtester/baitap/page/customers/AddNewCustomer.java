package com.anhtester.baitap.page.customers;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.anhtester.locator.LocatorsCRM.*;

public class AddNewCustomer extends BaseTest {
    String COMPANY_NAME = "Nguyễn Văn Phúc";
    String VAT_NUMBER = "10";
    String PHONE_NUMBER = "0965339606";
    String TEXT_DROPDOWN = "VIP";
    String ADDRESS = "Nghệ An";
    String ZIP_CODE = "460000";
    String COUNTRY = "Vietnam";

    String FIRST_NAME = "Nguyễn";
    String LAST_NAME = "Văn";

    String POSITION = "Position";
    String EMAIL = "Phuc1996@gmail.com";
    String PHONE = "0965339606";
    String PASSWORD = "Phuc";

    @Test
    public void addNewCustomer() {
//        login();
        Assert.assertTrue(driver.findElement(By.xpath(menuDashboard)).isDisplayed(), "Fail!");

        // Menu Customer
        clickElement(menuCustomers);
        Assert.assertTrue(driver.findElement(By.xpath(headerCustomersPage)).isDisplayed(), "Fail!");
        Assert.assertEquals(driver.findElement(By.xpath(headerCustomersPage)).getText(), "Customers Summary", "Fail!");
        clickElement(buttonAddNewCustomer);

        // Add customer
        setText(inputCompanyName, COMPANY_NAME);
        setText(inputVatNumber, VAT_NUMBER);
        setText(inputPhone, PHONE_NUMBER);
        setText(inputWebsite, URL);
        sleep(2);
        clickDropdownHasEnterAndClick(dropdownGroups, inputSearchGroup, TEXT_DROPDOWN);
        setText(inputAddress, ADDRESS);
        setText(inputCity, ADDRESS);
        setText(inputState, ADDRESS);
        setText(inputZipCode, ZIP_CODE);
        clickDropdownEnter(buttonCountry, inputSearchCountry, COUNTRY);
        clickElement(buttonSaveCustomer);

        clickElement(menuCustomers);
        setText(inputSearchCustomers, COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(firstItemCustomerOnTable)).isDisplayed(), "Fail! Không tìm thấy Customer.");
        clickElement(firstItemCustomerOnTable);
        Assert.assertEquals((driver.findElement(By.xpath(inputCompanyName)).getAttribute("value")), COMPANY_NAME, "Fail! Giá trị không đúng");
        Assert.assertEquals((driver.findElement(By.xpath(inputVatNumber)).getAttribute("value")), VAT_NUMBER, "Fail! Giá trị không đúng");
        Assert.assertEquals((driver.findElement(By.xpath(inputPhone)).getAttribute("value")), PHONE_NUMBER, "Fail! Giá trị không đúng");
        Assert.assertEquals((driver.findElement(By.xpath(inputWebsite)).getAttribute("value")), URL, "Fail! Giá trị không đúng");
    }

    @Test
    public void addNewContact() {
//        login();
        clickElement(menuCustomers);
        setText(inputSearchCustomers, COMPANY_NAME);
        Assert.assertTrue(driver.findElement(By.xpath(firstItemCustomerOnTable)).isDisplayed(), "Fail! Không tìm thấy Customer.");
        clickElement(firstItemCustomerOnTable);
        clickElement(menuContacts);
        Assert.assertTrue(driver.findElement(By.xpath(headerContactPage)).isDisplayed(), "Fail! Không tìm thấy Contact Page.");
        clickElement(buttonAddNewContact);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(headerAddNewContactDialog)).isDisplayed(), "Fail!");
        driver.findElement(By.xpath(inputProfileImage)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\datatest\\profile_contact.png");
        setText(inputFirstName, FIRST_NAME);
        setText(inputLastName, LAST_NAME);
        setText(inputPosition, POSITION);
        setText(inputEmailContact, EMAIL);
        setText(inputPhoneContact, PHONE);
        Select select = new Select(driver.findElement(By.xpath(dropdownDirection)));
        select.selectByVisibleText("LTR");
        clickElement(buttonGeneratePassword);
        clickElement(buttonGeneratePassword);
        clickElement(buttonShowPassword);
        //Kiểm tra check box đã được check hay chưa
        Boolean isSelected = driver.findElement(By.xpath(checkboxDoNotSendEmail)).isSelected();

        //Nếu chưa được check thì click vào ô check box đó
        if (isSelected == false) {
            driver.findElement(By.xpath(checkboxDoNotSendEmail)).click();
        }
//        clickElement(buttonSaveContact);
    }
}
