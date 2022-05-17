import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;
import java.util.concurrent.TimeUnit;


class ProfilePage extends PageBase{
    private  By profile= By.xpath("//*[@id='app']");
    private By JobsMenuButton= By.xpath("//*[@id='menu']/ul/li[10]");
    

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    public String getMainCardTitle(){         
        //System.out.println(this.waitAndReturnElement(profile).getText());
        return this.waitAndReturnElement(profile).getText();
    }

    
    
    public JobsPage openJobs(){
        this.waitAndReturnElement(JobsMenuButton).click();

        return new JobsPage(this.driver);
    }
}