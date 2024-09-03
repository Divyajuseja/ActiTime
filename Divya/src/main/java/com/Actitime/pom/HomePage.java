package com.Actitime.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    
	@FindBy(xpath ="//div[.='Tasks']")
	private WebElement taskelement;

	@FindBy(xpath ="//div [.='Reports']")
	private WebElement reportelement; 
	
	@FindBy(xpath ="//div [.='Users']")
	private WebElement Userelement; 
	
	@FindBy(id ="logoutLink")
	private WebElement Logoutlink; 
	
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}	
	
	public WebElement getTaskelement() {
		return taskelement;
	}
	public WebElement getReportelement() {
		return reportelement;
	}
	public WebElement getUserelement() {
		return Userelement;
	}
	public WebElement getLogoutlink() {
		return Logoutlink;
	}
	
}



