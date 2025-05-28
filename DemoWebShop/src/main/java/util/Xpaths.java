package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Xpaths {
	
	protected ExcelData r ;
	protected CommonTestMethods c;
	protected Properties p;
	protected FileReader fr;
	String filepath;
	
	public Xpaths() throws IOException {
		filepath = "./Configs/Configurations.properties";
		r = new ExcelData();
		c = new CommonTestMethods();
		fr = new FileReader(filepath);
		p = new Properties();
		p.load(fr);
	}
	
	protected int rtotal = 1;
	protected int ctotal = 1;
	
	protected By register = By.xpath("(//a[@class='ico-register'])");
	protected By genderMale = By.xpath("//input[@id='gender-male']");
	protected By genderFemale = By.xpath("//*[@id=\"gender-female\"]");
	protected By firstname = By.id("FirstName");
	protected By lastname = By.id("LastName");
	protected By confirmPassword = By.id("ConfirmPassword");
	protected By registerbutton = By.id("register-button");
	protected By Continue = By.xpath("(//input[@class='button-1 register-continue-button'])");
	
	
	protected By log_in = By.xpath("//a[@class='ico-login']");
	protected By Email = By.xpath("//input[@id='Email']");
	protected By Password = By.xpath("//input[@id='Password']");
	protected By Login = By.xpath("//input[@value='Log in']");
	
	
	protected By emailField=By.id("newsletter-email");
	protected By subscribe = By.id("newsletter-subscribe-button");
	protected By sub_msg = By.id("newsletter-result-block");
	
	
	protected By logout=By.xpath("//a[@class='ico-logout']");
	
	
	protected By polloption=By.xpath("//label[text()='Excellent']");
	protected By pollerror=By.id("block-poll-vote-error-1");
	protected By clickvote=By.xpath("//*[@id=\"vote-poll-1\"]");
	
	
	protected By searchkeyword=By.xpath("//*[@id=\"small-searchterms\"]");
	protected By searchbuttonclick=By.xpath("//input[@class=\"button-1 search-box-button\"]");
	protected By validation=By.xpath("//a[text()='Health Book']");
	
	
	protected By books = By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[1]/a");
	protected By thirdBook = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div/div[2]/div[3]/div[2]/input");
	protected By shoppingCart = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
	protected By cartCount = By.xpath("//*[@id=\"topcartlink\"]/a/span[2]");
	protected By addToCartAllList = By.xpath("//div[@class='product-grid']/child::*");
	protected By addToCartButtonList = By.xpath("//input[@value='Add to cart']");
	
	
	protected By cart = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");
	protected By radioButton = By.xpath("//*[@id=\"termsofservice\"]");
	protected By checkoutButton = By.id("checkout");
	protected By checkout = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1");
    //billing address 
	protected By existingData = By.id("billing-address-select");
	protected By country = By.id("BillingNewAddress_CountryId");
	protected By city = By.id("BillingNewAddress_City");
	protected By address1 = By.id("BillingNewAddress_Address1");
	protected By zip = By.id("BillingNewAddress_ZipPostalCode");
	protected By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	protected By bAContinue = By.xpath("//*[@id=\"billing-buttons-container\"]/input");
	//shipping address
	protected By shippingAddressAssert = By.xpath("//label[contains(text(),'Select a shipping address from your address book or enter a new address.')]");
	protected By address = By.id("shipping-address-select");
	protected By inStore = By.id("PickUpInStore");
	protected By sAContinue = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
	//shipping method
	protected By ground = By.id("shippingoption_0");
	protected By nextAir = By.id("shippingoption_1");
	protected By day2 = By.id("shippingoption_2");	
	protected By sMContinue = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
	//payment method
	protected By cashClick = By.id("paymentmethod_0");
	protected By CheckMoney = By.id("paymentmethod_1");
	protected By creditClick = By.id("paymentmethod_2");
	protected By purchaseOrderClick = By.id("paymentmethod_3");
	protected By clickPMContinue = By.xpath("(//input[@type='button'])[5]");
	protected By paymentInformationAssert = By.xpath("//*[@id=\"checkout-payment-info-load\"]/div/div/div[1]/table/tbody/tr[1]/td[1]/label");
	//payment information
	protected By purchaseOrder = By.id("PurchaseOrderNumber");
	protected By cardType = By.id("CreditCardType");
	protected By holderName = By.id("CardholderName");
	protected By cardNumber = By.id("CardNumber");
	protected By month = By.id("ExpireMonth");
	protected By year = By.id("ExpireYear");
	protected By cardCode = By.id("CardCode");
	protected By continuePM = By.xpath("(//input[@type='button'])[6]");
	protected By confirmOrderSectionAssert = By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div[2]/div/form/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/span");
	//confirm order
	protected By continueCR = By.xpath("(//input[@type='button'])[7]");
	protected By orderDetails = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a");
	protected By confirmOrderAssert = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong");
	//order details
	protected By orderDetailsAssert = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1");
	
	
	protected By Books = By.xpath("(//a[contains(text(),'Books')])[1]");
	protected By product_1 = By.xpath("(//a[@href='/computing-and-internet'])[2]");
	
	protected By Apparel_and_Shoes = By.xpath("(//a[contains(text(),'Apparel & Shoes')])[1]");
	protected By product_2 = By.xpath("(//a[@href='/blue-and-green-sneaker'])[2]");
	
	protected By Jewelry = By.xpath("(//a[@href='/jewelry'])[1]");
	protected By product_3 = By.xpath("(//a[@href='/black-white-diamond-heart'])[2]");
	
	protected By Add_to_Cart = By.xpath("(//input[@value='Add to cart'])[1]");
	
	
	protected By Shopping_Cart = By.xpath("(//a[@class='ico-cart'])[1]");
	protected By product_check1 = By.xpath("(//input[@type='checkbox'])[1]");
	protected By product_check2 = By.xpath("(//input[@type='checkbox'])[2]");
	protected By product_check3 = By.xpath("(//input[@type='checkbox'])[3]");
	protected By update_cart = By.xpath("//input[@name='updatecart']");
	protected By cart_quantity = By.xpath("//span[@class='cart-qty']");
	
	
	protected By DigitalDownloadsLink=By.xpath("(//a[@href='/digital-downloads'])[1]");
	protected By AddToWishListButton=By.xpath("//input[@value='Add to wishlist']");
	protected By WishListLink=By.xpath("(//a[@href='/wishlist'])[1]");
	protected By ProductOneLink=By.xpath("//a[text()='3rd Album']");
	protected By RemoveCheckBoxPath=By.xpath("//input[@type='checkbox' and @name='removefromcart']");
	protected By UpdatePath=By.xpath("//input[@name='updatecart']");
	protected By EmptyWishList=By.className("wishlist-content");
	
}