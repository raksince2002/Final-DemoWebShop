package Method_Libraries;
 
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CustomExceptions.CheckoutFailedException;
 
public class AddToCartAndCheckout extends AddToCartAndValidation {
	
	public AddToCartAndCheckout() throws IOException {
		super();
	}

	public void shoppingCartPage() {
		log.info("Navigate to Shopping cart page");
		wd1.findElement(cart).click();
	}
	
	public void clickTermsAndConditions() throws CheckoutFailedException, IOException {
		try {			
			wd1.findElement(radioButton).click();
			wd1.findElement(checkoutButton).click();	
		}
		catch(Exception e) {
			c.init_common(wd1);
			throw new CheckoutFailedException("Checkout Failed");
		}
	}
	
	public String inCheckoutPage() {
		c.implicit_wait(10);
		String checkoutTitle = wd1.findElement(checkout).getText();
		System.out.println(checkoutTitle);
		return checkoutTitle;
	}
 
	//billing address
		public void existingAddress() throws InterruptedException {
			log.info("Entering existing address if any");
			WebElement address = wd1.findElement(existingData);
			Select data = new Select(address);
			if(r.read_cell(1, 12, 2).equals("New Address")) {
				data.selectByVisibleText("New Address");
			}
			else if(r.read_cell(1, 12, 2).equals("Existing Address")) {
				data.selectByVisibleText(r.read_cell(1, 0, 0)+" "+r.read_cell(1, 1, 0)+", "+r.read_cell(1, 2, 2)+", "+r.read_cell(1, 1, 2)+" "+r.read_cell(1, 3, 2)+", "+r.read_cell(1, 0, 2));
			}	
		}
	
