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
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankWelcomeOnlineBankingPage {

	@FindBy(xpath = "/descendant::a[img/@alt='ParaBank']")
	private WebElement link;

	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(css = "input[value='Log In']")
	private WebElement logInButton;

	private WebDriver driver;

	private static final int DEFAULT_WAIT_FOR_ELEMENT_TIMEOUT = 10;

	private static final String[] TITLE_WORDS = { "ParaBank", "Welcome", "Online", "Banking" };

	public ParaBankWelcomeOnlineBankingPage(WebDriver driver) {
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

	public void clickLink() {
		waitUntilClickable(link).click();
	}

	public void setUsernameField(String text) {
		waitUntilClickable(usernameField).clear();
		usernameField.sendKeys(text);
	}

	public void setPasswordField(String text) {
		waitUntilClickable(passwordField).clear();
		passwordField.sendKeys(text);
	}

	public void clickLogInButton() {
		waitUntilClickable(logInButton).click();
	}

}