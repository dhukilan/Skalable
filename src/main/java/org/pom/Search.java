package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.shortcut.BaseClass;

public class Search extends BaseClass {
	
	public Search() {
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="(//input[@class='input-text'])[1]")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btn;

	public WebElement getBtn() {
		return btn;
	}
	

}
