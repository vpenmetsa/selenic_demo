/**
 * 
 */
package com.parabank.retail;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.parabank.retail.page.*;

public class AccountsTest {

	/**
	 * Parasoft auto generated base URL
	 * Use -DPARABANK_BASE_URL=http://localhost:8080 from command line
	 * or use System.setProperty("PARABANK_BASE_URL", "http://localhost:8080") to change base URL at run time.
	 */
	private static final String PARABANK_BASE_URL = AccountsTest.class.getName()+".PARABANK_BASE_URL";

	private WebDriver driver;

	@BeforeEach
	public void beforeTest() {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Selenic\\webdrivers\\chromedriver.exe");
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
	 * Name: testAccountOverview
	 *
	 * Parasoft recorded Selenium test on Sun Oct 20 2019 14:09:30 GMT-0400 (Eastern Daylight Time)
	 */
	//@RepeatedTest(5)
	@Test
	public void testAccountOverview() throws Throwable {
		driver.get(System.getProperty("PARABANK_BASE_URL", PARABANK_BASE_URL) + "/parabank/index.htm");
		
		ParaBankWelcomeOnlineBankingPage paraBankWelcomeOnlineBankingPage = new ParaBankWelcomeOnlineBankingPage(
				driver);
		paraBankWelcomeOnlineBankingPage.setUsernameField("john");

		paraBankWelcomeOnlineBankingPage.setPasswordField("demo");

		paraBankWelcomeOnlineBankingPage.clickLogInButton();

		ParaBankAccountsOverviewPage paraBankAccountsOverviewPage = new ParaBankAccountsOverviewPage(driver);
		paraBankAccountsOverviewPage.clickLogOutLink();

	}

}