package com.anhtester.baitap.page.category;

import com.anhtester.baitap.commom.BaseTestBT;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.anhtester.baitap.locators.LocatorsCMS.*;

public class EditCategory extends BaseTestBT {
    AddNewCategory a = new AddNewCategory();
    @Test
    public void editCategory(){
        clickElement(menuProduct);
        clickElement(submenuCategory);
        setTextHasEnter(inputSearchCategories,"Add New Category - test");
        sleep(3);

        clickElement(btnEdit);

        clearText(inputCategoriesName);
        setText(inputCategoriesName, a.CATEGORIES_NAME);
        chooseDropdown(sellectID, a.PARENT_OPTION);
        setText(inputOrderingNumber, a.CATEGORIES_ORDERING_NUMBER);
        chooseDropdown(selectType,a.TYPE_OPTION);
        clickElement(inputBanner);
        setText(inputSearchImages,a.BANNER_NAME);
        sleep(2);
        clickElement(chooseImage);
        clickElement(btnAddFile);

        clickElement(inputIcon);
        setText(inputSearchImages,a.ICON_NAME);
        sleep(2);
        clickElement(chooseImage);
        clickElement(btnAddFile);

        setText(inputMetaTitle,a.CATEGORIES_META_TITLE);
        setText(inputMetaDescription,a.CATEGORIES_META_DESCRIPTION);
        chooseDropdown(selectAttribute, a.ATTRIBUTE);
        clickElement(btnSaveCategories);


        Assert.assertTrue(checkDisplayElement(messUpdate),"Fail! Chưa click nút edit!");
        Assert.assertEquals(getText(messUpdate),"Category has been updated successfully","Fail! Xóa không thành công.");
    }
}
