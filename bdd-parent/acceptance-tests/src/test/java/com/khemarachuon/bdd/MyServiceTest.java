package com.khemarachuon.bdd;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.khemarachuon.bdd.steps.MyServiceSteps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class MyServiceTest extends SerenityStories {
	
	@Managed
	private WebDriver driver;
	
	@Steps
	private MyServiceSteps steps;
	
	@Issue("DEF-345")
	@Test
	public void validUsersShouldBeAllowedToLogin() {
		steps
		.aUserWithRoleOf("USER")
		.theUserShouldBeAllowedToExecuteAction("logout");
	}
	
	@Test
	public void google_is_accessible() {
		driver.navigate().to("https://www.google.com");
		WebElement queryField = driver.findElement(By.xpath("//input[@name='q']"));
		new WebDriverWait(driver, 10L).until(ExpectedConditions.visibilityOf(queryField));
		
		queryField.sendKeys("dogs");
		queryField.submit();
		
		new WebDriverWait(driver, 10L).until(ExpectedConditions.visibilityOf(
				driver.findElement(By.xpath("//div[@role='navigation']"))));
	}
}
