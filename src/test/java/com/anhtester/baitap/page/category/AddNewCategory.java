package com.anhtester.baitap.page.category;

import com.anhtester.baitap.commom.BaseTestBT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.anhtester.baitap.locators.LocatorsCMS.*;

public class AddNewCategory extends BaseTestBT {
    String CATEGORIES_NAME = "Phucs";
    String CATEGORIES_ORDERING_NUMBER = "1";
    String PARENT_OPTION = "Demo category 1";
    String TYPE_OPTION = "Physical";
    String CATEGORIES_META_TITLE = "Nguyenex vawn Phucs";
    String CATEGORIES_META_DESCRIPTION = "Phucs";
    String BANNER_NAME = "banner_phucs";
    String ICON_NAME = "Fpt-icon";
    String ATTRIBUTE = "Size";


    @Test
    public void addNewCategory() {
        Assert.assertTrue(checkDisplayElement(menuProduct), "Fail!");
        clickElement(menuProduct);
        clickElement(submenuCategory);
        Assert.assertTrue(checkDisplayElement(headerCategory), "Fail!");
        clickElement(btnAddNewCategory);
        Assert.assertTrue(checkDisplayElement(headerAddNewCategoty), "Fail!");
        setText(inputCategoriesName, CATEGORIES_NAME);
        chooseDropdown(sellectID, PARENT_OPTION);
        setText(inputOrderingNumber, CATEGORIES_ORDERING_NUMBER);
        chooseDropdown(selectType,TYPE_OPTION);
        clickElement(inputBanner);
        setText(inputSearchImages,BANNER_NAME);
        sleep(2);
        clickElement(chooseImage);
        clickElement(btnAddFile);

        clickElement(inputIcon);
        setText(inputSearchImages,ICON_NAME);
        sleep(2);
        clickElement(chooseImage);
        clickElement(btnAddFile);

        setText(inputMetaTitle,CATEGORIES_META_TITLE);
        setText(inputMetaDescription,CATEGORIES_META_DESCRIPTION);
        chooseDropdown(selectAttribute, ATTRIBUTE);
        clickElement(btnSaveCategories);


        Assert.assertTrue(checkDisplayElement(headerCategory), "Fail!");
        setTextHasEnter(inputSearchCategories,CATEGORIES_NAME);
        sleep(3);
        Assert.assertEquals(getText(tdName),CATEGORIES_NAME,"Fail! Không đúng tên nhập vào.");
    }
}
