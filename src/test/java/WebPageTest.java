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
    public void ProjectTest(){
        //OPEN MAIN WEBSITE PAGE 
        MainPage mainpage = new MainPage(this.driver);
        //GET TO LOGIN PAGE 
        LoginPage loginpage = mainpage.openLogin();
        //STORE LINK OF LOGIN PAGE TO VERIFY IT IS THE RIGHT LOGIN TYPE
        String logintestlink= mainpage.LoginTestLink();    
        //GET TO PROFILE PAGE THROUGH INSERTING CREDENTIALS
        ProfilePage profilepage= loginpage.login("rahmajertun@gmail.com","Testingprofile1");
        //STORE TITLE OF PROFILE PAGE FOR TESTING PURPOSES
        String Title= profilepage.getMainCardTitle();
        //GET TO JOBS PAGE
        JobsPage jobspage = profilepage.openJobs();
        // STORE OUTPUT OF MAIN METHOD FOR TESTING PURPOSES
        String  output= jobspage.getJobs();
        // GET TO PROFILE PAGE AGAIN THROUGH DROPDOWN MENU FROM JOBS PAGE
        EditProfile editprofile= jobspage.moveToEdit();
        // STORE OUTPUT OF MAIN METHOD IN EDITPROFILE CLASS FOR TESTING PURPOSES(TO VERIFY WHETHER DATA IS CHANGED AND SAVED)
        String dataAdded= editprofile.FillForm();  
        // LOGOUT AND GET TO MAIN PAGE AGAIN (THROUGH DROPDOWN)
        Logout logOut= editprofile.logout();
        //STORE LINK OF LAST PAGE WE GET TO TO VERIFY WHETHER IT IS THE MAIN PAGE (FIRST ONE)
        String lougoutlink=logOut.lougoutLink();

        Assert.assertEquals(logintestlink,"https://zyntern.com/student-login");
        Assert.assertTrue(Title.contains("Applying for jobs"));
        Assert.assertTrue(output.equals("filter applied successfully"));
        Assert.assertTrue(dataAdded.equals("Profile successfully edited!"));
        Assert.assertTrue(lougoutlink.equals("https://zyntern.com/"));
    
    } 
    @After
    public void close() {
        if (driver != null) {
             driver.close();
        }
    }




}