package test;

import base.BrowserSetup;
import features.InvestPage;
import features.WebLauncher;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestRunner extends BrowserSetup {

    InvestPage investPage =  new InvestPage(driver);


    //Log4j configuration
    private static final Logger log = LogManager.getLogger(TestRunner.class);


    @SneakyThrows
    @Test
    //@Order(1)
    public void investecHomePage(){

        log.info("Verifying successful web launch.");
        investPage = new InvestPage(driver);
        WebLauncher webLauncher = investPage.page();
        Assert.assertEquals(investPage.getTitle(), "Investec | Your Bank & Specialist Financial Partner - South Africa");
        searchInterest();
        signUp();
    }

    @Test
    //@Order(2)
    public void searchInterest() throws InterruptedException {
        investPage.searchForInterestRatePage();
        investPage.clickInterestRatePage();
        Assert.assertTrue(investPage.getSource().contains("Understanding cash investment interest rates"));
    }

    @Test
    //@Order(3)
    public void signUp() throws InterruptedException {
        investPage.signUp();
        Assert.assertTrue(investPage.getSource().contains("We look forward to sharing out of the ordinary insights with you"));
    }

}
