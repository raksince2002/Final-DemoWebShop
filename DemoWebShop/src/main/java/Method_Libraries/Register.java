package Method_Libraries;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

import CustomExceptions.RegistrationFailedException;
import driverfactory.DriverFactory;
import util.CommonTestMethods;
import util.Xpaths;
 
public class Register extends Xpaths {

	public static Logger log;
	
	public Register() throws IOException {
		super();
		log = (Logger) LogManager.getLogger(Register.class);
	}

	String url = p.getProperty("baseUrl");
	boolean asse_rt = false;
	String Firstname;
	String Lastname;
	String Emailid;
	String password;
	String Confirmpassword;

	protected WebDriver wd1;
	
	public void launch() {
		wd1=DriverFactory.getinstance();
		c.init_common(wd1);
		if(!(url.equals(wd1.getCurrentUrl()))) {			
			c.launch(url);
			c.Maximize_Browser();
		}
		c.implicit_wait(10);
	}	
		
	public void registerLink() {
		log.info("Navigating to Register");
		wd1.findElement(register).click();
	}
	
	public void erase(){
		wd1.findElement(genderFemale).click();
		wd1.findElement(firstname).clear();
		wd1.findElement(lastname).clear();
		wd1.findElement(Email).clear();
		wd1.findElement(Password).clear();
		wd1.findElement(confirmPassword).clear();
	}
	
	public  void retrive() throws IOException, RegistrationFailedException {
		int rows = r.total_rows(0);
		for(int i=1;i<=rows-1;i++) {
			//read data from excel
			radioGender();
			Firstname = r.read_cell(i,0,0);
			firstName();
			Lastname = r.read_cell(i,1,0);
			lastName();
			Emailid = r.read_cell(i,2,0);
			emailid();
			password = r.read_cell(i,3,0);
			password();
			Confirmpassword = r.read_cell(i,4,0);
			conPassword();
			regButton();
			if(wd1.getPageSource().contains("Your registration completed")) {
				asse_rt = wd1.getPageSource().contains("Your registration completed");
				asse_rt = true;
				validate();
				r.set_cell(i, 8, "Passed", 0);
				wd1.findElement(Continue).click();
				break;
			}
			else if(wd1.getPageSource().contains("The specified email already exists")){
				asse_rt = wd1.getPageSource().contains("The specified email already exists");
				asse_rt = false;
				validate();
				r.set_cell(i, 8, "Failed", 0);
				erase();
			}
			else {
				asse_rt = wd1.getPageSource().contains("First name is required.");
					asse_rt = false;
					validate();
					r.set_cell(i, 8, "Failed", 0);
					erase();
			}
	}
}	
	
	public void radioGender() {
		log.info("Selecting Male Gender");
		wd1.findElement(genderFemale).click();
	}
	
	public void firstName() {
		log.info("Entering firstname");
		wd1.findElement(firstname).sendKeys(Firstname); //Firstname 
	}
	
	public void lastName() {
		log.info("Entering lastname");
		wd1.findElement(lastname).sendKeys(Lastname); //LastName 
	}
	
	public void emailid() {
		log.info("Entering email");
		wd1.findElement(Email).sendKeys(Emailid); //Email 
	}
	
	public void password() {
		log.info("Entering password");
		wd1.findElement(Password).sendKeys(password); //Password 	
	}
	
	public void conPassword() {
		log.info("Entering confirmPassword");
		wd1.findElement(confirmPassword).sendKeys(Confirmpassword); //ConfirmPassword
	}
	
	public void regButton() {
		log.info("Clicking Register button");
		wd1.findElement(registerbutton).click();
	}
	
	public boolean validate() throws RegistrationFailedException {
		try {
			if(asse_rt == false) {
				throw new RegistrationFailedException("Registeration Failed");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return asse_rt;
	}
		
}


