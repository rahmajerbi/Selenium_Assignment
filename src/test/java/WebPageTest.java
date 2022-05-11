import org.junit.*;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebPageTest{

    public WebDriver driver;

    @Before
         public void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        
    }

    @Test 
    public void SearchTest(){
        MainPage mainpage = new MainPage(this.driver);
        LoginPage loginpage = mainpage.openLogin();
        ProfilePage profilepage= loginpage.login("rahmajertun@gmail.com","Testingprofile1");
        //Assert.assertTrue(profilepage.getMainCardTitle().contains("Remember me"));

    
       JobsPage jobspage = profilepage.openJobs();
       String  output= jobspage.getJobs();
       EditProfile editprofile= jobspage.moveToEdit();
       String skillAdded= editprofile.SkillsEdit();
       Logout logOut= editprofile.logout();

         Assert.assertTrue(output.equals("filter applied successfully"));
         Assert.assertTrue(skillAdded.equals("skill successfully added!"));
         //Assert.assertTrue((moveToInfo.fillFields()).equals("form filled and picture updated"));
        
      
    } 
    @After
    public void close() {
        if (driver != null) {
             driver.close();
        }
    }




}