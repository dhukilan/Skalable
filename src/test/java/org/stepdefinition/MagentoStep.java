package org.stepdefinition;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pom.Search;
import org.shortcut.BaseClass;

import io.cucumber.java.en.*;

public class MagentoStep extends BaseClass {
	
	String text1;
	String text;
	@Given("Has to launch the websit")
	public void has_to_launch_the_websit() throws InterruptedException {
	    browserLaunch("edge");
	    urlLaunch("https://magento.softwaretestingboard.com/");  
	    Thread.sleep(2000);
	}

	@When("Enter the product name in search bar")
	public void enter_the_product_name_in_search_bar() throws AWTException {
	    
		WebElement search = d.findElement(By.xpath("(//input[@class='input-text'])[1]"));
	    sendkeys(search, "zoltan gym tee");
	    WebElement btn = d.findElement(By.xpath("//button[@type='submit']"));
	    click(btn);
	   
	    
	    
	}

	@When("Choose the product,size,colour and then clik to add to cart")
	public void choose_the_product_size_colour_and_then_clik_to_add_to_cart() throws InterruptedException {
	    WebElement lando = d.findElement(By.xpath("//a[contains(text(),'Lando Gym Jacket')]"));
	    text1 = lando.getText();
	    System.out.println(text1);
	    click(lando);
	    Threadsleep(2000);
	    WebElement size = d.findElement(By.xpath("//div[text()='XS']"));
	    click(size);
	    WebElement color = d.findElement(By.xpath("(//div[@class='swatch-option color'])[3]"));
	    click(color);
	    Thread.sleep(2000);
	    WebElement addtocart = d.findElement(By.xpath("//button[@title='Add to Cart']"));
	    click(addtocart);
	    
	}

	@When("Click on cart proceed to checkout")
	public void click_on_cart_proceed_to_checkout() throws InterruptedException {
		Thread.sleep(5000);
	    WebElement mycart = d.findElement(By.xpath("//a[@class='action showcart']"));
	    click(mycart);
	    WebElement checkout = d.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
	    click(checkout);
	}

	@When("then fill the details and then click next")
	public void then_fill_the_details_and_then_click_next() throws InterruptedException {
		Threadsleep(3000);
	    WebElement email = d.findElement(By.xpath("(//input[@name='username'])[2]"));
	    sendkeys(email, "test12@gmail.com");
	    Threadsleep(3000);
	    WebElement Fname = d.findElement(By.xpath("//input[@name='firstname']"));
	    sendkeys(Fname, "test12");
	    WebElement Lname = d.findElement(By.xpath("//input[@name='lastname']"));
	    sendkeys(Lname, "test12");
	    WebElement company = d.findElement(By.xpath("//input[@name='company']"));
	    sendkeys(company, "Skalable");
	    WebElement street = d.findElement(By.xpath("//input[@name='street[0]']"));
	    sendkeys(street, "4300 STEVENS CREEK BLVD");
	    WebElement city = d.findElement(By.xpath("//input[@name='city']"));
	    sendkeys(city, "San Jose");
	    Threadsleep(2000);
	    WebElement state = d.findElement(By.xpath("//select[@name='region_id']"));
	    selectedByIndex(state, 24);
	    WebElement zip = d.findElement(By.xpath("//input[@name='postcode']"));
	    sendkeys(zip, "95129");
	    WebElement country = d.findElement(By.xpath("//select[@name='country_id']"));
	    selectByVisibleText(country, "United States");
	    WebElement phone = d.findElement(By.xpath("//input[@name='telephone']"));
	    sendkeys(phone, "4087571000");
	    WebElement shipping = d.findElement(By.xpath("//input[@name='ko_unique_1']"));
	    click(shipping);
	    WebElement next = d.findElement(By.xpath("//button[@data-role='opc-continue']"));
	    click(next);
	}

	@Then("Get the order num")
	public void get_the_order_num() throws InterruptedException {
		Threadsleep(3000);
		WebElement place = d.findElement(By.xpath("//button[@class='action primary checkout']"));
		click(place);
		Threadsleep(2000);
		WebElement ord = d.findElement(By.xpath("//p[contains(text(),'Your order')]"));
	    text = ord.getText();
		System.out.println(text1+"="+text);
		
	    quit();
	}

}
