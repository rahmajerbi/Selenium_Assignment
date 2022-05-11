import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.awt.event.KeyEvent;
import java.awt.*;




class EditProfile extends PageBase{

        
        private  By EP=By.xpath(("//*[@id='app']/div[1]/div/div/div[1]/div[2]/a")); 
        private WebDriverWait wait;
        //private By DownloadB = By.xpath("//*[@id='app']/div[1]/div/div/div[2]/div[2]/div[2]/div[1]/a[1]");
        private final  By skillsS=By.xpath("//*[@id='app']/div[1]/div/div/div[2]/div[2]/div[1]/h3[2]/a");   
        private By bodyLocator = By.tagName("body");
        // drop down button to perform logout 
        private By DD=By.xpath("//div[@class='navbar-user']/span/a[@class='caret d-none d-lg-inline-block']");

    

    public EditProfile(WebDriver driver){
        super(driver);
    }
    public String SkillsEdit(){
         // Go to skills , and here we applyhovering test by choosing between suggested skills options 
        WebElement skills=this.waitAndReturnElement(skillsS);
        //JavascriptExecutor is required for scrolling up and down the webpage 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",skills);
        skills.click();
        this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div[2]/div"));
        this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div[2]/div")).click();
        try{Thread.sleep(2000); } catch(Exception e){System.out.println(e); }
         //Instantiate Action Class        
        Actions actions = new Actions(driver);
        //Retrieve WebElement1 to perform mouse hover 
    	WebElement menuOption1 = this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div[2]/div/div[3]/ul/li[2]/span"));
    	//Mouse hover menuOption1 
    	actions.moveToElement(menuOption1).perform();
        try{Thread.sleep(2000); } catch(Exception e){System.out.println(e); }
    	//Now Select webelement2
    	WebElement MenuOption2 = this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[1]/div[1]/div/div/div[2]/div/div[3]/ul/li[1]/span")); 
    	//Mouse hover menuOption2
    	actions.moveToElement(MenuOption2).perform();

    	//Now Select 'Alternative1' from drop down menu which has got displayed on mouse hover of 'Data Analytics'
    	MenuOption2.click();
        
        this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[1]/div[1]")).click();
        //save added skill
        WebElement saveChanges= this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[2]/button[1]"));
        //save changes
        saveChanges.sendKeys(Keys.ENTER);
        try{Thread.sleep(3000); } catch(Exception e){System.out.println(e); }

        //js.executeScript("arguments[0].scrollIntoView()",EP);
        this.waitAndReturnElement(By.xpath("//*[@id='app']/div[1]/div/div/div[2]/div[1]/div[2]/div[3]/a")).click();
        //editprofile.click();
        // explicit wait - to wait for the container to be click-able
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gender")));
        // Edi first name ONLY 
       // WebElement body4= this.waitAndReturnElement(bodyLocator);
        this.waitAndReturnElement(By.id("firstname")).clear();
        this.waitAndReturnElement(By.id("firstname")).sendKeys("HARRY");
        //Changing profile picture through uploading it fromgiven file path
        System.out.println("got here");
        WebElement ProfilePic = this.driver.findElement(By.xpath("//*[@id='modals-container']/div/div/div[2]/div/div[2]/form/div[1]/div[3]/div/div/div/div/div[1]/div/div/div[2]/input"));
        //ProfilePic.click();
        System.out.println("got here too");

        String path = System.getProperty("user.dir") + "\\src\\beach.jpg" ;
        ProfilePic.sendKeys(path);
      System.out.println("photo added");
        // choose gender option from drop down
        this.waitAndReturnElement(By.xpath("//*[@id='modals-container']/div[2]/div/div[2]/div/div[1]/a")).click();
        Select dropdown = new Select(this.waitAndReturnElement(By.id("gender")));
        dropdown.selectByVisibleText("Female");
        System.out.println("gender added");
        
        // filling birth dates
        Select BY = new Select(this.waitAndReturnElement(By.id("birth_year")));
        BY.selectByVisibleText("1997");
        
        Select BM = new Select(this.waitAndReturnElement(By.id("birth_month")));
        BM.selectByVisibleText("May");
       
        Select BD = new Select(this.waitAndReturnElement(By.id("birth_day")));
        BD.selectByVisibleText("20");
        System.out.println("birthday added");
        // save changes 
        WebElement save= this.waitAndReturnElement(By.xpath("//div[@class='buttons-container']/button[@class='btn btn-primary']"));
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].scrollIntoView()", save);
        save.click();
        System.out.println("saved");
        return "skill successfully added!";
    }

     public Logout logout(){
           
            WebElement dropD= this.waitAndReturnElement(DD); 
            dropD.click();
            //try{Thread.sleep(1000); }catch(Exception e){System.out.println(e);}
            this.waitAndReturnElement(By.xpath("//div[@class='navbar-user']/ul/li/svg/a[@href='https://zyntern.com/logout']")).click();
            System.out.println("logged Out");
            //try{Thread.sleep(1000); }catch(Exception e){System.out.println(e);}

        return new Logout(this.driver);
    }

  


}