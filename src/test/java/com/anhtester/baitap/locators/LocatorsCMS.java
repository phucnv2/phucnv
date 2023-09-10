package com.anhtester.baitap.locators;

public class LocatorsCMS {
    //Login CRM
    public static String headerLoginPage = "//h1[normalize-space()='Welcome to Active eCommerce CMS']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot password ?']";

    //Dashboard
    public static String menuProduct = "//span[normalize-space()='Products']";
    public static String submenuCategory = "//span[normalize-space()='Category']";

    // Category
    public static String headerCategory = "//h1[normalize-space()='All categories']";
    public static String btnAddNewCategory = "//a[@class='btn btn-primary']";
    public static String headerAddNewCategoty = "//h5[normalize-space()='Category Information']";
    public static String inputCategoriesName = "//input[@id='name']";
    public static String dropdownParentCategories = "//a[@class='btn btn-primary']";
    public static String inputParentCategoies = "//select[@name='parent_id']";
    public static String sellectID = "//select[@name='parent_id']";
    public static String inputOrderingNumber = "//input[@id='order_level']";
    public static String selectType = "//select[@name='digital']";
    public static String dropdownType = "//a[@class='btn btn-primary']";
    public static String inputBanner = "(//div[@class='input-group']//following-sibling::div[contains(@class,'form-control file-amount')])[1]";
    public static String inputIcon = "(//div[@class='input-group']//following-sibling::div[contains(@class,'form-control file-amount')])[2]";
    public static String inputSearchImages = "//input[@name='aiz-uploader-search']";
    public static String chooseImage = "(//div[@class='aiz-file-box'])[1]";
    public static String btnAddFile = "//button[normalize-space()='Add Files']";
    public static String inputMetaTitle = "//input[@placeholder='Meta Title']";
    public static String inputMetaDescription = "//textarea[@name='meta_description']";
    public static String selectAttribute = "//select[@name='filtering_attributes[]']";
    public static String dropdownFilteringAttributes = "//a[@class='btn btn-primary']";
    public static String btnSaveCategories = "//button[normalize-space()='Save']";
    public static String inputSearchCategories = "//input[@id='search']";
    public static String tdName = "(//table[starts-with(@class,'table aiz-table')]//tbody//tr)[1]//td[2]";
    public static String btnDelete = "//a[contains(@class,'confirm-delete')]";
    public static String btnDeleteSuccess = "//a[@id='delete-link']";
    public static String popupDialog ="//div[@class='modal-content']//h4[normalize-space()='Delete Confirmation']";
    public static String messDelete ="//span[normalize-space()='Category has been deleted successfully']";
    public static String btnEdit ="";
}
