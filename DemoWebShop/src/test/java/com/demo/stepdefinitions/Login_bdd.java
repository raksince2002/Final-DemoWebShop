package com.demo.stepdefinitions;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import CustomExceptions.LoginFailedException;
import Method_Libraries.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelData;

public class Login_bdd {
	
	Login l ;
	
	public Login_bdd() throws IOException {
		l = new Login();
	}
	
	@Given("user is in home page")
	public void user_is_in_home_page() {
		l.launch();
	}

	@Given("user clicks on login link")
	public void user_clicks_on_login_link() {
		l.log_in();
	}

	@When("user enters email")
	public void user_enters_email() {
		l.email();
	}

	@When("user enters password")
	public void user_enters_password() {
		l.password();
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		l.login();
	}

	@Then("user is logged into the website")
	public void user_is_logged_into_the_website() throws LoginFailedException, IOException{
		assertFalse(l.assert_login());
	}
	
}