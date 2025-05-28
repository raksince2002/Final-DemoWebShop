package com.demo.stepdefinitions;
 
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import Method_Libraries.AddToCartAndValidation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class AddToCartAndValidation_bdd {
	AddToCartAndValidation obj ;
	
	public AddToCartAndValidation_bdd() throws IOException {
		obj = new AddToCartAndValidation();
	}
	
	@Given("I am in home page")
	public void i_am_in_home_page() {
		obj.launch();
	}
 
	@When("I click on books section in categories")
	public void i_click_on_books_section_in_categories() {
	    obj.clickBooks();
	}
 
	@Then("I am in books page")
	public void i_am_in_books_page() {
	   boolean assertAddToCart = obj.assertAddToCartButton();
	   assertFalse(assertAddToCart);
	}
 
	@And("I click add to cart")
	public void i_click_add_to_cart() {
	    obj.thirdBook();
	}
 
	@Then("cart count should be increased")
	public void cart_count_should_be_increased() throws InterruptedException {
	   boolean act = obj.cartCountAssert();
	   assertTrue(act);
	}
 
}