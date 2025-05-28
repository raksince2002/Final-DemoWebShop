package Method_Libraries;

import java.io.IOException;

import CustomExceptions.LoginFailedException;

public class Login extends Register {
	
	public Login() throws IOException {
		super();
	}

	int i = 1;

	public void log_in() {
		log.info("Navigating to Login Page");
		wd1.findElement(log_in).click();
	}
	
	public void email() {
		log.info("Entering email");
		wd1.findElement(Email).sendKeys(r.read_cell(i, 0, 1));
	}
	
	public void password() {
		log.info("Entering password");
		wd1.findElement(Password).sendKeys(r.read_cell(i, 1, 1));
	}
	
	public void login() {
		log.info("Clicking Login button");
		wd1.findElement(Login).click();		
	}
	
	public boolean assert_login() throws LoginFailedException, IOException {
		log.info("Validating Login");
		boolean b = wd1.getPageSource().contains("Login was unsuccessful");
		if(b==true) {
			throw new LoginFailedException("Login Failed");
		}
		return b;
	}
	

}