	public void selectCountry() throws InterruptedException {
		log.info("Select country");
		WebDriverWait wait = new WebDriverWait(wd1, Duration.ofSeconds(5));
		WebElement countryList = wd1.findElement(country);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(countryList));
		element.click();
		Select countrySelected = new Select(countryList);
		countrySelected.selectByVisibleText(r.read_cell(1, 0, 2)); //Country
	}
	
	public void enterCity() {
		log.info("Enter city");
		wd1.findElement(city).sendKeys(r.read_cell(1, 1, 2)); //City
	}
	
	public void enterAddress1() {
		log.info("Enter address");
		wd1.findElement(address1).sendKeys(r.read_cell(1, 2, 2)); //Street
	}
	
	public void enterZipcode() {
		log.info("Enter zipcode");
		wd1.findElement(zip).sendKeys(r.read_cell(1, 3, 2)); //ZipCode
	}
	
	public void enterPhonenumber() {
		wd1.findElement(phoneNumber).sendKeys(r.read_cell(1, 4, 2)); //PhoneNumber
	}
	public void clickBAContinue() {
		wd1.findElement(bAContinue).click();
	}
	
	public String assertInShippingSection() {
		String actAssertText = wd1.findElement(shippingAddressAssert).getText();
		System.out.println(actAssertText);
		return actAssertText;
	}
	
	//shipping address
	public void existingShippingAddress() {
		log.info("Enter Shipping address");
		WebElement addressDropdown = wd1.findElement(address);
		addressDropdown.click();
		Select selectedAddress = new Select(addressDropdown);
		if(!r.read_cell(1, 13, 2).equals("StorePickup")) {	
			selectedAddress.selectByValue(r.read_cell(1, 0, 0)+" "+r.read_cell(1, 1, 0)+", "+r.read_cell(1, 2, 2)+", "+r.read_cell(1, 1, 2)+" "+r.read_cell(1, 3, 2)+", "+r.read_cell(1, 0, 2)); //DropDown
		}
	}
	
	public void inStorePickUp() {
		if(r.read_cell(1,13,2).equals("StorePickup")) {
			wd1.findElement(inStore).click();
		}
	}
	
	public void clickSAContinue() throws InterruptedException {
		System.out.println(wd1.getCurrentUrl());
		wd1.findElement(sAContinue).click();
	}
	
	//shipping method 
	public boolean smButtonAssert() throws InterruptedException {
		Boolean actdefaultSM = wd1.findElement(ground).isSelected();
		System.out.println(actdefaultSM);
		return actdefaultSM;	
	}
	
	public void clickShippingMethod() throws InterruptedException {
		log.info("Enter Shipping Method");
		if(r.read_cell(1, 14, 2).equals("Ground")) {
			wd1.findElement(ground).click();
		}
		else if(r.read_cell(1, 14, 2).equals("Next Day")) {
			wd1.findElement(nextAir).click();
		}
		else if(r.read_cell(1, 14, 2).equals("2nd Day")) {
			wd1.findElement(day2).click();
		}
	}
	
	public void clickSMContinue() {
		wd1.findElement(sMContinue).click();
	}
	
	//payment method
	public Boolean codAssert() throws InterruptedException {
		Boolean defaultClickAssert = wd1.findElement(cashClick).isSelected();
		return defaultClickAssert;
	}
	
	public void creditData() throws InterruptedException {
		log.info("Select credit card");
		wd1.findElement(creditClick).click();
	}
	
	public void clickPMContinue() {
		wd1.findElement(clickPMContinue).click();
	}
	
	public String inPaymentInformationSection() throws InterruptedException {
		log.info("Enter Payment information");
		String paymentInformationText = wd1.findElement(paymentInformationAssert).getText();
		System.out.println(paymentInformationText);
		return paymentInformationText;
	}
	
	//payment information
	public void selectCardType() throws InterruptedException {
		WebElement card = wd1.findElement(cardType);
		card.click();
		Select cardTypeDD = new Select(card);
		cardTypeDD.selectByVisibleText(r.read_cell(1, 5, 2)); //CardType
	}
	
	public void enterinvalidCardholderName() {
		wd1.findElement(holderName).sendKeys(r.read_cell(2, 6, 2)); //CardHolder
	}
	
	public void enterCardholderName() {
		wd1.findElement(holderName).sendKeys(r.read_cell(1, 6, 2)); //CardHolder
	}
	
	public void enterinvalidCardNumber() {
		wd1.findElement(cardNumber).sendKeys(r.read_cell(2, 7, 2));
		//CardNumber
	}
	
	public void enterCardNumber() {
		wd1.findElement(cardNumber).sendKeys(r.read_cell(1, 7, 2)); //CardNumber
	}
	
	public void selectMonthAndYear() {
		WebElement monthData = wd1.findElement(month);
		WebElement yearData = wd1.findElement(year);
		Select selectMonth = new Select(monthData);
		selectMonth.selectByValue(r.read_cell(1, 8, 2)); //Month
		Select selectYear = new Select(yearData);
		selectYear.selectByValue(r.read_cell(1, 9, 2)); //Year
	}

	
	public void enterinvalidCardCode() {
		wd1.findElement(cardCode).sendKeys(r.read_cell(2, 10, 2)); //CardCode
	}
	
	public void enterCardCode() {
		wd1.findElement(cardCode).sendKeys(r.read_cell(1, 10, 2)); //CardCode
	}
	
	public void clickPIContinue() {
		wd1.findElement(continuePM).click();
	}
	
	public void clearInvalidData() {
		wd1.findElement(holderName).clear();
		wd1.findElement(cardNumber).clear();
		wd1.findElement(cardCode).clear();
	}
	
	public String inConfirmOrderSection() {
		String confirmOrderText = wd1.findElement(confirmOrderSectionAssert).getText();
		System.out.println(confirmOrderText);
		return inConfirmOrderSection();	
	}
	
	//confirm order
	public void clickCOContinue() throws InterruptedException {
		wd1.findElement(continueCR).click();
	}
	
	public String inOrderConfirmationPage() throws InterruptedException {
		String confirmOrderDetails = wd1.findElement(confirmOrderAssert).getText();
		System.out.println(confirmOrderDetails);
		return confirmOrderDetails;
	}
	
	public void clickOrderDetailsLink() {
		wd1.findElement(orderDetails).click();
	}
	
	public String inOrderDetailsPage() throws InterruptedException {
		String orderDetailsPage = wd1.findElement(orderDetailsAssert).getText();
		System.out.println(orderDetailsPage);
		return orderDetailsPage;
	}
 
}