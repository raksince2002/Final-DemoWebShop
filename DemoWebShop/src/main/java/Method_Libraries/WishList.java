package Method_Libraries;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CustomExceptions.StaleElementReferenceException;
import CustomExceptions.TimeoutException;
 
public class WishList extends AddAndDelete
{
	
    public WishList() throws IOException {
		super();
	}

	//Click on 'Digital Downloads'
    public String ClickDigitalDownloads() throws InterruptedException
    {	
    	log.info("Click on Digital Downloads");
  	  WebElement DigitalDownloadsElement=wd1.findElement(DigitalDownloadsLink);
  	  DigitalDownloadsElement.click();
  	  String DigitalDownloadsTitle=wd1.getTitle();
  	  return DigitalDownloadsTitle;
    }
      
    //Add All Products into the WishList
    public void AddProducts()
    {
     //List of product URLs
    	log.info("Add All Products into the WishList");
       String[] productURLs= {p.getProperty("WishList1Url"),
    		   p.getProperty("WishList2Url"),
    		   p.getProperty("WishList3Url")};
     //Loop through each product URL and add to wishlist
          for (String url : productURLs)
            {
                 wd1.navigate().to(url); // Navigating to particular wishlist product URL
                 wd1.findElement(AddToWishListButton).click();
            }
    }
    //validate all products are add into the wishlist
    public String ValidateAllAddedProducts() throws StaleElementReferenceException, IOException
    {
    	log.info("validate all products are add into the wishlist");
    	wd1.get(p.getProperty("WishListUrl"));
  	    c.reload_page(); // refreshing the page
  	    try {
	  	    WebDriverWait wait = new WebDriverWait(wd1, Duration.ofSeconds(1000));
	  	    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-item-row")));
	  	    List <WebElement> add=wd1.findElements(By.className("cart-item-row"));
	  	    Integer product=add.size();
			return String.valueOf(product);
  	    }
  	    catch(Exception e) {
  	    	throw new StaleElementReferenceException("Stale elements are there");
  	    }
    }
    
    //Click on 'WishList'
    public String ClickWishList()
    {	
    	log.info("Click on WishList");
    WebElement WishList=wd1.findElement(WishListLink);
	WishList.click();
	String WishListTitle=wd1.getTitle();
	return WishListTitle;
	}
    
    //Remove a product from the WishList
    public void RemoveProduct() throws InterruptedException
    {
    	log.info("Remove a product from the WishList");
    	WebElement productToRemove=wd1.findElement(ProductOneLink);
    	productToRemove.findElement(RemoveCheckBoxPath).click();
    }
    //click on updateButton
    public void UpdatewishList()
    {
    	WebElement UpdateButton=wd1.findElement(UpdatePath);
    	UpdateButton.click();
    }
    
    //Check if the element is present in the WishList or not after removing
    public boolean ValidateProductAfterRemoving() throws TimeoutException, IOException
    {
    	try {
	    	WebDriverWait wait = new WebDriverWait(wd1,Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='wishlist-content']")));
	 
	    	List<WebElement> refetchproduct = wd1.findElements(ProductOneLink);
	    	if(refetchproduct.isEmpty())
	    	{
	    		System.out.println("Successfully Product Removed from the Wishlist");
	    		return true;
	    	}
	    	else
	    	{
	    		System.out.println("Product is not Removed from the Wishlist");
	    		return false;
	    	}
    	}
    	catch(Exception e) {
    		throw new TimeoutException("Timeout error");
    	}
	    
    }
    
    //Removing all product from the WishList
    public void RemoveAllProduct()
    {
    	log.info("Removing all product from the WishList");
    	List<WebElement> removeproduct= wd1.findElements(RemoveCheckBoxPath);
    	int size=removeproduct.size();
    	System.out.println(size);
    	for(WebElement product:removeproduct)
    	 {
    		 product.click();
    	 }
    }
    //validate empty wishlist
    public String ValidateEmptyWishList()
    {
    	String actual=wd1.findElement(EmptyWishList).getText();
    	c.close();
    	return actual;
    	
    }
 
}