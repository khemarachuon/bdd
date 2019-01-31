package com.khemarachuon.bdd.page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

@DefaultUrl("http://www.google.com")
public class GooglePage extends PageObject {
	
	@FindBy(xpath="//input[@name='q']")
	private WebElementFacade queryField;
	
	@FindBy(xpath="//div[@role='navigation']")
	private WebElementFacade navigationBar;
	
	@WhenPageOpens
	public void waitUntilQueryFieldIsVisible() {
		queryField.waitUntilVisible();
	}
	
	public void queryFor(String query) {
		enter(query).into(queryField);
		queryField.submit();
		
		waitFor(visibilityOf(navigationBar));
	}
}
