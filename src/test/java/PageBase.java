import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.awt.event.KeyEvent;


class PageBase {
     protected WebDriver driver;
     protected WebDriverWait wait;


     public PageBase(WebDriver driver){
         this.driver=driver;
         this.wait= new WebDriverWait (driver,10);

     }

     protected WebElement waitAndReturnElement(By locator){
          this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
          return this.driver.findElement(locator);
     }

    public String getBodyText(){
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
        
    }






}