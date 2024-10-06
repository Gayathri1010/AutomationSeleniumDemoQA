package BaseComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumLevel1.AutomationChallenge.HomePage;

public class BaseTest {
	public WebDriver driver;
	public HomePage hp;
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumLevel1\\Data\\global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		return driver;		
	}
	public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException{
		String jsonContent = FileUtils.readFileToString(new File(filePath),Charset.defaultCharset());
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		return data;
	}
	@BeforeMethod(alwaysRun = true)
	public HomePage launchPage() throws IOException {
		WebDriver driver = initializeDriver();
		hp = new HomePage(driver);
		hp.gotoPage(driver);
		return hp;
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
