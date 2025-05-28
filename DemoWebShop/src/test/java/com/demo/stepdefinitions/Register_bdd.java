package com.demo.stepdefinitions;
 
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import CustomExceptions.RegistrationFailedException;
import Method_Libraries.Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Register_bdd {
	
	Register reg ;
	
	public Register_bdd() throws IOException {
		reg = new Register();
	}
	
	@Given("User is in homepage")
	public void user_is_in_homepage() {
		reg.launch();
	}
	 
	@Given("User clicks on Register link")
	public void user_clicks_on_register_link() throws IOException, InterruptedException, RegistrationFailedException {
		reg.registerLink();
		reg.retrive();
	}
	 
	@When("User chooses the Gender")
	public void user_chooses_the_gender() throws InterruptedException {
		reg.radioGender();
	}
	 
	@When("User enters firstname")
	public void use_enters_firstname() {
		reg.firstName();
	}
	
	@When("User enters lastname")
	public void user_enters_the_lastname() {
		reg.lastName();
	}
	 
	@When("User enters email")
	public void user_enters_email() {
		reg.emailid();
	}
	 
	@When("User enters password")
	public void user_enters_the_password() {
		reg.password();
	}
	
	@And("User enters confirmpassword")
	public void user_enters_the_confirmpassword() {
		reg.conPassword();
	}
	 
	@When("User clicks on register button")
	public void user_clicks_on_register_button() {
		reg.regButton();
	}
	 
	@Then("User is registered successfully")
	public void user_is_registered_successfully() throws RegistrationFailedException, IOException {
		assertTrue(reg.validate());
	}
 
}