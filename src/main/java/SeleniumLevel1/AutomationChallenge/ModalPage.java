package SeleniumLevel1.AutomationChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalPage {
	WebDriver driver;
	
	public ModalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//form//input[@id='firstName']")
	WebElement firstName;
	@FindBy(xpath="//form//input[@id='lastName']")
	WebElement lastName;
	@FindBy(xpath="//form//input[@id='userEmail']")
	WebElement email;
	@FindBy(xpath="//form//input[@id='age']")
	WebElement age;
	@FindBy(xpath="//form//input[@id='salary']")
	WebElement salary;
	@FindBy(xpath="//form//input[@id='department']")
	WebElement dept;
	@FindBy(id="submit")
	WebElement submitBtn;
	public void addName(String fName, String lName) {
		firstName.clear();
		firstName.sendKeys(fName);
		lastName.clear();
		lastName.sendKeys(lName);
	}
	public void addEmail(String uEmail) {
		email.clear();
		email.sendKeys(uEmail);
	}
	public void addAge(String uAge) {
		age.clear();
		age.sendKeys(uAge);
	}
	public void addSalary(String uSalary) {
		salary.clear();
		salary.sendKeys(uSalary);
	}
	public void addDept(String uDept) {
		dept.clear();
		dept.sendKeys(uDept);
	}
	public void submit() {
		submitBtn.click();
	}
}
