import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File; 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.awt.event.KeyEvent;
import java.awt.*;


class JobsPage extends PageBase{

    private By search= By.xpath("//*[@id='app']/div[1]/div/div[1]/div[2]/div/div/div[1]/div[1]");
    private   By StudentStatus = By.xpath("//*[@id='app']/div[1]/div/div[1]/div[2]/div/div/div[1]/div[8]/a");
    private  By languages = By.xpath("//*[@id='app']/div[1]/div/div[1]/div[2]/div/div/div[1]/div[7]/a");
    private   By DD=By.xpath("//*[@id='user_navbar']/div/div[2]/div[2]/span/a[2]");
    private   By EP=By.xpath(("//*[@id='app']/div[1]/div/div/div[1]/div[2]/a"));
    private  By searchLocator = By.xpath("//*[@id='search']");
    private By bodyLocator = By.tagName("body");
    private  By skillsS=By.xpath("//*[@id='app']/div[1]/div/div/div[3]/div[2]/div[1]/h3[2]/a/svg/path");   
    public JobsPage(WebDriver driver){
        super(driver);
    }

    public String getJobs(){
           
        // look in search toddler for 'Morgan Stanley' company for example 
        WebElement SearchEl = this.waitAndReturnElement(search);
        SearchEl.click(); 
        WebElement searchBarElement = this.waitAndReturnElement(searchLocator);
        searchBarElement.sendKeys("Morgan Stanley\n");

        // applying student status filter through a radio button
        WebElement StudentSt = this.waitAndReturnElement(StudentStatus);
        StudentSt.click();
        WebElement radio = this.waitAndReturnElement(By.id("student-1"));
        radio.click();
        WebElement radio2 = this.waitAndReturnElement(By.xpath("//*[@id='student-0']"));
        radio2.click();

        // Filter on required languages through check boxes in the drop down 
        WebElement Lang = this.waitAndReturnElement(languages);
        Lang.click();
        // Selecting CheckBox		
        WebElement checkB = this.waitAndReturnElement(By.id("languages-160"));							
        // This will Toggle the Check box 		
        checkB.click();

        WebElement checkB2 = this.waitAndReturnElement(By.id("languages-215"));		
        checkB2.click();
        // clicking on apply to save the filter 
        WebElement applyB= this.waitAndReturnElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div[2]/div/div/div[1]/div[7]/div/div[3]/a[1]"));       
        applyB.sendKeys(Keys.ENTER); 

            return "filter applied successfully";

     }

     public  EditProfile moveToEdit(){
        this.waitAndReturnElement(DD).click();
        //Chooose edit profile option
        WebElement profileE = this.waitAndReturnElement(By.xpath("//*[@id='user_navbar']/div/div[2]/div[2]/ul/li[1]/a"));	
        profileE.click();
        try{Thread.sleep(2000); } catch(Exception e){System.out.println(e); }
        WebElement body= waitAndReturnElement(bodyLocator);
        return new EditProfile(this.driver);
    }

    



}