package com.demo.stepdefinitions;
 
import java.io.IOException;

import org.testng.Assert;

import CustomExceptions.CheckoutFailedException;
import CustomExceptions.StaleElementReferenceException;
import Method_Libraries.AddToCartAndCheckout;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelData;
 
public class AddToCartAndCheckout_bdd {
	
	AddToCartAndCheckout obj ;
	ExcelData r;
	
	public AddToCartAndCheckout_bdd() throws IOException {
		obj = new AddToCartAndCheckout();
		r = new ExcelData();
	}
	
	@Given("Pre-requisite for project")
	public void pre_requisite_for_project() { 
	    obj.launch();
	}
	
	@And("I click on shopping cart")
	public void i_click_on_shopping_cart() {
		obj.shoppingCartPage();
	}
	
	@Then("I am in cart page")
	public void I_am_in_cart_page() throws CheckoutFailedException, IOException {
		obj.clickTermsAndConditions();
	}
	
	//billing address
	@Given("I am in checkout page")
	public void i_am_in_checkout_page() throws InterruptedException {
		String expCheckoutPage = r.read_cell(1, 12, 3);
		String actCheckoutPage = obj.inCheckoutPage();
		Assert.assertEquals(expCheckoutPage, actCheckoutPage);
	}
	
	@When("I click on New Address")
	public void I_click_on_new_address() throws InterruptedException {
		if(Integer.parseInt(r.read_cell(1, 11, 2))>0) {			
			obj.existingAddress();
		}
	}
	
	@When("I select country from dropdown")
	public void i_select_country_from_dropdown() throws InterruptedException {
		if(r.read_cell(1, 12, 2).equals("New Address")) {	
			obj.selectCountry();
		}
	}
 
	@And("I enter city")
	public void i_enter_city() {
		if(r.read_cell(1, 12, 2).equals("New Address")) {	
			obj.enterCity();
		}
	} 
 
	@And("I enter address1")
	public void i_enter_address1() {
		if(r.read_cell(1, 12, 2).equals("New Address")) {	
			obj.enterAddress1();
		}
	}
 
	@And("I enter zip code")
	public void i_enter_zip_code() {
		if(r.read_cell(1, 12, 2).equals("New Address")) {	
			obj.enterZipcode();
		}
	}
 
	@And("I enter phone number")
	public void i_enter_phone_number() {
		if(r.read_cell(1, 12, 2).equals("New Address")) {	
			obj.enterPhonenumber();
		}
	}
 
	@And("I click on continue button in billing address section")
	public void i_click_on_continue_button() throws InterruptedException, IOException {
	   obj.clickBAContinue();
	   r.set_cell(1, 11, String.valueOf(Integer.parseInt(r.read_cell(1, 11, 2))+1), 2);
	   r.set_cell(1, 12, "Existing Address", 2);
	}
 
	@Then("I am in shipping address section")
	public void i_am_in_shipping_address_section() throws InterruptedException {
		String expSSAssert = r.read_cell(1, 13, 3);
		String actSSAssert = obj.assertInShippingSection();
		Assert.assertEquals(expSSAssert, actSSAssert);
	}
	
	//Shipping address
	@When("I click on existing address on the dropdown")
	public void i_click_on_existing_address_on_the_dropdown() {
	   obj.existingShippingAddress();
	}
 
	@And("I click on continue button in shipping address")
	public void i_click_on_continue_button_in_shipping_address() throws InterruptedException {
	    obj.clickSAContinue();
	}
 
	@Then("I am in shipping shipment method section")
	public void i_am_in_shipping_shipment_method_section() throws InterruptedException {
	   Boolean actButton = obj.smButtonAssert();
	   Assert.assertEquals(true, actButton);
	}
 
	//Shipment method
	@When("I click on next day air button")
	public void i_click_on_next_day_air_button() throws InterruptedException {
	    obj.clickShippingMethod();
	}
 
	@And("I click on continue button in shipment method section")
	public void i_click_on_continue_button_in_shipment_method_section() {
	    obj.clickSMContinue();
	}
 
	@Then("I am in payment method section")
	public void i_am_in_payment_method_section1() throws InterruptedException {
	  Boolean actCODClick = obj.codAssert();
	  Assert.assertEquals(true, actCODClick);
	}
	
	//payment method
	@When("I click on credit card button")
	public void i_click_on_credit_card_button() throws InterruptedException {
	    obj.creditData();
	}
 
	@And("I click on continue button in payment method section")
	public void i_click_on_continue_button_in_payment_method_section() {
	    obj.clickPMContinue();
	}
 
	@Then("I am in payment information section")
	public void i_am_in_payment_information_section() throws InterruptedException {
	  String expPIText = r.read_cell(1, 4, 3);
	  String actPIText = obj.inPaymentInformationSection();
	  Assert.assertEquals(expPIText, actPIText);
	}
 
    //payment information
	@When("I select card type from dropdown")
	public void i_select_card_type_from_dropdown() throws InterruptedException {
	   obj.selectCardType();
	}
	
	@When("I enter invalid cardholder name")
	public void i_enter_invalid_cardholder_name() {
		obj.enterinvalidCardholderName();
	}

	@When("I enter invalid card number")
	public void i_enter_invalid_card_number() {
		obj.enterinvalidCardNumber();
	}

	@When("I enter invalid card code")
	public void i_enter_invalid_card_code() {
		obj.enterinvalidCardCode();
	}
 
	@And("I enter cardholder name")
	public void i_enter_cardholder_name() {
	    obj.enterCardholderName();
	}
 
	@And("I enter card number")
	public void i_enter_card_number() {
	    obj.enterCardNumber();
	}
 
	@And("I select date and year from expiration date dropdown")
	public void i_select_date_and_year_from_expiration_date_dropdown() {
	    obj.selectMonthAndYear();
	}
 
	@And("I enter card code")
	public void i_enter_card_code() {
	   obj.enterCardCode();
	}
 
	@And("I click on continue button in payment information section")
	public void i_click_on_continue_button_in_payment_information_section() {
	    obj.clickPIContinue();
	}
	
	@Then("I click on button and error message is displayed")
	public void an_Error_is_displayed() throws StaleElementReferenceException {
		obj.clickPIContinue();
		try {
			obj.clearInvalidData();
		}
		catch(Exception e) {
			throw new StaleElementReferenceException("Stale element reference");
		}
	}
 
	//confirm order
	@When("I click on confirm button in confirm order section")
	public void i_click_on_confirm_button_in_confirm_order_section() throws InterruptedException {
	   obj.clickCOContinue();
	}
 
	@Then("A message is displayed")
	public void a_message_is_displayed() throws InterruptedException {
	   String expText = r.read_cell(1, 5, 3);
	   String actText = obj.inOrderConfirmationPage();
	   Assert.assertEquals(actText, expText);
	}
 
	@And("I click on the link for order details")
	public void i_click_on_the_link_for_order_details() {
	   obj.clickOrderDetailsLink();
	}
 
	@Then("I am in order details page")
	public void i_am_in_order_details_page() throws InterruptedException {
		String expTitle = r.read_cell(1, 6, 3);
	    String actTitle = obj.inOrderDetailsPage();
	    Assert.assertEquals(actTitle, expTitle);
	}
 
}