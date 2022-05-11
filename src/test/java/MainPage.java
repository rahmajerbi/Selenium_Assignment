import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import java.io.File; 
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.KeyEvent;
import java.awt.*;
class MainPage extends PageBase{

     private By LoginType=By.id("logSelect");
     private By LoginType1=By.xpath("//*[@id='user_navbar']/div/div[2]/div[2]/div/a[1]/span");
     

    public MainPage(WebDriver driver){
        super(driver);
        this.driver.get("https://zyntern.com/");

    }
   
    public LoginPage openLogin(){
        this.waitAndReturnElement(LoginType).click();
        this.waitAndReturnElement(LoginType1).click();
        return new LoginPage(this.driver);
    }



}