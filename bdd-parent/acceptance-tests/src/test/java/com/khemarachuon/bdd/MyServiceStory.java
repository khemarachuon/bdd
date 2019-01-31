package com.khemarachuon.bdd;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.khemarachuon.bdd.page.GooglePage;
import com.khemarachuon.bdd.steps.MyServiceSteps;

import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;

public class MyServiceStory extends SerenityStories {
	
	@Managed
	private MyServiceSteps steps;
	
	@Managed
	private GooglePage googlePage;
	
	@Given("I want to buy $thing")
	public void buyerWantsToBuy(String thing) {
		System.err.println(thing);
	}
	
	@When("I want to search for items containing '$thing'")
	public void i_want_to_search_for_items_containing(String thing) {
		System.err.println(thing);
	}
	
	@Then("I want to only see items related to '$thing'")
	public void i_want_to_only_see_items_related_to(String thing) {
		System.err.println(thing);
		
		googlePage.open();
		googlePage.queryFor("dogs");
	}
}
