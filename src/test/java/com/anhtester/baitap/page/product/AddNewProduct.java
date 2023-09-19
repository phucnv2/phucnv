package com.anhtester.baitap.page.product;

import com.anhtester.baitap.commom.BaseTestBT;
import com.anhtester.baitap.page.category.AddNewCategory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.anhtester.baitap.locators.LocatorsCMS.*;

public class AddNewProduct extends BaseTestBT {

    AddNewCategory cate = new AddNewCategory();
    @Test
    public void addNewProduct() {
        clickElement(menuProduct);
        clickElement(submenuProduct);
        Assert.assertTrue(checkDisplayElement(headerAddNewProduct),"Fail!");
        setText(inputProductName,cate.CATEGORIES_NAME);
        sleep(2);
        clickDropdownEnter(dropdownCategory,inputSearchCategory,cate.CATEGORIES_NAME);
        scrollToElementWithJS();
        Boolean isSelected = driver.findElement(By.xpath(touch)).isSelected();
        if (isSelected == false){
            clickElement(touch);
        }
        clickDropdownHasEnterAndClick1(buttonColor,searchColor,"AliceBlue");
        sleep(4);
    }
}
