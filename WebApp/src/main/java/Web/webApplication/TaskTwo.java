package Web.webApplication;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TaskTwo {
	
	
	 private WebDriver driver;

	  @BeforeClass
	  public void beforeClass() {
		  
		 
	      driver = new ChromeDriver();
	      
	     
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	  }

	 

	  @Test
	  public void navigate() {

		  String url="http://www.way2automation.com/angularjs-protractor/webtables/";

	      driver.get(url);

	  }
	  
	  @Test(priority=1)
	  void verifyTableList(){
		  
		  
		  String header_text = "First Name";
	      WebElement table_header = driver.findElement(By.xpath("/html/body/table/thead/tr[3]/th[1]/span"));
	      														
	      String text = table_header.getText();

	      Assert.assertEquals(text, header_text, "Text not found!");
	  }
	
	  
	  @Test(priority=2)
	public  void ClickAddUser() {
		  
driver.findElement(By.cssSelector("body > table > thead > tr:nth-child(2) > td > button")).click();


	  }
	  
	  @Test(priority=3)
	  public void verifyAddUser() {
		  
		  String header = "Add User";
	      WebElement add = driver.findElement(By.xpath("/html/body/div[3]/div[1]/h3"));
	      														
	      String text = add.getText();

	      Assert.assertEquals(text, header, "Text not found!");
		  
		  
	  }
	  
	  
	  
	  
	  @Test(priority=4)
	  public void createUsers() throws IOException {
		  
		 reader data = new reader();
		  
		  
		  ArrayList<String> FirstNAme = data.MyExcel(0);
		  ArrayList<String> LastName =data.MyExcel(1);
		  ArrayList<String> UserName = data.MyExcel(2);
		  ArrayList<String> Password = data.MyExcel(3);
		  ArrayList<String> Customer = data.MyExcel(4);
		  ArrayList<String> Role = data.MyExcel(5);
		  ArrayList<String> Email = data.MyExcel(6);
		  ArrayList<String> CellPhone = data.MyExcel(7);
		  
		  
		  for(int i =0; i<FirstNAme.size(); i++) {
			  
		UniqueUsername(UserName.get(i));
		
		
		 driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[1]/td[2]/input")).clear();
		 driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[1]/td[2]/input")).sendKeys(FirstNAme.get(i));
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[2]/td[2]/input")).clear();
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[2]/td[2]/input")).sendKeys(LastName.get(i));
 
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[3]/td[2]/input")).clear();
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[3]/td[2]/input")).sendKeys(UserName.get(i));
		  	  
		  
		  
		 
			String Mycustomer = Customer.get(i);
			if(Mycustomer.contains("AAA")) {
				 driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/label[1]/input")).click(); 
			  
		  }else if(Mycustomer.contains("BBB")){
			  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[5]/td[2]/label[2]/input")).click();
		  }else {
			
			System.out.println(" invalid customer");
			  break;
		  }
		  
		  
		  
		  driver.findElement(By.name("RoleId")).click();
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		  String R = Role.get(i);
		 
		  
		  
		  
		  if(R.contains("Customer")) {
			  
		  
		  Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/select")));
		  dropdown.selectByVisibleText("Customer");
		  
		  }else if(R.contains("Admin")) {
			  
		  
			  Select drop = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/select")));
			  drop.selectByVisibleText("Admin");  
			  
		  }else if(R.contains("Sales Team")) {
			  Select dropdow = new Select(driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/select")));
			  dropdow.selectByVisibleText("Sales Team");
			  
		  }else{
			  System.out.println("Invalid role !!");
			  }
		  
		  
		  
		 
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[4]/td[2]/input")).clear();
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[4]/td[2]/input")).sendKeys(Password.get(i));
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[7]/td[2]/input")).clear();
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[7]/td[2]/input")).sendKeys(Email.get(i));
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[8]/td[2]/input")).clear();
		  driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/table/tbody/tr[8]/td[2]/input")).sendKeys(CellPhone.get(i));
		  
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[2]")).click();
		  
		  ClickAddUser();
		  
		  }
		  
		  driver.findElement(By.xpath("/html/body/div[3]/div[3]/button[1]")).click();
		  System.out.println();
	
	  }
	  
	  
	  
	  
	 @Test(priority=5)
	  
	  public void UniqueUsername(String username) {
		  
			
			int br[]= new int [7];
			System.out.println(username);
			
			
			
			for(int i=1; i<tr.length;i++ ) {
				
				br[i]=i;
				
				String tk = driver.findElement(By.xpath("/html/body/table/tbody/tr["+tr[i]+"]/td[3]")).getText();
				
				
			if(username.contains(tk)) {
				System.out.println("user name is repeated!!");
				break;
				
			}

			}
		  
			System.out.println("user succesful added");

	  }


	}
	  
	  
	 
	  

	  
  

