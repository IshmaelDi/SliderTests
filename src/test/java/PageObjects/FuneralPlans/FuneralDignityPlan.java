package PageObjects.FuneralPlans;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FuneralDignityPlan extends PageObject{


    // FuneralDignity Plan Elements

    String FuneralBuyNowXpath = "//a[@class=\"btn funeral\"]";
    String FuneralDignityPlanXpath = "//a[@href=\"?sale=OR\"]";
    String EmailXpath = "//input[@id=\"introEmail\"]";
    String ContinueBtnXpath = "//*[@id=\"onlinego\"]";
    String FuneralDignityPlanOptionXpath = "//*[@id=\"inline-landing\"]/table/tbody/tr[2]/td[1]";

    // Member Details Elements

    String TitleXpath = "//select[@name=\"onTtl\"]";
    String NameXpath = "//input[@name=\"onName\"]";
    String SurnameXpath = "//input[@name=\"onSurname\"]";
    String IDnumXpath = "//input[@name=\"onID\"]";
    String EmailXPATH = "//*[@id=\"onEmail\"]";  // Email field on the members page
    String MobileNuXpath = "//input[@name=\"onMobile\"]";
    String PostalAddressXpath = "//input[@name=\"onAddress1\"]";
    String PostalCodeXpath = "//*[@id=\"onPostal\"]";
    String MaximumCoverXpath = "//*[@id=\"priceSliderTrack\"]/div[3]";
    String MonthlIncomeXpath = "//select[@name=\"onIncome\" ]";
    String OccupationXpath = "//select[@name=\"onOccupation\" ]";
    String educationXpath = "//select[@name=\"onEducation\"]";
    String FicDecl01Xpath = "//select[@name=\"fica01\" ]";
    String FicDecl02Xpath = "//select[@name=\"fica02\" ]";

    // Slider Bar Elements

    String sliderAmount = "//div[@class=\"fl trsm\"]";
    String Minimum40K = "//*[@id=\"priceSlider\"]/span";



    String ErrorXpath = "//*[@id=\"onlineSaleForm\"]/div/div[1]/div[1]/fieldset[1]/p[4]/span";
    String MultiplePolicyError = "//*[@id=\"onlineSaleForm\"]/div/div[1]/div[2]/div[4]";
    String ContinueButtonXpath = "//div[@onclick=\"loader();step('1','no');\"]";


    // Funeral Dignity Plan Logic

    String URL ="https://portals.freshive.co.za/clienteleonlinesales/";

    public void OpenWebsite(){

        getDriver().get(URL);

        getDriver().getWindowHandle();


    }
    @Step("Click Buy Now on Funeral Plan")
    public void ClickBuyNowFuneralPlans(){
        $(By.xpath(FuneralBuyNowXpath)).click();
    }
    @Step("Click the continue button")
    public void clickContinueBtn(){
        $(By.xpath(ContinueBtnXpath)).click();

    }
    @Step("Verify slider amounts and select different amount")
    public void DifferentAmnt() throws InterruptedException {


        List<WebElement> amounts = getDriver().findElements(By.xpath(sliderAmount));

        List<String> amountsAvailible = new ArrayList<>();

        amountsAvailible.add(amounts.get(0).getText());

        amountsAvailible.add(amounts.get(1).getText());


        amountsAvailible.add(amounts.get(2).getText());


        amountsAvailible.add(amounts.get(3).getText());

        //       amountsAvailible.add(amounts.get(4).getText());


        for (String s : amountsAvailible) {
            if (s.equalsIgnoreCase("R125,000") || s.equalsIgnoreCase("R150,000") || s.equalsIgnoreCase("R200,000") || s.equalsIgnoreCase("R250,000")){
                System.out.println("Amounts are available for selection");
            } else {


                Assert.fail("amount have been changed");

            }

        }
    }

    @Step("Select R35000")
    public void selectR35000() throws InterruptedException {

        Actions actions = new Actions(getDriver());

        WebElement elem_slider = getDriver().findElement(By.xpath("//*[@id=\"priceSlider\"]/span"));
        Thread.sleep(2000);

        actions.clickAndHold(elem_slider).moveByOffset(344,0).release().perform();

    }

    @Step("Select R40000")
    public void selectR40000() throws InterruptedException {

        Actions actions = new Actions(getDriver());

        WebElement elem_slider = getDriver().findElement(By.xpath("//*[@id=\"priceSlider\"]/span"));
        Thread.sleep(2000);

        actions.clickAndHold(elem_slider).moveByOffset(497,0).release().perform();

    }

    @Step("Select R45000")
    public void selectR45000() throws InterruptedException {

        Actions actions = new Actions(getDriver());

        WebElement elem_slider = getDriver().findElement(By.xpath("//*[@id=\"priceSlider\"]/span"));
        Thread.sleep(2000);

        actions.clickAndHold(elem_slider).moveByOffset(651,0).release().perform();

    }

    @Step("Select R50000")
    public void selectR50000() throws InterruptedException {

        Actions actions = new Actions(getDriver());

        WebElement elem_slider = getDriver().findElement(By.xpath("//*[@id=\"priceSlider\"]/span"));
        Thread.sleep(2000);

        actions.clickAndHold(elem_slider).moveByOffset(804,0).release().perform();

    }

    @Step("Generate random email address")
    public String GeneratedEmailAddress() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100000);
        return "Address" + randomInt + "@gmail.com";


    }

    @Step("Enter email ")
    public void EnterEmail(String email) {

        $(By.xpath(EmailXpath)).sendKeys(email);


    }

    @Step("Confirm that Funeral dignity plan is visible")

    public void FuneraldignityPlanOption() {
        Assert.assertTrue($(By.xpath(FuneralDignityPlanOptionXpath)).isDisplayed());
        Assert.assertTrue($(By.xpath(FuneralDignityPlanOptionXpath)).isVisible());


    }


    // Member Details Logic

    @Step("Select Title")
    public void SelectTitle(String Title) throws InterruptedException {
        Thread.sleep(20000);

        if ($(By.xpath("//*[@id=\"inline-cont\"]")).isDisplayed()) {

            $(By.xpath("//*[@id=\"contsale\"]")).click();
        }

        WebElement e = $(By.xpath(TitleXpath));
        selectFromDropdown(e, Title);

    }

    @Step("Enter name")
    public void EnterName(String name) {
        $(By.xpath(NameXpath)).sendKeys(name);

    }

    @Step("enter surname")
    public void Entersurname(String surname) {

        $(By.xpath(SurnameXpath)).sendKeys(surname);

    }

    @Step("enter member ID number ")
    public void enterMemberIDnum(String IDNUMBER) {



        $(By.xpath(IDnumXpath)).sendKeys(IDNUMBER);




    }

    @Step("Enter mobile Number")
    public void enterMobileNum(String MOBNo) {
        $(By.xpath(MobileNuXpath)).sendKeys(MOBNo);

    }

    @Step("Enter postal address")
    public void enterPostalAddress(String postadress) {
        $(By.xpath(PostalAddressXpath)).sendKeys(postadress);

    }

    @Step("Enter postal code")
    public void EnterPostalCode(String postcode) {
        $(By.xpath(PostalCodeXpath)).sendKeys(postcode);

    }

    @Step("Verify that Email address is populated to email field")

    public void EmailAdresPopulated() {
        WebElement Email = $(By.xpath(EmailXPATH));

        Assert.assertTrue(Email.isDisplayed());
        String emailTxt = Email.getText();
        if (emailTxt.isEmpty()) {
            System.out.println("Email address not populated");

        } else {

            Assert.fail("Email address is populated");


        }

    }

    @Step(" Select Monthly income")
    public void selectIncome(String value) {
        WebElement INC = $(By.xpath(MonthlIncomeXpath));
        INC.click();
        selectFromDropdown(INC, value);


    }

    @Step(" Select occupation")
    public void selectOccupation(String occupation) {
        WebElement occu = $(By.xpath(OccupationXpath));
        selectFromDropdown(occu, occupation);

    }

    @Step("Select education")
    public void selectEducation(String edu) {
        WebElement educ = $(By.xpath(educationXpath));
        selectFromDropdown(educ, edu);
    }

    @Step("Accept FICA declaration ")
    public void acceptFICAdecl(String Yes_No) {
        WebElement FD1 = $(By.xpath(FicDecl01Xpath));
        selectFromDropdown(FD1, Yes_No);
    }

    @Step("Accept FICA declaration ")
    public void acceptFicaDeclaration2(String YES_NO) {
        WebElement FD2 = $(By.xpath(FicDecl02Xpath));
        selectFromDropdown(FD2, YES_NO);
    }

    @Step("Click the continue button")
    public void clickContinueBt() {
        if ($(By.xpath(ContinueBtnXpath)).isClickable()) {
            $(By.xpath(ContinueBtnXpath)).click();
        } else {

            Assert.fail("Button not clickable");
        }
    }

//    @Step("Verify that field is  validated and marked as red ")
//
//    public void IDNumfieldValidated() {
//
//        boolean IDValidationdisplayed = $(By.xpath(IDNumberValidation)).isDisplayed();
//
//        if (IDValidationdisplayed){
//            System.out.println("ID number validation is showing ");
//        }else {
//
//            Assert.fail("ID number validation is not showing");
//
//        }
//
//    }

    @Step(": confirm that error message is displayed")
    public void confirm_that_error_message_is_displayed() {
        Assert.assertTrue($(By.xpath(ErrorXpath)).isDisplayed());
    }

    @Step(" Message that confirm multiple policy should displayed")
    public void message_that_confirm_multiple_policy_should_displayed() {
        $(By.xpath(MultiplePolicyError)).isDisplayed() ;
        $(By.xpath(MultiplePolicyError)).click();

        String exp = "Multiple policies with main member details appear in our records.\n" +
                "One of our consultants will be in contact to assist you further.";
        WebElement m = $(By.xpath(MultiplePolicyError));
        String act = m.getText();
        System.out.println("Error message is: "+ act);

        //verify error message with Assertion
        Assert.assertEquals(exp, act);


    }

    // Member Details Logic







}
