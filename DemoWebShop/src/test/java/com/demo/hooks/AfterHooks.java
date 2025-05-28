package com.demo.hooks;

import io.cucumber.java.After;

public class AfterHooks {
	
	@After("@tag1")
	public void register() {
		System.out.println("After Register");
	}
	
	@After("@tag2")
	public void login() {
		System.out.println("After Login");
	}
	
	@After("@tag3")
	public void newsLetter() {
		System.out.println("After NewsLetter");
	}
	
	@After("@tag5")
	public void communitypoll() {
		System.out.println("After CommunityPoll");
	}
	
	@After("@tag7")
	public void search() {
		System.out.println("After Search");
	}
	
	@After("@tag8")
	public void addtocartandvalidation() {
		System.out.println("After AddToCartAndValidation");
	}
	
	@After("@tag91")
	public void addtocartandcheckout() {
		System.out.println("After AddToCartAndCheckout");
	}
	
	@After("@tag10")
	public void addtocartanddelete() {
		System.out.println("After AddToCartAndDelete");
	}
	
	@After("@tag11")
	public void wishlist() {
		System.out.println("After WishList");
	}

}
