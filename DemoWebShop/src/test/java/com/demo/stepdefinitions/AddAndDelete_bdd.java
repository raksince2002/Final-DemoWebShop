package com.demo.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import CustomExceptions.LoginFailedException;
import Method_Libraries.AddAndDelete;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelData;

public class AddAndDelete_bdd {
	
	AddAndDelete l ;
	ExcelData r ;
	
	public AddAndDelete_bdd() throws IOException {
		l = new AddAndDelete();
		r = new ExcelData();
	}
	
	@Given("user is logged in and currently in the home page")
	public void user_is_logged_in_and_currently_in_the_home_page() {
		l.launch();
	}

	@When("user adds first product into the cart")
	public void user_adds_first_product_into_the_cart() throws LoginFailedException {
		l.add_first_product();
	}

	@When("user adds second product into the cart")
	public void user_adds_second_product_into_the_cart() {
		l.add_second_product();
	}

	@When("user adds third product into the cart")
	public void user_adds_third_product_into_the_cart() {
		l.add_third_product();
	}

	@When("user deletes any two products from the cart")
	public void user_deletes_any_two_products_from_the_cart() {
		l.delete_any_2_products();
	}

	@Then("two products are deleted and only one product is in the shopping cart")
	public void two_products_are_deleted_and_only_one_product_is_in_the_shopping_cart() {
		String s = l.assert_deletion();
		assertEquals(s,r.read_cell(1, 2, 3));
	}

}