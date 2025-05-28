package Method_Libraries;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class AddToCartAndValidation extends Search {
	
	public AddToCartAndValidation() throws IOException {
		super();
	}

	public void clickBooks() {
		log.info("Navigating to books section");
		wd1.findElement(books).click();
	}
	
	public boolean assertAddToCartButton() {
		log.info("Confirming all books having addtocart");
		List<WebElement> l = wd1.findElements(addToCartAllList);
		List<WebElement> l1 = wd1.findElements(addToCartButtonList);
		return l.size()==l1.size();
	}
	
	public void thirdBook() {
		log.info("Adding third book into the cart");
		wd1.findElement(thirdBook).click();
	}
	
	public boolean cartCountAssert() throws InterruptedException {
		log.info("Counting number of books that are added into the cart");
		WebDriverWait w = new WebDriverWait(wd1,Duration.ofSeconds(10));
		boolean count = w.until(ExpectedConditions.textToBe(cartCount, r.read_cell(1, 2, 3)));
		return count;
	}
	
	
}