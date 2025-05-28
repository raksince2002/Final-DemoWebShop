package Method_Libraries;

import java.io.IOException;

public class Search extends CommunityPoll {
	
	public Search() throws IOException {
		super();
	}
	
	public void writetext() {
		log.info("Searching the product");
		wd1.findElement(searchkeyword).sendKeys(r.read_cell(1, 2, 1));
	}
	
	public void click() {
		log.info("Clicking search button");
		wd1.findElement(searchbuttonclick).click();
	}
	 
	public String Validate() {
		log.info("Validating book is present or not");
		String Booktext=wd1.findElement(validation).getText();
		return Booktext;
	}
}