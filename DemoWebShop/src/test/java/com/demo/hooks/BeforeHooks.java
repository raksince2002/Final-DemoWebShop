package com.demo.hooks;

import io.cucumber.java.Before;

public class BeforeHooks {
	
	@Before("@tag1")
	public void register() {
		System.out.println("Before Register");
	}
	
	@Before("@tag2")
	public void login() {
		System.out.println("Before Login");
	}
	
	@Before("@tag3")
	public void newsLetter() {
		System.out.println("Before NewsLetter");
	}
	
	@Before("@tag5")
	public void communitypoll() {
		System.out.println("Before CommunityPoll");
	}
	
	@Before("@tag7")
	public void search() {
		System.out.println("Before Search");
	}
	
	@Before("@tag8")
	public void addtocartandvalidation() {
		System.out.println("Before AddToCartAndValidation");
	}
	
	@Before("@tag91")
	public void addtocartandcheckout() {
		System.out.println("Before AddToCartAndCheckout");
	}
	
	@Before("@tag10")
	public void addtocartanddelete() {
		System.out.println("Before AddToCartAndDelete");
	}
	
	@Before("@tag11")
	public void wishlist() {
		System.out.println("Before WishList");
	}

}
