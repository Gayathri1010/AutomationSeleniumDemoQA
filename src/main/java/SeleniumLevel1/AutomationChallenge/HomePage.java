package SeleniumLevel1.AutomationChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	String x;
	public HomePage(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
 	@FindBy(xpath = "//div[@class='action-buttons']")
	WebElement rowEditBtn;
	@FindBy(id="addNewRecordButton")
	WebElement addNewRow;
	public ModalPage editRow(String rowNo) {
		WebElement rowEdit=rowEditBtn.findElement(By.xpath("//span[@id='edit-record-"+rowNo+"']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", rowEdit);
		ModalPage mp = new ModalPage(driver);
		return mp;	
	}
	public ModalPage addRow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", addNewRow);
		ModalPage mp = new ModalPage(driver);
		return mp;
	}
	public void gotoPage(WebDriver driver) {
		driver.get("https://demoqa.com/webtables");
	}	
}
