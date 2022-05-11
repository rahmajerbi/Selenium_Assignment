import org.openqa.selenium.interactions.Actions;
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


class LoginPage extends PageBase{

    private By emailBox= By.id("email");
    private By passwordBox =By.xpath("//*[@id='password']");

    public LoginPage(WebDriver driver ){
        super(driver);

    }

    public ProfilePage login(String userID, String password){
        this.waitAndReturnElement(emailBox).sendKeys(userID);
        this.waitAndReturnElement(passwordBox).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div/div/div/div[2]/form/div[2]/button[1]")).sendKeys(Keys.ENTER);
       //sendKeys(Keys.ENTER);
        return new ProfilePage(this.driver);

    }




}