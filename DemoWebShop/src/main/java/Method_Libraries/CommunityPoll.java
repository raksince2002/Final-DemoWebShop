package Method_Libraries;
import java.io.IOException;
import java.time.Duration;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CommunityPoll extends NewsLetter {
	
	public CommunityPoll() throws IOException {
		super();
	}

	public void log_out() {
		log.info("Logging out from website");
		wd1.findElement(logout).click();
	}
	
	public void selectvoteoptions() {
		 WebElement polloption1=wd1.findElement(polloption);
		 log.info("Clicking on one of the options for the poll");
		 polloption1.click();
	}
	
	public boolean reguservote() {
		WebDriverWait w = new WebDriverWait(wd1,Duration.ofSeconds(10));
		log.info("Asserting text message after voting out without logging into the website");
		boolean b = w.until(ExpectedConditions.textToBe(pollerror,r.read_cell(1, 3, 3)));
		return b;
	}
	
	public void regandlogin() {
		log.info("Logging into the website for polling again");
		wd1.findElement(log_in).click();
		wd1.findElement(Email).sendKeys(r.read_cell(1, 0, 1)); //Email
		wd1.findElement(Password).sendKeys(r.read_cell(1, 1, 1)); //Password
		wd1.findElement(Login).click();
	}
	
	public void clickvote() {
		log.info("Asserting text message after voting out with the user logged in");
		wd1.findElement(clickvote).click();
	}
	
	public boolean assert_vote() {
		try {
			WebDriverWait w = new WebDriverWait(wd1,Duration.ofSeconds(10));
			boolean b = w.until(ExpectedConditions.textToBe(pollerror,r.read_cell(1, 3, 3)));
			return b;		
		}
		catch(Exception e) {
			throw new TimeoutException("Timeout occured");
		}
	}
	
	
	
}