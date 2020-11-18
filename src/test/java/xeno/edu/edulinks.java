package xeno.edu;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverAction;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class edulinks 
{
	
	static WebDriver driver;
	Properties pro;
	public void openbrowserurl() throws IOException
	 {
		 pro=new Properties();
		 FileInputStream input=new FileInputStream("C:\\Users\\sandeep\\Desktop\\Automation testing\\XENO\\src\\grofers.properties");
		 pro.load(input);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sandeep\\Desktop\\Automation testing\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(pro.getProperty("url2"));
		
	 }
	
	public void allinks() throws InterruptedException
	{
		
		List<WebElement> tags=driver.findElements(By.tagName("a"));
		int num=tags.size();
		System.out.println(num);
		for(int i=0;i<=tags.size();i++)
		{
			for(WebElement l:tags)
			{
				 try {
					 if(l.getText()!="")
				 
				    {
					  Actions action = new Actions(driver); // I have added these lines
					  Thread.sleep(3000);
		                action.keyDown(Keys.CONTROL).moveToElement(l).click().perform();
		                Thread.sleep(3000);
		                action.keyUp(Keys.CONTROL).perform();
				    }
				 }catch(Exception e) {
					 
				 }
			}
		}
		
	    
	}
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		edulinks ed=new edulinks();
		ed.openbrowserurl();
		ed.allinks();
		
		
		
		
	}
	

}
