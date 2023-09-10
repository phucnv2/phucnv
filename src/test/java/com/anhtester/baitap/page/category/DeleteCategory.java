package com.anhtester.baitap.page.category;

import com.anhtester.baitap.commom.BaseTestBT;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.anhtester.baitap.locators.LocatorsCMS.*;

public class DeleteCategory extends BaseTestBT {
    String MESSDELETE ="Category has been deleted successfully";
    @Test
    public void deleteCategory() {
        clickElement(menuProduct);
        clickElement(submenuCategory);
        setTextHasEnter(inputSearchCategories,"Add New Category - test");
        sleep(3);
        clickElement(btnDelete);
        sleep(2);
        Assert.assertTrue(checkDisplayElement(popupDialog),"Fail! không hiển thị.");
        clickElement(btnDeleteSuccess);
        Assert.assertTrue(checkDisplayElement(messDelete),"Fail! Chưa click nút xóa!");
        Assert.assertEquals(getText(messDelete),MESSDELETE,"Fail! Xóa không thành công.");
    }
}
