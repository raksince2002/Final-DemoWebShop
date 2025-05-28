package Method_Libraries;

import java.io.IOException;

import CustomExceptions.LoginFailedException;

public class AddAndDelete extends AddToCartAndCheckout {
	
	public AddAndDelete() throws IOException {
		super();
	}

	public void add_first_product() throws LoginFailedException {
		log.info("Add first product to cart");
		wd1.findElement(Books).click();
		wd1.findElement(product_1).click();
		wd1.findElement(Add_to_Cart).click();
	}
	
	public void add_second_product() {
		log.info("Add second product to cart");
		wd1.findElement(Apparel_and_Shoes).click();
		wd1.findElement(product_2).click();
		wd1.findElement(Add_to_Cart).click();
	}
	
	public void add_third_product() {
		log.info("Add third product to cart");
		wd1.findElement(Jewelry).click();
		wd1.findElement(product_3).click();
		wd1.findElement(Add_to_Cart).click();
	}
	
	public void delete_any_2_products() {
		log.info("Delete two products from the cart");
		wd1.findElement(Shopping_Cart).click();
		wd1.findElement(product_check2).click();
		wd1.findElement(product_check3).click();
		wd1.findElement(update_cart).click();
	}
	
	public String assert_deletion() {
		log.info("Confirming that books have been deleted");
		String s = wd1.findElement(cart_quantity).getText();
		return s;		
	}

}