package xeno.grofer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Login
{
	static WebDriver driver;
	Properties pro;
	locator loc=new locator();
	 public void openbrowserurl() throws IOException
	 {
		 
		 pro=new Properties();
		 FileInputStream input=new FileInputStream("C:\\Users\\sandeep\\Desktop\\Automation testing\\XENO\\src\\grofers.properties");
		 pro.load(input);
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\sandeep\\Desktop\\Automation testing\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(pro.getProperty("url"));   //open url
		 driver.findElement(By.xpath(loc.selectcity)).click();  //select location
		 
		 
      }
	 public void selectitem() throws InterruptedException
	 {
		 
			
		 
		 Thread.sleep(5000);
         driver.findElement(By.xpath(loc.firstpage)).click();  //clicl on page
         Thread.sleep(5000);
         driver.findElement(By.className(loc.item1)).click();    //item add to cart
         driver.findElement(By.className(loc.item2)).click();      //item add to cart
		 driver.findElement(By.xpath(loc.item3)).click();        //item add to cart
		 driver.findElement(By.xpath(loc.cart)).click();         //click on cart icon
		 driver.findElement(By.className(loc.placeorder)).click();  //click on placeorder
		 
		 
	 
	 }
	 


public static void main(String[] args) throws InterruptedException, IOException 
{
	Login l=new Login();
	l.openbrowserurl();
	l.selectitem();
}


}










//JavascriptExecutor js = (JavascriptExecutor) driver;
//Thread.sleep(5000);
//js.executeScript("window.scrollby(0,1000)");
// Actions act = new Actions(driver);
// Thread.sleep(5000);
// act.sendKeys(Keys.PAGE_DOWN).build().perform();