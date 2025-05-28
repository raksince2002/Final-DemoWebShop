package com.demo.stepdefinitions;

import java.io.IOException;

import Method_Libraries.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import util.ExcelData;
 
public class Search_bdd {
	
	
		 Search ob ;
		 ExcelData r ;
		 
		 public Search_bdd() throws IOException {
			 ob = new Search();
			 r = new ExcelData();
		 }
		 
		@Given("The user navigates to url")
		public void The_user_navigates_to_url() {
			ob.launch();
		}
		 @When("The user enters the search term in the search field")
		 public void The_user_enters_the_search_term_in_the_search_field() {
			 ob.writetext();
		 }
 
		    @And("The user clicks on search button")
		    public void The_user_clicks_on_search_button() {
		    	ob.click();
		    }
		    
		 @Then("The search results page should display relevant results")
		 public void The_search_results_page_should_display_relevant_results() {
			 String exptext=r.read_cell(1, 7, 3);
			 String acttext=ob.Validate();
			 Assert.assertEquals(exptext,acttext );
			 }
	   
	   
	    
	
 
}
 