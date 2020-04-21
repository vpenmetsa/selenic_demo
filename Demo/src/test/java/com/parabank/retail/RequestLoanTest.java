/**
 * 
 */
package com.parabank.retail;

import com.parabank.retail.page.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RequestLoanTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = RequestLoanTest.class.getName()+".PARABANK_BASE_URL";

	private WebDriver driver;

	@BeforeEach
	public void beforeTest() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Selenic\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterEach
	public void afterTest() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Name: requestLoan
	 * Recording file: requestLoan.json
	 *
	 * Parasoft recorded Selenium test on Thu Apr 16 2020 12:39:01 GMT-0400 (Eastern Daylight Time)
	 */
	@Test
	public void testRequestLoan() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm");

		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");
		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");
		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickRequestLoanLink();

		ParaBankLoanRequestPage paraBankLoanRequestPage = new ParaBankLoanRequestPage(driver);
		paraBankLoanRequestPage.setAmountField("1000");
		paraBankLoanRequestPage.setDownPaymentField("100");
		paraBankLoanRequestPage.selectFromAccountIdDropdown("13344");
		paraBankLoanRequestPage.clickApplyNowButton();
		paraBankLoanRequestPage.clickLogOutLink();
	}

}