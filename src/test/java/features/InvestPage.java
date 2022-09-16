package features;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.util.Random;

public class InvestPage {

    WebDriver driver;

    public InvestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /**
     * Function for launching browser

     * @throws InterruptedException
     */
    public WebLauncher page() throws InterruptedException {

        return new WebLauncher(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getSource(){return driver.getPageSource();}

   @FindBy(xpath="//font[contains(text(),'Search')]")
   WebElement searchButton;


    @FindBy(xpath="//input[@id='searchBarInput']")
    WebElement searchInvestecField;

  //  @FindBy(xpath="//header/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[5]/div[1]/a[1]/button[1]/*[1]")
    @FindBy(xpath = "//div[@id='searchBarButton']")
    WebElement searchGlass;

    @FindBy(xpath="//input[@id='focus']")
    WebElement clickFocusInsights;
    @FindBy(xpath = "//b[contains(text(),'Understanding')]")
    WebElement cashInvestmentsLink;

    //@FindBy(xpath="//button[contains(text(),'Sign up')]")
    @FindBy(css="body.ng-scope:nth-child(2) div.container-fluid.main-content-container:nth-child(2) div.main div.ch-collapsible-container:nth-child(2) div.ng-scope:nth-child(5) div.content-hub-form-container div.row.container-padding div.col-12 div.content-hub-form-container__content.component-bordered.component-bordered--small div.content-hub-form-container__content-inner.row.ng-scope div.col-12.col-lg-4.offset-lg-1.content-hub-form-container__button-wrapper:nth-child(2) > button.button-primary.content-hub-form-container__button.js-content-hub-form-container-button")
    WebElement signUpButton;

    @FindBy(xpath="//body/div[@id='onetrust-consent-sdk']/div[@id='ot-sdk-btn-floating']/div[1]/button[1]")
    WebElement accept;

    @FindBy(xpath="//button[@id='accept-recommended-btn-handler']")
    WebElement allowAll;

    @FindBy(xpath="//button[contains(text(),'Confirm My Choices')]")
    WebElement confirmAll;


    @FindBy(xpath="//body/div[2]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[1]/fieldset[2]/div[1]/text-input[1]/div[1]/div[1]/input[1]")
    WebElement enterNameTextField;

    @FindBy(xpath="//body/div[2]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[1]/fieldset[2]/div[2]/text-input[1]/div[1]/div[1]/input[1]")
    WebElement enterSurnameTextField;

    @FindBy(xpath="//body/div[2]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[1]/fieldset[2]/div[3]/text-input[1]/div[1]/div[1]/input[1]")
    WebElement enterEmailTextField;

    //@FindBy(xpath="//body/div[2]/div[3]/div[7]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/section[1]/fieldset[2]/div[4]/checkbox-input[1]/div[1]/div[1]/div[1]/button[1]")
    @FindBy(xpath = "//div[contains(text(),'Myself')]")
    WebElement myselfTextBox;

    @FindBy(xpath="//button[contains(text(),'Submit')]")
    WebElement submitButton;

    /**
     * function to search
     * @throws InterruptedException
     */
    public void searchForInterestRatePage() throws InterruptedException {
        clickAnElement(searchButton);
    }

    /**
     * Function for searching for the interest rate page
     * @throws InterruptedException
     */
    public void clickInterestRatePage() throws InterruptedException {
        Thread.sleep(10);
        enterTextField(searchInvestecField, "Understanding cash investment interest rates");
        Thread.sleep(10);
        clickAnElement(searchGlass);
        Thread.sleep(10);
        clickAnElement(clickFocusInsights);
        Thread.sleep(10);
        clickAnElement(cashInvestmentsLink);
        Thread.sleep(10);
        Thread.sleep(10);
        clickAnElement(signUpButton);
        clickAccept();
        clickAnElement(signUpButton);
    }
    /**
     * Function for signing up
     * @throws InterruptedException
     */

    public void signUp() throws InterruptedException {
        Thread.sleep(10);
        enterTextField(enterNameTextField, "name1");
        Thread.sleep(50);
        enterTextField(enterSurnameTextField,"surname1");
        Thread.sleep(50);
        enterTextField(enterEmailTextField,"test@investec.co.za");
        Thread.sleep(50);
        clickAnElement(myselfTextBox);
        Thread.sleep(50);
        clickAnElement(submitButton);
        Thread.sleep(50);
    }


    /**
     * General function for randomising a text up to 4 characters in length- can be used for generating a name
     * @return
     */
    public String generateRandomString() {
        byte[] array = new byte[4]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }

    /**
     * General function for clicking an element e.g. button or hyperlink
     * @param button
     */
    public void clickAnElement(WebElement button){
//        WebDriverWait woah = new WebDriverWait(driver, 15);
//        woah.until(ExpectedConditions.elementToBeClickable(button));
//
//        button.click();
        if(button.isDisplayed()){
            Actions act = new Actions(driver);
            act.moveToElement(button).click().perform();
        }

    }

    /**
     * General function for entering text in a textfield
     * @param field
     * @param text
     */
    public void enterTextField(WebElement field, String text)
    {
       // field.clear();
        field.sendKeys(text);
    }

    /**
     * FUnction for handling allow popUp window
     * @throws InterruptedException
     */

    public void clickAccept() throws InterruptedException {

        if(accept.isDisplayed() || allowAll.isDisplayed())
        {
            clickAnElement(allowAll);
            clickAnElement(confirmAll);
        }else{

            confirmAll.click();

        }
    }

    public void scrollDownThePage(WebElement webElement)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
