package co.Roko.webdriver.king_ict;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class launchbrowser {
	public static WebDriver driver = null;
	static Boolean action_performed;
	static Boolean T = true;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String title = driver.getTitle();
		System.out.println(title);
		
		//open web app----------------------------------------------------------------------------------------------------------------------------
		driver.navigate().to("https://demoqa.com/books");
		driver.manage().window().maximize();
		System.out.println("Web opened");
		
		//LOGIN-----------------------------------------------------------------------------------------------------------------------------------
		WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(login).click().perform();
		
		action_performed = login.isDisplayed();
		
		Assert.assertEquals(action_performed, T);
		System.out.println("\n~~LOGIN passed~~\n");
		
		//user name
		String username_text = "RokoL";
		WebElement L_username = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		L_username.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[2]/input")).sendKeys(username_text);
		
		//password
		String password_text = "Selenium1234!";
		WebElement L_password = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		L_password.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[3]/div[2]/input")).sendKeys(password_text);
		
		WebElement login_btn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
		action.moveToElement(login_btn).click().perform();
		Thread.sleep(2000);
			
		//BOOK STORE------------------------------------------------------------------------------------------------------------------------------
		WebElement book_store = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]"));
		action.moveToElement(book_store).click().perform();
		
		action_performed = book_store.isDisplayed();
		
		Assert.assertEquals(action_performed, T);
		System.out.println("\n~~BOOK STORE passed~~\n");
		
		//search bar
		String searchBar_text = "Git";
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"searchBox\"]"));
		searchBar.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/input")).sendKeys(searchBar_text);
		Thread.sleep(2000);
		
		//book select
		WebElement book = driver.findElement(By.xpath("//*[@id=\"see-book-Git Pocket Guide\"]/a"));
		action.moveToElement(book).click().perform();
		Thread.sleep(2000);
		WebElement addBookToCollection = driver.findElement(By.xpath("//*[@id=\"addNewRecordButton\"]"));
		action.moveToElement(addBookToCollection).click().perform();
		Thread.sleep(2000);
		
		//PROFILE--------------------------------------------------------------------------------------------------------------------------------
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);
		
		WebElement profile = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[3]"));
		action.moveToElement(profile).click().perform();
		Thread.sleep(2000);
		
		WebElement delete_book = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/div[3]/button"));
		action.moveToElement(delete_book).click().perform();
		
		WebElement delete_bookOK = driver.findElement(By.xpath("//*[@id=\"closeSmallModal-ok\"]"));
		action.moveToElement(delete_bookOK).click().perform();
		
	}

}
