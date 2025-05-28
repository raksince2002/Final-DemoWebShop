package com.demo.stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import CustomExceptions.StaleElementReferenceException;
import CustomExceptions.TimeoutException;
import Method_Libraries.WishList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.ExcelData;
 
public class WishList_bdd
{
	WishList obj;
	ExcelData r;
	
	public WishList_bdd() throws IOException {
		obj =new WishList();
		r = new ExcelData();
	}
	
	
	@Given("pre-request for project")
	public void pre_request_for_project()
	{
	    obj.launch();
	}
 
	@When("user click on DigitalDownloads")
	public void user_click_on_digital_downloads() throws InterruptedException
	{
		String expectedTitle=r.read_cell(1, 8, 3);
	    String actualTitle=obj.ClickDigitalDownloads();
	    assertEquals(expectedTitle, actualTitle);
	}
 
	@And("add all products into wishlist")
	public void add_all_products_into_wishlist()
	{
        obj.AddProducts();
	}
 
	@Then("all products are added into the wishlist")
	public void all_products_are_added_into_the_wishlist() throws InterruptedException, StaleElementReferenceException, IOException
	{
		String exp=r.read_cell(1, 9, 3); ////Excel to be added
	    String result=obj.ValidateAllAddedProducts();
	    assertEquals(exp,result);
	}
	
	@Given("user is on WishList page")
	public void user_is_on_wish_list_page()
	{
		String expectedTitle=r.read_cell(1, 10, 3);
	    String actualTitle=obj.ClickWishList();
	    assertEquals(expectedTitle,actualTitle);
	}
 
	@When("user select a product from the WishList to remove")
	public void user_select_a_product_from_the_wish_list_to_remove() throws InterruptedException
	{
	    obj.RemoveProduct();
	}
 
	@And("click update wishlist to remove")
	public void click_update_wishlist_to_remove1()
	{
		obj.UpdatewishList();
	}
 
	@Then("a product removed  from the wishlist")
	public void a_product_removed_from_the_wishlist() throws TimeoutException, IOException
	{
		boolean actual=obj.ValidateProductAfterRemoving();
		assertTrue(actual);
	}
 
	@When("user select all product in wishlist")
	public void user_select_all_product_in_wishlist()
	{
	    obj.RemoveAllProduct();
	}
 
	@And("clicks update wishlist to remove")
	public void click_update_wishlist_to_remove()
	{
	    obj.UpdatewishList();
	}
 
	@Then("all product removed  from the wishlist")
	public void all_product_removed_from_the_wishlist()
	{
	   String expectedtext=r.read_cell(1, 11, 3);
	   String acutaltext=obj.ValidateEmptyWishList();
	   assertEquals(expectedtext, acutaltext);
	   
	}
 
}