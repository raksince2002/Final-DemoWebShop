package Method_Libraries;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsLetter extends Login {

    public NewsLetter() throws IOException {
		super();
	}

	public void enter_email() {
		 log.info("Entering Email for subscribing to NewsLetter");
    	 wd1.findElement(emailField).sendKeys(r.read_cell(1, 0, 1)); //Email
    }
    
    public void click_subscribe() {
    	log.info("Clicking on subscribe");
    	wd1.findElement(subscribe).click();
    }
    
    public boolean result() {
    	log.info("Asserting text message after subscribing");
    	try {
    		WebDriverWait w = new WebDriverWait(wd1, Duration.ofSeconds(10));
    		boolean b = w.until(ExpectedConditions.textToBe(By.id("newsletter-result-block"),r.read_cell(1, 0, 3)));
    		return b;
    	}
    	catch(Exception e) {
    		throw new TimeoutException("Timeout occured");
    	}
    }
    
    public void multiple_register() {
    	log.info("Refreshing page and entering same email again for subscribing");
        c.reload_page();
    	wd1.findElement(emailField).sendKeys(r.read_cell(1, 0, 1));
    }
    
    public void subscribe_click() {
    	log.info("Clicking on subscribe");
    	wd1.findElement(subscribe).click();
    }
    
    public boolean error_result() {
    	log.info("Asserting text message after subscribing again");
    	try {
    		WebDriverWait w = new WebDriverWait(wd1, Duration.ofSeconds(10));
    		boolean b = w.until(ExpectedConditions.textToBe(By.id("newsletter-result-block"),r.read_cell(1, 1, 3)));
    		return b;
    	}
    	catch(Exception e) {
    		throw new TimeoutException("Timeout occured");
    	}
    }
 
    
}