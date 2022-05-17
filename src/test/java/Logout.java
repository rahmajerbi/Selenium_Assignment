import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.*;



class Logout extends PageBase{


    public Logout(WebDriver driver ){
        super(driver);

    }

   

    public MainPage logout(){
        

        return new MainPage(this.driver);

    }

    public String lougoutLink(){
        String expectedUrl= driver.getCurrentUrl();
        System.out.println(expectedUrl);
        return expectedUrl;
    }



}