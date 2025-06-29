package pages;


	import java.util.Scanner;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class WindowsHandlePage {
	    WebDriver driver;

	    public WindowsHandlePage (WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(id = "newWindowBtn")
	    WebElement newWindowBtn;
	    
	    @FindBy(id = "newWindowMsg")
	    WebElement newWindowMsg;
	    
	    @FindBy(id = "newTabBtn")
	    WebElement newTabBtn;
	    
	    @FindBy(id = "newTabMsg")
	    WebElement newTabMsg;
	    
	    public void clickNewWindowButton() {
	        newWindowBtn.click();
	    }
	    public String getNewWindowMessage() {
	        return newWindowMsg.getText();
	    }	
	    public void clickNewTabButton() {
	        newTabBtn.click();
	    }	
	    public String getNewTabMessage() {
	        return newTabMsg.getText();
	    }
}
