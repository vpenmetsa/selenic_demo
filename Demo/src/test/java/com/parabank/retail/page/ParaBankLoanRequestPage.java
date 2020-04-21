/**
 * 
 */
package com.parabank.retail.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankLoanRequestPage {

	@FindBy(id = "amount")
	private WebElement amountField;

	@FindBy(id = "downPayment")
	private WebElement downPaymentField;

	@FindBy(id = "fromAccountId")
	private WebElement fromAccountIdDropdown;

	@FindBy(css = "input[value='Apply Now']")
	private WebElement applyNowButton;

	@FindBy(linkText = "Log Out")
	private WebElement logOutLink;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Loan", "Request" };

	public ParaBankLoanRequestPage(WebDriver driver) {
		this.driver = driver;
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,
		 * DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		 * wait.ignoring(StaleElementReferenceException.class);
		 * 
		 * Arrays.stream(TITLE_WORDS).forEach(word -> {
		 * wait.until(attributeContains(By.tagName("title"), "innerHTML", word)); });
		 */		 
		PageFactory.initElements(driver, this);
	}

	private WebElement waitUntilClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		wait.ignoring(StaleElementReferenceException.class);
		return wait.until(elementToBeClickable(element));
	}

	public void setAmountField(String text) {
		waitUntilClickable(amountField).clear();
		amountField.sendKeys(text);
	}

	public void setDownPaymentField(String text) {
		waitUntilClickable(downPaymentField).clear();
		downPaymentField.sendKeys(text);
	}

	public void selectFromAccountIdDropdown(String text) {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver,
		 * DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT);
		 * wait.ignoring(StaleElementReferenceException.class); wait.until(webdriver ->
		 * new Select(fromAccountIdDropdown).getFirstSelectedOption().getText().trim().
		 * length() > 0);
		 */
		Select dropdown = new Select(fromAccountIdDropdown);
		dropdown.selectByVisibleText(text);
	}

	public void clickApplyNowButton() {
		waitUntilClickable(applyNowButton).click();
	}

	public void clickLogOutLink() {
		waitUntilClickable(logOutLink).click();
	}

}