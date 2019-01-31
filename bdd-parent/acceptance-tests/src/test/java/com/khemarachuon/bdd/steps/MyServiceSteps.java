package com.khemarachuon.bdd.steps;

import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class MyServiceSteps {
	
	private String role;
	
	@Step("Given a user with role {0}")
	public MyServiceSteps aUserWithRoleOf(String role) {
		this.role = role;
		return this;
	}
	
	@Step("Then user should be allowed to execute action: {0}")
	public MyServiceSteps theUserShouldBeAllowedToExecuteAction(String action) {
		Serenity.recordReportData()
			.withTitle("Exported XML report")
			.andContents(action);
		
		if ("login".equalsIgnoreCase(action)) {
			Assert.assertEquals("ADMIN", role);
		} else if ("logout".equalsIgnoreCase(action)) {
			Assert.assertEquals("USER", role);
		} else {
			Assert.assertEquals("NOBODY", role);
		}
		return this;
	}
}
