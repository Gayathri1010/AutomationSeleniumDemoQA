package SeleniumLevel1.AutomationChallenge;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import BaseComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	
	@Test(dataProvider = "dataFunction")
	public void StandaloneTest(HashMap<String, String> input){		
		ModalPage mp = hp.addRow();
		mp.addName(input.get("FirstName"), input.get("LastName"));       
		mp.addEmail(input.get("Email"));
		mp.addAge(input.get("Age"));
		mp.addSalary(input.get("Salary"));
		mp.addDept(input.get("Department"));
		mp.submit();
	}
	@Test(dataProvider = "rowDataFn")
	public void editRow(HashMap<String, String> input) {
		ModalPage mp = hp.editRow("2");
		mp.addSalary(input.get("Salary"));
		mp.addDept(input.get("Department"));
		mp.submit();
	}
	@DataProvider
	public Object[][] dataFunction() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumLevel1\\Data\\DataEntries.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	@DataProvider
	public Object[][] rowDataFn() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumLevel1\\Data\\editRow.json");
		return new Object[][] {{data.get(0)}};
	}
}
