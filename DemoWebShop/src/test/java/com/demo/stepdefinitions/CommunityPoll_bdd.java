package com.demo.stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import Method_Libraries.CommunityPoll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class CommunityPoll_bdd {
	
	CommunityPoll obj ;
	
	public CommunityPoll_bdd() throws IOException {
		obj = new CommunityPoll();
	}
	
	@Given("The user is logged out and is on poll page")
	public void The_user_is_logged_out_and_is_on_poll_page() {
		obj.launch();
		obj.log_out();
	}
	
	@Given("The user is on poll page")
	public void The_user_is_on_poll_page() {
		obj.launch();
	}
	
	@When("User selects an option to vote")
	public void User_selects_an_option_to_vote() {
		obj.selectvoteoptions();
	}
	
	@Then("Only registered users can vote")
	public void Only_registered_users_can_vote() {
		boolean b = obj.reguservote();
		assertTrue(b);
	}
	
	@And("User has registered and logged in")
	public void User_has_registered_and_logged_in() {
		obj.regandlogin();
	}
	
	@And("Clicks on vote")
	public void Clicks_on_vote() {
		obj.clickvote();
	}
	
	@Then("Vote is accepted")
	public void Vote_is_accepted() {
		boolean b = obj.assert_vote();
		assertTrue(b);
	}
}