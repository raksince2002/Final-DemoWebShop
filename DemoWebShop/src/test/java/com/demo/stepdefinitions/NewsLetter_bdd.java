package com.demo.stepdefinitions;
 
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import Method_Libraries.NewsLetter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class NewsLetter_bdd {
	
    NewsLetter obj ;
    
    public NewsLetter_bdd() throws IOException {
    	obj = new NewsLetter();
    }

    @Given("I am on the newsletter subscription page")
    public void i_am_on_the_newsletter_subscription_page() {
        obj.launch();
    }
    
    @When("I enter a valid email address")
    public void i_enter_a_valid_email_address() {
        obj.enter_email();
    }
 
    @And("I click on the subscribe button")
    public void i_click_on_the_subscribe_button() {
       obj.click_subscribe();
    }
 
    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        boolean b = obj.result();
        assertTrue(b);
    }
 
    @When("I enter an already registered email address")
    public void i_enter_an_already_registered_email_address() {
        obj.multiple_register();
    }
 
    @And("I click on the subscribe button again")
    public void i_click_on_the_subscribe_button_again() {
       obj.subscribe_click();
    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        boolean b = obj.error_result();
        assertTrue(b);
    }
}